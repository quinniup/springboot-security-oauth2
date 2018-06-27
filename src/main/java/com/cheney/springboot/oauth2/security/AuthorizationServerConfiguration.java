package com.cheney.springboot.oauth2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

/**
 * 认证服务器配置
 * @author cheney
 *
 *
 */
@Configuration

public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private static final String DEMO_RESOURCE_ID = "voice";

	private static String REALM="MY_OAUTH_REALM";

//	@Autowired
//	private DataSource dataSource;


	@Autowired
	private AuthenticationProvider authenticationProvider;

	@Autowired
	private RedisConnectionFactory redisConnectionFactory;

//	@Bean
//	public ApprovalStore approvalStore() {
//
//		return new JdbcApprovalStore(dataSource);
//	}
//	@Bean
//	protected AuthorizationCodeServices authorizationCodeServices() {
//		return new JdbcAuthorizationCodeServices(dataSource);
//	}
//
//
//	@Bean
//	public TokenStore jdbcTokenStore() {
//		Assert.state(dataSource != null, "DataSource must be provided");
//		return new JdbcTokenStore(dataSource);
//	}
//	@Autowired(required = false)
//	private TokenStore jdbcTokenStore;



//	@Bean
//	public ClientDetailsService clientDetails() {
//		return new JdbcClientDetailsService(dataSource);
//	}
//

	@Bean
	public TokenStore redisTokenStore(){
		return new RedisTokenStore(redisConnectionFactory);
	}

	@Autowired
	private AuthorizationEndpoint authorizationEndpoint;

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		clients.inMemory()
				.withClient("AliGenieDevlopment")//clientID
				.secret("XMKDOIGN8274HDN")//ClientSecret
				.resourceIds(DEMO_RESOURCE_ID)//资源ID
				.authorizedGrantTypes("authorization_code", "client_credentials", "refresh_token", "password", "implicit")//授权方式
				.redirectUris("https://open.bot.tmall.com/oauth/callback?skillId%3D15921&token=MjI2MzgwODE1MEFGRUhJTkZEVlE%3D")//回调地址
				.scopes("all")
				.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
				.accessTokenValiditySeconds(60*60*24*2)//token有效期为两天（天猫精灵建议有效时间）
				.refreshTokenValiditySeconds(60*60*24*2);//刷新token有效期

	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(redisTokenStore())
				.authenticationManager(authenticationManager);

//		//设置TokenService的参数
//		DefaultTokenServices tokenServices = new DefaultTokenServices();
//		tokenServices.setTokenStore(endpoints.getTokenStore());
//		//支持刷新accessToken；
//		tokenServices.setSupportRefreshToken(true);
//		tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
//		tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
//		tokenServices.setReuseRefreshToken(true);
//		tokenServices.setAccessTokenValiditySeconds( (int) TimeUnit.DAYS.toSeconds(3)); // 3天（天猫精灵开发平台推荐2-3天）
//		tokenServices.setRefreshTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(3));
//
//		endpoints.tokenServices(tokenServices);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.realm(REALM+"client")
				.tokenKeyAccess("permitAll()")
				.checkTokenAccess("permitAll()")
				.allowFormAuthenticationForClients();
	}


	@PostConstruct
	public void init() {
		authorizationEndpoint.setUserApprovalPage("forward:/oauth/my_approval_page");
		authorizationEndpoint.setErrorPage("forward:/oauth/my_error_page");
	}


}
