package com.cheney.springboot.oauth2.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.cheney.springboot.oauth2.entity.tmall.TmallHeader;
import com.cheney.springboot.oauth2.entity.tmall.TmallResultData;
import com.cheney.springboot.oauth2.entity.tmall.discovery.TmallDevice;
import com.cheney.springboot.oauth2.entity.tmall.discovery.TmallDeviceProperties;
import com.cheney.springboot.oauth2.entity.tmall.discovery.TmallDevices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/***
 **
 ** @Author: CheneyHao
 ** @Description:该service为天猫精灵智能音箱所用，提供查询支持的设备列表、控制、查询设备状态属性；
 **
 ** @Date:Created in 10:14 2018/6/6
 ** @Modified By:
 **
 ****/
@Service
public class AliGenieServiceImpl {
    private static final Logger logger=LoggerFactory.getLogger(AliGenieServiceImpl.class);



    /**
     * 查询用户设备列表
     * @param tmallHeader
     * @return
     */
    public String queryTmallDeviceList(TmallHeader tmallHeader){



        //以下用来测试返回数据
        List<String> actions=new ArrayList<>();
        actions.add("TurnOn");
        actions.add("TurnOff");

        JSONObject property=new JSONObject();
        property.put("name","powerstate");
        property.put("value","OFF");

        List<JSONObject> properties=new ArrayList<>();
        properties.add(property);

        TmallDevice tmallDevice =new TmallDevice();
        tmallDevice.setDeviceId("34ea34cf2e63");
        tmallDevice.setDeviceName("灯");
        tmallDevice.setDeviceType("light");
        tmallDevice.setZone("卧室");
        tmallDevice.setBrand("TuYa");
        tmallDevice.setModel("PH269");
        tmallDevice.setIcon("http://iot.domybox.com/boss/userfiles/e4e1ec8ab50a498b884f8e0a032f767f/images/devicelogo/2017/11/smoke%403x.png");
        tmallDevice.setActions(actions);
        tmallDevice.setProperties(properties);

        JSONObject extensions=new JSONObject();
        extensions.put("extension1","");
        extensions.put("extension2","");
        tmallDevice.setExtensions(extensions);

//

        TmallDevices tmallDevices=new TmallDevices(tmallDevice);

        TmallResultData tmallResultData =new TmallResultData(tmallHeader,tmallDevices);
        logger.info(tmallResultData.toString());
        return tmallResultData.toString();
    }

    /**
     * 控制设备操作
     * @param payLoadJson
     * @param tmallHeader
     * @return
     */
    public String controlDevice(JSONObject payLoadJson, TmallHeader tmallHeader){

        TmallDevices tmallControl;
        TmallDeviceProperties tmallDeviceProperties;
        TmallResultData tmallResultData;
        /*
                请求设备的控制接口，如果执行成功直接deviceID；
                否则，多加两条错误信息返回。
             */
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
    }


    public String queryDeviceProperties(JSONObject payLoadJson,TmallHeader tmallHeader){
        TmallDeviceProperties tmallDeviceProperties=new TmallDeviceProperties();
        TmallResultData tmallResultData;
        TmallDevices tmallControl=new TmallDevices(payLoadJson.getString("deviceId"));

        JSONObject property1=new JSONObject();
        property1.put("name","powerstate");
        property1.put("value","ON");

        JSONObject property2=new JSONObject();
        property2.put("name","color");
        property2.put("value","Red");

        List<JSONObject> propertity=new ArrayList<>();
        propertity.add(property1);
        propertity.add(property2);




        tmallResultData=new TmallResultData(tmallHeader,tmallControl,propertity);
        logger.info(tmallResultData.toString());
        return tmallResultData.toString();
    }

}
