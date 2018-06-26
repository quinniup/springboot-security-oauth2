package com.cheney.springboot.oauth2.entity.tmall.discovery;

import com.alibaba.fastjson.JSON;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

import java.util.ArrayList;
import java.util.List;

/***
 **
 ** @Author: CheneyHao
 ** @Despriction: ${DESCRIPTION} 
 ** @Mail: yinzhihao@btte.net
 ** @Data: Created in 下午4:26 2018/6/25
 **
 ***/
public class TmallDevices {
    private List<TmallDevice> devices;
    private String deviceId;
    private String errorCode;
    private String message;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TmallDevices(String deviceId){
        this.deviceId=deviceId;
        this.setDevices(null);
        this.setErrorCode(null);
        this.setMessage(null);
    }
    public TmallDevices(String deviceId,String errorCode,String message){
        this.deviceId=deviceId;
        this.errorCode=errorCode;
        this.message=message;
        this.setDevices(null);
    }


    public List<TmallDevice> getDevices() {
        return devices;
    }

    public void setDevices(List<TmallDevice> devices) {
        this.devices = devices;
    }

    public TmallDevices(TmallDevice device){
        List<TmallDevice> devices=new ArrayList<>();
        devices.add(device);
        this.devices=devices;
        this.setDeviceId(null);
        this.setErrorCode(null);
        this.setMessage(null);
    }
    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

}

