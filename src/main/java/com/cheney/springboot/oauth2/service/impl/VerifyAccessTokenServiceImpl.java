package com.cheney.springboot.oauth2.service.impl;

import com.cheney.springboot.oauth2.service.VerifyAccessTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.sql.DataSource;

/***
 **
 ** @Author: CheneyHao
 ** @Despriction: ${DESCRIPTION} 
 ** @Mail: yinzhihao@btte.net
 ** @Data: Created in 上午9:21 2018/6/27
 **
 ***/
@Service
public class VerifyAccessTokenServiceImpl implements VerifyAccessTokenService {

    private static final Logger LOG=LoggerFactory.getLogger(VerifyAccessTokenServiceImpl.class);


    @Autowired
    private RedisConnectionFactory redisConnectionFactory;



    @Override
    public boolean verifyAccessToken(String accessToken){
        RedisTokenStore redisTokenStore=new RedisTokenStore(redisConnectionFactory);
        OAuth2Authentication oAuth2Authentication=redisTokenStore.readAuthentication(accessToken);
        String userName=oAuth2Authentication.getUserAuthentication().getName();
        LOG.info(userName);
        return true;
    }

}
