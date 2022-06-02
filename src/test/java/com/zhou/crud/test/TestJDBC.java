package com.zhou.crud.test;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.regex.Pattern;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestJDBC {
    @Autowired
    private DatabaseMetaData dataSource;

    @Test
    public void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    public static void main(String[] args) {
        String arr = " ^137a@-_334^";

//        System.out.println(aa(arr));
//        System.out.println(bb(arr));
    }

    public static Boolean aa(String zifu){
        Pattern pattern = Pattern.compile("-?[0-9]+(\\\\\\\\.[0-9]+)?");
        Boolean num = pattern.matcher(zifu).matches();
        return num;
    }

    public static Boolean bb(String zifiu){
        String regex = "[^^'\n\r\t\b\f \\\\#$%&*+]+";//意思是：匹配不含这些特殊字符的其他任意一个或多个字符

        if (zifiu.matches(regex)){
            System.out.println("匹配成功");
            return true;
        }else {
            System.out.println("不能含特殊字符");
            return false;
        }
    }

}

