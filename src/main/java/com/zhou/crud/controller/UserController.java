package com.zhou.crud.controller;

import com.zhou.crud.entity.User;
import com.zhou.crud.exception.UserNameExistsException;
import com.zhou.crud.service.UserService;
import com.zhou.crud.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 操作成功的状态码
     */
    public static final int OK = 200;

    @Autowired
    private UserService userService;

    //http://localhost:8888/user/insert?username=jj&password=789
    @PostMapping("/insert")
    public JsonResult<Void> insert(User user) {
        JsonResult<Void> result = new JsonResult<>();
        try {
            userService.insert(user);
            result.setState(OK);
            result.setMessage("用户名注册成功");
        } catch (UserNameExistsException e){
            result.setState(4000);
            result.setMessage(e.getMessage());
        }
        return result;
    }

    //http://localhost:8888/user/delete/2
    //@PathVariable 获取url中id的值
    @GetMapping("/delete/{id}")
    public JsonResult<Void> delete(@PathVariable Integer id) {
        userService.delete(id);
        return new JsonResult<>(OK);
    }

    //http://localhost:8888/user/update?id=3&username=gg&password=987
    @PostMapping("/update")
    public JsonResult<Void> update(User user) {
        userService.update(user);
        return new JsonResult<>(OK);
    }

    //http://localhost:8888/user/findAll
    @GetMapping("findAll")
    public JsonResult<List<User>> findAll() {
        List<User> data = userService.findAll();
        return new JsonResult<List<User>>(OK,data);
    }

    //http://localhost:8888/user/findOne/4
    @GetMapping("findOne/{id}")
    public JsonResult<User> findOne(@PathVariable Integer id) {
        User data = userService.findOne(id);
        System.out.println(data);
        return new JsonResult<>(OK,data);
    }

}
