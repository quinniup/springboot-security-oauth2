package com.cheney.springboot.oauth2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.annotation.PostConstruct;

/**
 * 认证服务器配置
 * @author cheney
 *
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private static final String DEMO_RESOURCE_ID = "user";



	@Autowired
	RedisConnectionFactory redisConnectionFactory;

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		clients.inMemory()
	        .withClient("AliGenieDevlopment")
				.resourceIds("oauth2-resource")
				.authorizedGrantTypes("authorization_code", "client_credentials", "refresh_token","password", "implicit")
				.redirectUris("https://open.bot.tmall.com/oauth/callback")
				.scopes("all")
				.authorities("client")
				.secret("XMKDOIGN8274HDN")//密码
            .accessTokenValiditySeconds(120).//token有效期为120秒
            refreshTokenValiditySeconds(600);//刷新token有效期为600秒
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(new RedisTokenStore(redisConnectionFactory))
				.authenticationManager(authenticationManager);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.realm("oauth2-resources")
				.tokenKeyAccess("permitAll()") //url:/oauth/token_key,exposes public key for token verification if using JWT tokens
				.checkTokenAccess("isAuthenticated()") //url:/oauth/check_token allow check token
				.allowFormAuthenticationForClients();
	}

	@Autowired
	private AuthorizationEndpoint authorizationEndpoint;

	@PostConstruct
	public void init() {
		authorizationEndpoint.setUserApprovalPage("forward:/oauth/my_approval_page");
		authorizationEndpoint.setErrorPage("forward:/oauth/my_error_page");
	}


}