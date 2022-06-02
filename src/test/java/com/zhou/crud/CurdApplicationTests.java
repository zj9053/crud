package com.zhou.crud;

import com.zhou.crud.entity.User;
import com.zhou.crud.exception.UserNameExistsException;
import com.zhou.crud.mapper.UserMapper;
import com.zhou.crud.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@SpringBootTest
class CurdApplicationTests {
	@Autowired
	private DataSource dataSource;
	@Test
	void contextLoads() {
	}

	@Test
	public void getConnection() throws SQLException {
		System.out.println(dataSource.getConnection());
	}


	@Autowired
	private UserMapper userMapper;

	@Test
	public void insert(){
		User u = new User();
		u.setUsername("in");
		u.setPassword("admin123");
		Integer rows = userMapper.insert(u);
		System.out.println(rows);
	}

	@Test
	public void findAll(Map<String, List> resul){
//        User u = new User();
//		User u = userMapper.findAll();
//		System.out.println(u.toString());
	}

	@Autowired
	private UserService userService;


	@org.junit.Test
	public Integer insert(User user) {
		String newName = user.getUsername();
		User oldName = userMapper.findName(newName);
		if (oldName != null){
			throw new UserNameExistsException("用户名已存在！");
		}


		Integer insert = userMapper.insert(user);
		return insert;
	}

}
