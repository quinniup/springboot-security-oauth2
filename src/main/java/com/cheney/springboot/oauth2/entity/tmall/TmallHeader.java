package com.cheney.springboot.oauth2.entity.tmall;

import com.alibaba.fastjson.JSON;

/***
 **
 ** @Author: CheneyHao
 ** @Despriction: ${DESCRIPTION} 
 ** @Mail: yinzhihao@btte.net
 ** @Data: Created in 下午2:44 2018/6/25
 **
 ***/
public class TmallHeader {
    private String namespace;
    private String name;
    private String messageId;
    private String payLoadVersion;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getPayLoadVersion() {
        return payLoadVersion;
    }

    public void setPayLoadVersion(String payLoadVersion) {
        this.payLoadVersion = payLoadVersion;
    }

    public TmallHeader(String namespace,String name,String messageId,String payLoadVersion){
        this.namespace=namespace;
        this.name=name+"Response";
        this.messageId=messageId;
        this.payLoadVersion=payLoadVersion;

    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }
}
