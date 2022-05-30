package com.example.demo.start.controller;

import com.example.demo.start.dao.Address;
import com.example.demo.start.dao.AddtoMysql;
import com.example.demo.start.dao.HistoryWeather;
import com.example.demo.start.dao.WeatherInfo;
import com.example.demo.start.service.SetCity;
import com.example.demo.start.service.SetHis;
import com.example.demo.start.service.SetWeather;
import com.example.demo.start.service.SqlService;
import com.example.demo.start.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.rmi.CORBA.Util;
import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author xylong
 * @date 2022/5/4 23:13
 */
@Controller
@RequestMapping("/")
public class WeatherController {


    @GetMapping
    public String hello(Model model, HttpServletRequest request) throws MalformedURLException {

        System.out.println("============");


        String ip = getIpp.getIpAddress(request);
        if (ip.equals("0:0:0:0:0:0:0:1")){
            ip = "219.244.127.25";
        }

        System.out.println(ip);
        WeatherInfo weatherInfo = SetWeather.setWeather(ip);
        Map<String, HistoryWeather> stringHistoryWeatherMap = new SetHis().setHis(ip);
        Address address = SetCity.setadd(ip);

        System.out.println(weatherInfo);


//            System.out.println(new AddtoMysql().add(weatherInfo));
//            String sql = "INSERT INTO weather(city) VALUES('西安')";
//        System.out.println(jdbcTemplate.update(sql));


        ArrayList<String> list = new getNow().getdateArray();

        model.addAttribute("weather", weatherInfo);
        model.addAttribute("address", address);
        model.addAttribute("HisMap", stringHistoryWeatherMap);
        model.addAttribute("date", list );

        return "weather";


    }
}
