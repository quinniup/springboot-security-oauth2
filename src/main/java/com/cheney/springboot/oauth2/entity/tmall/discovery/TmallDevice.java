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

    //设备ID
    private String deviceId;

    private String deviceName;
    //设备的具体类型，需对应阿里品类列表
    private String deviceType;
    //位置
    private String zone;
    //品牌
    private String brand;
    //型号
    private String model;
    //图标
    private String icon;
    //返回当前设备支持的属性状态列表，产品支持的属性列表参考 设备控制与设备状态查询页 的 第二部分 设备状态查询 2.2 章节
    private List<JSONObject> properties;
    //产品支持的操作(注：包括支持的查询操作) ,详情参照 协议简介 中 1.3.2和1.3.3章节
    private List<String> actions;
    //产品扩展属性,为空返回null或者不返回该字段
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
