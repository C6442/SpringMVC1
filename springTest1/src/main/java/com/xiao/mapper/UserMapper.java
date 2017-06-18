package com.xiao.mapper;

import com.xiao.dto.User;

import java.util.List;

/**
 * Created by xiaogan on 6/10.
 */

public interface UserMapper {

    List<User> findAll();
    void insert(User user);
    void delete(int uid);
}
