package com.cheney.springboot.oauth2.utils;

import com.alibaba.fastjson.JSON;

import java.util.Date;

/**
 *
 */
public class ResultData {
    private static final long serialVersionUID = -2670685636460857955L;
    public static final String ERRCODE_SUCC = "N000"; // 成功
    public static final String ERRCODE_ERROR = "E000"; // 系统错误

    private String code = "N000";
    private String message ;
    private Long time = new Date().getTime();
    private Object data = "";

    public ResultData() {
        this.data = "";
    }

    public ResultData(String code,String message) {
        this.code = code;
        this.message = message;
    }

    public ResultData(String code,String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
