package com.cheney.springboot.oauth2.service;

/***
 **
 ** @Author: CheneyHao
 ** @Despriction: ${DESCRIPTION} 
 ** @Mail: yinzhihao@btte.net
 ** @Data: Created in 上午9:24 2018/6/27
 **
 ***/
public interface VerifyAccessTokenService {
    boolean verifyAccessToken(String accessToken);
}
