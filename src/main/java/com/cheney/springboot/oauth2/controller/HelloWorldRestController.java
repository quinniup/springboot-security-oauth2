package com.cheney.springboot.oauth2.controller;

import com.cheney.springboot.oauth2.entity.User;
import com.cheney.springboot.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldRestController {
  
    @Autowired
    private UserService userService;  //Service which will do all data retrieval/manipulation work
  
      
    //-------------------Retrieve All Users--------------------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    @ResponseBody
    public String listAllUsers() {

        return "HelloWorld";
    }
  

  
}