package com.cheney.springboot.oauth2.service;


import com.cheney.springboot.oauth2.entity.User;

public interface UserService {

    User selectByPrimaryKey(Integer id);

    User selectByUserName(String name);

    User findAll();

//    int saveUser(User user);
//
//    boolean isUserExist(User user);


}
