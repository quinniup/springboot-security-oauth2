package com.cheney.springboot.oauth2.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cheney.springboot.oauth2.service.impl.AliGenieServiceImpl;
import com.cheney.springboot.oauth2.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/voice")
public class AliGenieController {

    //查询设备列表命令
    private static String Discovery="AliGenie.Iot.Device.Discovery";
    //控制类命令
    private static String Control="AliGenie.Iot.Device.Control";
    //查询设备状态类命令
    private static String Query="AliGenie.Iot.Device.Query";


    @Autowired
    private AliGenieServiceImpl aliGenieService;

    @RequestMapping(value = "/AliGenie")
    @ResponseBody
    public ResultData aliGenie(HttpServletRequest request,@RequestBody String  body) {

        //解析请求参数中的Header
        String  header= JSONObject.parseObject(body).getString("header");

        JSONObject messageIdJson=JSONObject.parseObject(header);
        //从请求参数中获取MessageId，以备在response中返回
        String messageId=messageIdJson.getString("messageId");
        System.out.println(messageId);
        //通过此字段判断请求参数属于什么类型的命令
        String namespace=messageIdJson.getString("namespace");

        //判断是什么类型的命令
        //查询设备列表
        if (namespace.equals(Discovery)){

            ResultData resultData=aliGenieService.discoveryDeviceList();

            return resultData;

        }else if (namespace.equals(Control)){

            return null;
        }else if (namespace.equals(Query)){
            return null;
        }else {
            return null;
        }


    }
  

  
}