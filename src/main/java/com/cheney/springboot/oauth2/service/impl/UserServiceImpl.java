package com.cheney.springboot.oauth2.service.impl;

import com.cheney.springboot.oauth2.dao.UserMapper;
import com.cheney.springboot.oauth2.entity.User;
import com.cheney.springboot.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectByUserName(String name) {
        return userMapper.selectByUserName(name);
    }


}
