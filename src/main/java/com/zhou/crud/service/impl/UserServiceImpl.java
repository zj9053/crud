package com.zhou.crud.service.impl;

import com.zhou.crud.entity.User;
import com.zhou.crud.exception.UserNameExistsException;
import com.zhou.crud.mapper.UserMapper;
import com.zhou.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer insert(User user) {
        User newName = userMapper.findName(user.getUsername());
        if (newName != null){
            throw new UserNameExistsException("用户名已存在!!!");
        }
        Integer insert = userMapper.insert(user);
        return insert;
    }

    @Override
    public Integer delete(Integer id) {
        Integer delete = userMapper.delete(id);
        return delete;
    }

    @Override
    public Integer update(User user) {
        Integer update = userMapper.update(user);
        return update;
    }

    @Override
    public List<User> findAll() {
        List<User> list = userMapper.findAll();
        for (User user :
                list) {
            user.getId();
            user.getUsername();
            user.getPassword();
        }
        return  list;
    }

    @Override
    public User findOne(Integer id) {
        User user = userMapper.findOne(id);
        return user;
    }

}
