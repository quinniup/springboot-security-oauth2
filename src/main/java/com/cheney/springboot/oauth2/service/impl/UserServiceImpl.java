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
    public User findByUsername(String name) {
        return userMapper.selectByUserName(name);
    }

    @Override
    public User findAll() {
        return userMapper.selectAll();
    }

//    @Override
//    public  boolean isUserExist(User user){
//        if (userMapper.selectByUserName(user.getUsername())!=null){
//        return  true;
//        }else {
//            return false;
//        }
//    }
//
//    @Override
//    public int saveUser(User user){
//        return userMapper.insert(user);
//    }

    @Override
    public User selectByPrimaryKey(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

}
