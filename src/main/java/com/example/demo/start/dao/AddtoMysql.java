package com.example.demo.start.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xylong
 * @date 2022/5/5 19:56
 */
@Repository
public class AddtoMysql {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void findByCity() {
        List<WeatherInfo> userList = jdbcTemplate.query("select * from weatherinfo", new BeanPropertyRowMapper<>(WeatherInfo.class));
        for (WeatherInfo weatherInfo : userList) {
            System.out.println(weatherInfo);        }
    }
}
