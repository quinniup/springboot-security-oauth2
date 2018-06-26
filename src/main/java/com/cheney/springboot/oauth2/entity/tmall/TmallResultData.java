package com.cheney.springboot.oauth2.entity.tmall;

import com.alibaba.fastjson.JSON;
import com.cheney.springboot.oauth2.entity.tmall.discovery.TmallDevices;

import java.util.ArrayList;
import java.util.List;

/***
 **
 ** @Author: CheneyHao
 ** @Despriction: ${DESCRIPTION} 
 ** @Mail: yinzhihao@btte.net
 ** @Data: Created in 下午2:38 2018/6/25
 **
 ***/
public class TmallResultData {
    private TmallHeader header;
    private TmallDevices payload;


    public TmallHeader getHeader() {
        return header;
    }

    public void setHeader(TmallHeader header) {
        this.header = header;
    }

    public TmallDevices getPayload() {
        return payload;
    }

    public void setPayload(TmallDevices devices) {
        this.payload = devices;
    }



    //返回TmallAligenie格式数据
    public TmallResultData(TmallHeader header, TmallDevices devices){
        this.header=header;
        this.payload=devices;
    }


    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}
