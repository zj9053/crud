package com.zhou.crud.service;

import com.zhou.crud.entity.User;
import java.util.List;

public interface UserService {

    Integer insert(User user);

    Integer update(User user);

    Integer delete(Integer id);

    List<User> findAll();

    User findOne(Integer id);

}
