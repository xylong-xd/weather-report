package com.example.demo.start.service;

import com.example.demo.start.dao.Address;
import com.example.demo.start.dao.HistoryWeather;
import com.example.demo.start.util.WeatherUtils;
import com.example.demo.start.util.getXY;

import java.util.Map;

/**
 * @author xylong
 * @date 2022/5/6 21:55
 */
public class SetHis {
    public Map<String, HistoryWeather> setHis(String ip){

        String adcode = getXY.GetXY(ip).getAdcode();


        Map<String, HistoryWeather> stringHistoryWeatherMap = WeatherUtils.GetHis(WeatherUtils.GetWeatherData(adcode));

        return stringHistoryWeatherMap;
    }
}
