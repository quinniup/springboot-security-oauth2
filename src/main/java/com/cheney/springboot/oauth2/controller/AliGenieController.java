package com.cheney.springboot.oauth2.controller;


import com.alibaba.fastjson.JSONObject;
import com.cheney.springboot.oauth2.entity.tmall.TmallHeader;
import com.cheney.springboot.oauth2.entity.tmall.discovery.TmallDevice;
import com.cheney.springboot.oauth2.entity.tmall.discovery.TmallDevices;
import com.cheney.springboot.oauth2.entity.tmall.TmallResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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


//    @Autowired
//    private AliGenieServiceImpl aliGenieService;

    @RequestMapping(value = "/aligenie")
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
            List<String> actions=new ArrayList<>();
            actions.add("TurnOn");
            actions.add("TurnOff");

            JSONObject property=new JSONObject();
            property.put("name","color");
            property.put("value","Red");

            List<JSONObject> properties=new ArrayList<>();
            properties.add(property);

            TmallDevice tmallPayload =new TmallDevice();
            tmallPayload.setDeviceId("34ea34cf2e63");
            tmallPayload.setDeviceName("灯");
            tmallPayload.setDeviceType("light");
            tmallPayload.setZone("卧室");
            tmallPayload.setBrand("GPIO 艾欧特智能");
            tmallPayload.setModel("GPIO86L");
            tmallPayload.setIcon("");
            tmallPayload.setActions(actions);
            tmallPayload.setProperties(properties);

            TmallDevices tmallDevices=new TmallDevices(tmallPayload);
            TmallResultData tmallResultData =new TmallResultData(tmallHeader,tmallDevices);
            logger.info(tmallResultData.toString());

            return tmallResultData.toString();

        }else if (headerJson.getString("namespace").equals(Control)){                   //控制具体设备命令


            /*
                请求设备的控制接口，如果执行成功直接deviceID；
                否则，多加两条错误信息返回。
             */
            TmallDevices tmallControl;
            TmallResultData tmallResultData;
            if (true){
                tmallControl=new TmallDevices(payLoadJson.getString("deviceId"));
                tmallResultData=new TmallResultData(tmallHeader,tmallControl);
                logger.info(tmallResultData.toString());
                return tmallResultData.toString();
            }else {
                tmallControl = new TmallDevices(payLoadJson.getString("deviceId"), "DEVICE_NOT_SUPPORT_FUNCTION", "device not support");
                tmallResultData=new TmallResultData(tmallHeader,tmallControl);
                logger.info(tmallResultData.toString());
                return tmallResultData.toString();
            }

        }else if (headerJson.getString("namespace").equals(Query)){

            return null;
        }else {

            return null;
        }


    }


}