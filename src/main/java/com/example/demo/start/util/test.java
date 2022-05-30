package com.example.demo.start.util;

import com.example.demo.start.dao.HistoryWeather;
import com.example.demo.start.dao.WeatherInfo;
import com.example.demo.start.service.SetHis;
import com.example.demo.start.service.SetWeather;
import com.example.demo.start.service.SqlService;

import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author xylong
 * @date 2022/5/5 14:36
 */
public class test {

    public static void main(String[] args) throws MalformedURLException, SQLException, ClassNotFoundException {

//        String aqi = AqiUtil.findAqi("43.249.193.233");

//        WeatherInfo weatherInfo = SetWeather.setWeather("113.200.174.33");
//        System.out.println(weatherInfo);
//        System.out.println(weatherInfo);
//        System.out.println(aqi);
//        System.out.println(getXY.GetXY("113.200.174.33").getCity());
//        System.out.println(WeatherUtils.GetWeatherData(adcode));
//        WeatherInfo weatherInfo = new WeatherInfo();
//        weatherInfo.setText("晴");
//        weatherInfo.setUptime("2022.5.6");
//        weatherInfo.setCity("beijing");
//        weatherInfo.setTemp("25");
//        weatherInfo.setFeels_like("25");
//        weatherInfo.setRh("25");
//        weatherInfo.setWind_dir("south");
//        weatherInfo.setWind_class("6");
//        weatherInfo.setAqi("66");
//        new SqlService().add(weatherInfo);
//        System.out.println(new SqlService().findByCity(weatherInfo.getCity()));
//        System.out.println(new SqlService().findByCity("xx"));
//        System.out.println(weatherInfo);


//        new SqlService().delete(weatherInfo);
//        String adcode = getXY.GetXY("113.200.174.33").getAdcode();
//        String s = WeatherUtils.GetWeatherData(adcode);
//        System.out.println(WeatherUtils.GetHis(s));
//        Map<String, HistoryWeather> stringHistoryWeatherMap = new SetHis().setHis("113.200.174.33");
//        Map<String, HistoryWeather> stringHistoryWeatherMap = WeatherUtils.GetHis(WeatherUtils.GetWeatherData(adcode));
//        System.out.println(adcode);
//        System.out.println(stringHistoryWeatherMap);
//        TestIp.TXY("43.249.193.167");


        Map<String, HistoryWeather> stringHistoryWeatherMap = new SetHis().setHis("113.200.174.33");
        ArrayList<String> arrayList = new getNow().getdateArray();
        System.out.println(stringHistoryWeatherMap);
        System.out.println(stringHistoryWeatherMap.get(arrayList.get(0)));
    }

}
