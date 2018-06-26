package com.cheney.springboot.oauth2.dao;

import com.cheney.springboot.oauth2.entity.User;


public interface UserMapper {

    User selectByUserName(String userName);

}