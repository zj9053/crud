package com.zhou.crud.mapper;

import com.zhou.crud.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    Integer insert(User user);

    Integer delete(Integer id);

    Integer update(User user);

    List<User> findAll();

    User findOne(Integer id);

    User findName(String username);

}
