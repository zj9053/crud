package com.zhou.crud.test;

import com.zhou.crud.entity.User;
import com.zhou.crud.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Test
    public void insert(){
        User u = new User();
        u.setUsername("admin");
        u.setPassword("admin123");
        Integer rows = userMapper.insert(u);
        System.out.println(rows);
    }

    @Test
    public void findAll(){

        List<User> all = userMapper.findAll();
        for (User a :
                all) {
            a.getId();
            a.getUsername();
            a.getPassword();
        }
        System.out.println(all);
    }

    @Test
    public void findName(){
        String newName = "admin";
        User name = userMapper.findName(newName);
        if (name != null){
            System.out.println("用户名已存在！");
        }else {
            System.out.println("注册成功！");
        }
    }

    @Test
    public void test(){
        String s = new String("xyz");
        System.out.println(s);
    }

}
