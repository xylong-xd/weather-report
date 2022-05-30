package com.example.demo.start.service;

import com.example.demo.start.dao.WeatherInfo;
import com.example.demo.start.util.WeatherUtils;
import com.example.demo.start.util.*;

import javax.rmi.CORBA.Util;
import java.net.MalformedURLException;
import java.sql.SQLException;

/**
 * @author xylong
 * @date 2022/5/5 15:32
 */
public class SetWeather {
    public static WeatherInfo setWeather(String ip) throws MalformedURLException {

        String adcode = getXY.GetXY(ip).getAdcode();
        String city = getXY.GetXY(ip).getCity();
        WeatherInfo wi = WeatherUtils.GetWeather(WeatherUtils.GetWeatherData(adcode));
        String aqi = AqiUtil.findAqi(ip);
        wi.setAqi(aqi);
        wi.setCity(city);

        try {
            WeatherInfo byCity = new SqlService().findByCity(wi.getCity());
            if (byCity.getCity() == null){
                new SqlService().add(wi);
            }else {
                new SqlService().delete(wi);
                new SqlService().add(wi);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



        return wi;
    }
}
