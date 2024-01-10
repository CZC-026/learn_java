package com.czc.dao;

import com.czc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserMapper {
    public List<User> getUserInfo(){
        return Collections.singletonList(new User("czc"));
    }
}
