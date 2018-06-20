package com.cheney.springboot.oauth2.config;

import com.cheney.springboot.oauth2.entity.User;
import com.cheney.springboot.oauth2.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;

/***
 **
 ** @Author: CheneyHao
 ** @Description: 自定义用户登录，加载数据库中的用户数据
 ** @Date:Created in 10:55 2018/6/8
 ** @Modified By:
 **
 ****/
public class MyUserDetailsService implements UserDetailsService {


    private final Logger Logger=LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName)throws UsernameNotFoundException{

        User user = userService.selectByUserName(userName);

        if (user==null) {
            throw new UsernameNotFoundException("该用户:"+userName+"不存在!");
        }

        //创建一个HashSet存放用户权限
        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        collection.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        //如果这个用户在数据库就返回给SpringSecurity框架
        Logger.info("UserName:"+userName+";Password:"+user.getPassword()+";Role:"+collection);
        return new org.springframework.security.core.userdetails.User(userName,user.getPassword(),collection);

    }
}
