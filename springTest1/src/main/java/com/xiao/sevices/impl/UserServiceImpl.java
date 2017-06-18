package com.xiao.sevices.impl;

import com.xiao.dto.User;
import com.xiao.mapper.UserMapper;
import com.xiao.sevices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiaogan on 6/11.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public List<User> getAll() {
        return userMapper.findAll();
    }

    public String insert(User user) {
        userMapper.insert(user);
        return "ok";
    }

    public String delete(int uid) {
        userMapper.delete(uid);
        return "ok";
    }
}
