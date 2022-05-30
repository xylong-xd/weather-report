package com.example.demo.start.util;

import com.example.demo.start.dao.WeatherInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author xylong
 * @date 2022/5/6 10:46
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)

public class DATests {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void getAllUsers2(){
        List<WeatherInfo> userList = jdbcTemplate.query("select * from weatherinfo",new BeanPropertyRowMapper<>(WeatherInfo.class));
        for (WeatherInfo weatherInfo : userList){
            System.out.println(weatherInfo);
        }
    }
    @Test
    public void insert(){
        String sql = "INSERT INTO weatherinfo(city,uptime) VALUES('西安','2020.1.1')";
        System.out.println(jdbcTemplate.update(sql));
    }
}
