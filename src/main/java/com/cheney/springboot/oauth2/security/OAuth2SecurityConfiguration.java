package com.cheney.springboot.oauth2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
@EnableWebSecurity
public class OAuth2SecurityConfiguration extends WebSecurityConfigurerAdapter {




	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
				.withUser("demoUser1").password("123456").authorities("ADMIN")
				.and()
				.withUser("demoUser2").password("123456").authorities("USER");
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		AuthenticationManager manager = super.authenticationManagerBean();
		return manager;
	}

	/**
	 * 1\这里记得设置requestMatchers,不拦截需要token验证的url
	 * 不然会优先被这个filter拦截,走用户端的认证而不是token认证
	 * 2\这里记得对oauth的url进行保护,正常是需要登录态才可以
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.requestMatchers()
				.antMatchers("/oauth/**","/login/**","/logout/**")
				.and()
				.authorizeRequests()
//				.antMatchers("/oauth/login").permitAll()
				.antMatchers("/oauth/**").authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/oauth/my_approval_page")
				.failureUrl("/oauth/my_error_page")
				.permitAll()
				.and()
				.logout()
				.permitAll()
				.and()
				.rememberMe()
				.and().exceptionHandling().accessDeniedPage("/oauth/my_error_page");
	}


	
}
