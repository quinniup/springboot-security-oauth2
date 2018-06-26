package com.cheney.springboot.oauth2.service;


import com.cheney.springboot.oauth2.entity.User;

public interface UserService {


    User selectByUserName(String nameName);


}
