package com.czc.service;

import com.czc.dao.UserMapper;
import com.czc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getUserInfo(){
        return userMapper.getUserInfo();
    }
}
