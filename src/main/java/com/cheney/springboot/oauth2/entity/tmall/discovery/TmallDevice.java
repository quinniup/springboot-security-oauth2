package com.cheney.springboot.oauth2.entity.tmall.discovery;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;

import java.util.List;

/***
 **
 ** @Author: CheneyHao
 ** @Despriction: ${DESCRIPTION} 
 ** @Mail: yinzhihao@btte.net
 ** @Data: Created in 下午1:41 2018/6/25
 **
 ***/
public class TmallDevice {

    private String deviceId;
    private String deviceName;
    private String deviceType;
    private String zone;
    private String brand;
    private String model;
    private String icon;
    private List<JSONObject> properties;
    private List<String> actions;
    private JSONObject extensions;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<JSONObject> getProperties() {
        return properties;
    }

    public void setProperties(List<JSONObject> properties) {
        this.properties = properties;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }

    public JSONObject getExtensions() {
        return extensions;
    }

    public void setExtensions(JSONObject extensions) {
        this.extensions = extensions;
    }

    public TmallDevice(){

    }

    @Override
    public String toString(){
       return JSONObject.toJSONString(this);
    }
}
