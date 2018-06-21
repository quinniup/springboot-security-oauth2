package com.cheney.springboot.oauth2.service;


import com.cheney.springboot.oauth2.entity.User;

public interface UserService {

    User selectByPrimaryKey(Integer id);

    User selectByUserName(String nameName);

    User findAll();


    boolean isUserExist(String userName);


}
