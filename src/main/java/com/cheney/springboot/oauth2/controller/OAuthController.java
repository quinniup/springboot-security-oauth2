package com.cheney.springboot.oauth2.controller;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/***
 **
 ** @Author: CheneyHao
 ** @Description:
 ** @Date:Created in 11:16 2018/6/5
 ** @Modified By:
 **
 ****/
@Controller
@SessionAttributes({"authorizationRequest"})
public class OAuthController {
    @RequestMapping("/login")
    public String login(Model model, @RequestParam(value = "error", required = false) String error) {
        if (error != null) {
            model.addAttribute("error", "用户名或密码错误");
        }
        return "static/login_page";
    }


        @RequestMapping({ "/oauth/my_approval_page" })
        public String getAccessConfirmation(Map<String, Object> model, HttpServletRequest request) throws Exception {
            @SuppressWarnings("unchecked")
            Map<String, String> scopes = (Map<String, String>) (model.containsKey("scopes") ? model.get("scopes") : request.getAttribute("scopes"));
            List<String> scopeList = new ArrayList<String>();
            for (String scope : scopes.keySet()) {
                scopeList.add(scope);
            }
            model.put("scopeList", scopeList);
            return "static/oauth_approval";
        }

        @RequestMapping({ "/oauth/my_error_page" })
        public String handleError(Map<String, Object> model, HttpServletRequest request) {
            Object error = request.getAttribute("error");
            String errorSummary;
            if (error instanceof OAuth2Exception) {
                OAuth2Exception oauthError = (OAuth2Exception) error;
                errorSummary = HtmlUtils.htmlEscape(oauthError.getSummary());
            } else {
                errorSummary = "Unknown error";
            }
            model.put("errorSummary", errorSummary);
            return "static/oauth_error";
        }

    }
