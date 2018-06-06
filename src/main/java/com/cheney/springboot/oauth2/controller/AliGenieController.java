package com.cheney.springboot.oauth2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/voice")
public class AliGenieController {

    private static String Discovery="AliGenie.Iot.Device.Discovery";

    private static String Control="AliGenie.Iot.Device.Control";

    private static String Query="AliGenie.Iot.Device.Query";



    @GetMapping(value = "/AliGenie")
    @ResponseBody
    public String listAllUsers() {

        return "HelloWorld";
    }
  

  
}