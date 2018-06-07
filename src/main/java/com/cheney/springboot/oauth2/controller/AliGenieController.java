package com.cheney.springboot.oauth2.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/voice")
public class AliGenieController {

    private static String Discovery="AliGenie.Iot.Device.Discovery";

    private static String Control="AliGenie.Iot.Device.Control";

    private static String Query="AliGenie.Iot.Device.Query";


    @RequestMapping(value = "/AliGenie")
    @ResponseBody
    public String listAllDevice(HttpServletRequest request,@RequestBody String  body) {

        System.out.println(body);
        String  header= JSONObject.parseObject(body).getString("header");

        JSONObject messageIdJson=JSONObject.parseObject(header);
        String messageId=messageIdJson.getString("messageId");
        System.out.println(messageId);
//        String resp="{\"header\":{\"namespace\":\"AliGenie.Iot.Device.Discovery\",\"name\":\"DiscoveryDevicesResponse\",\"messageId\":\""+messageId+"\",\"payLoadVersion\":1},\"payload\":{\"devices\":[{\"deviceId\":\"34ea34cf2e63\",\"deviceName\":\"灯\",\"deviceType\":\"light\",\"zone\":\"卧室\",\"brand\":\"涂鸦\",\"model\":\"donne WS-L5M01\",\"icon\":\"https://git.cn-hangzhou.oss-cdn.aliyun-inc.com/uploads/aicloud/aicloud-proxy-service/41baa00903a71c97e3533cf4e19a88bb/image.png\",\"properties\":[{\"name\":\"color\",\"value\":\"Red\"}],\"actions\":[\"TurnOn\",\"TurnOff\",\"SetBrightness\",\"AdjustBrightness\",\"SetTemperature\",\"Query\"],\"extensions\":{\"extension1\":\"\",\"extension2\":\"\"}}]}}";



        String resp="{\"header\":{\"namespace\":\"AliGenie.Iot.Device.Discovery\",\"name\":\"DiscoveryDevicesResponse\",\"messageId\":\""+messageId+"\",\"payLoadVersion\":1},\"payload\":{\"devices\":[{\"deviceId\":\"34ea34cf2e63\",\"deviceName\":\"灯\",\"deviceType\":\"light\",\"zone\":\"卧室\",\"brand\":\"格润莱特\n\",\"model\":\"STY-MX72\",\"icon\":\"https://git.cn-hangzhou.oss-cdn.aliyun-inc.com/uploads/aicloud/aicloud-proxy-service/41baa00903a71c97e3533cf4e19a88bb/image.png\",\"properties\":[{\"name\":\"color\",\"value\":\"Red\"}],\"actions\":[\"TurnOn\",\"TurnOff\",\"SetBrightness\",\"AdjustBrightness\",\"SetTemperature\",\"Query\"],\"extensions\":{\"extension1\":\"\",\"extension2\":\"\"}},{\"deviceId\":\"34ea34cf2eggff\",\"deviceName\":\"灯\",\"deviceType\":\"light\",\"zone\":\"客厅\",\"brand\":\"GPIO 艾欧特智能\",\"model\":\"GPIO86L\",\"icon\":\"https://git.cn-hangzhou.oss-cdn.aliyun-inc.com/uploads/aicloud/aicloud-proxy-service/41baa00903a71c97e3533cf4e19a88bba88bb/image.png\",\"properties\":[{\"name\":\"powerstate\",\"value\":\"off\"},{\"name\":\"color\",\"value\":\"Red\"}],\"actions\":[\"TurnOn\",\"TurnOff\",\"SetColor\"],\"extensions\":{\"extension1\":\"\",\"extension2\":\"\"}}]}}";
        System.out.println(resp);
        return resp;
    }
  

  
}