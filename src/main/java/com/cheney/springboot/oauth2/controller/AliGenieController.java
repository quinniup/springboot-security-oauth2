package com.cheney.springboot.oauth2.controller;


import com.alibaba.fastjson.JSONObject;
import com.cheney.springboot.oauth2.entity.tmall.TmallHeader;
import com.cheney.springboot.oauth2.service.impl.AliGenieServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/voice")
public class AliGenieController {

    private static final Logger logger=LoggerFactory.getLogger(AliGenieController.class);

    //查询设备列表命令
    private static String Discovery="AliGenie.Iot.Device.Discovery";
    //控制类命令
    private static String Control="AliGenie.Iot.Device.Control";
    //查询设备状态类命令
    private static String Query="AliGenie.Iot.Device.Query";


    @Autowired
    private AliGenieServiceImpl aliGenieService;

    @RequestMapping(value = "/aligenie",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String aliGenie(HttpServletRequest request,@RequestBody String  body) {

        //获取请求参数json中的header字段对象；
        JSONObject headerJson=JSONObject.parseObject(JSONObject.parseObject(body).getString("header"));
        //获取请求参数json中的payload字段对象；
        JSONObject payLoadJson=JSONObject.parseObject(JSONObject.parseObject(body).getString("payload"));

        //构造返回参数json
        TmallHeader tmallHeader=new TmallHeader(headerJson.getString("namespace"),headerJson.getString("name"),headerJson.getString("messageId"),headerJson.getString("payLoadVersion"));


        //判断是什么类型的命令
        //查询设备列表

        if (headerJson.getString("namespace").equals(Discovery)){               //授权登录成功后的用户下设备列表查询

            return aliGenieService.queryTmallDeviceList(tmallHeader);

        }else if (headerJson.getString("namespace").equals(Control)){                   //控制具体设备命令

            return aliGenieService.controlDevice(payLoadJson,tmallHeader);

        }else if (headerJson.getString("namespace").equals(Query)){

            return null;
        }else {

            return null;
        }


    }


}