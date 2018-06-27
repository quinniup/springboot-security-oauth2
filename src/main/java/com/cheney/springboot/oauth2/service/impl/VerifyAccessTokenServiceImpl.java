package com.cheney.springboot.oauth2.service.impl;

import com.cheney.springboot.oauth2.service.VerifyAccessTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
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
    private DataSource dataSource;

    @Bean
    public TokenStore jdbcTokenStore() {
        Assert.state(dataSource != null, "DataSource must be provided");
        return new JdbcTokenStore(dataSource);
    }
    @Autowired(required = false)
    private TokenStore jdbcTokenStore;


    @Override
    public boolean verifyAccessToken(String accessToken){

        OAuth2AccessToken oAuth2AccessToken=jdbcTokenStore.readAccessToken(accessToken);

        //校验accessToken是否存在，如果不存在则不允许访问；
        if (oAuth2AccessToken==null){
            return false;
        }
        return true;
    }

}
