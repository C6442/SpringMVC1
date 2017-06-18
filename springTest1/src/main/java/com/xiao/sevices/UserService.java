package com.xiao.sevices;

import com.xiao.dto.User;
import com.xiao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiaogan on 6/10.
 */
@Service
public interface UserService {

    List<User> getAll();

    String insert(User user);

    String delete(int uid);
}
