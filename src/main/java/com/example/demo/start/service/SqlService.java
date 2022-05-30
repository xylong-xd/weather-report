package com.example.demo.start.service;

import com.example.demo.start.dao.WeatherInfo;
import com.example.demo.start.dao.AddtoMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.* ;
import java.sql.DriverManager;
/**
 * @author xylong
 * @date 2022/5/6 11:32
 */

public class SqlService {

    Connection con = null;
    Statement stmt = null;


    public void add(WeatherInfo weatherInfo){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weather","root", "000000");
            stmt = con.createStatement();
            String sql = "INSERT INTO weatherinfo(text,temp,feels_like,rh,wind_class,wind_dir,uptime,aqi,city) VALUES(";
            String val = "\""+weatherInfo.getText()+"\",\""+weatherInfo.getTemp()+"\",\""+weatherInfo.getFeels_like()+"\",\""+weatherInfo.getRh()+"\",\""+weatherInfo.getWind_class()+"\",\""+weatherInfo.getWind_dir()+"\",\""+weatherInfo.getUptime()+"\",\""+weatherInfo.getAqi()+"\",\""+weatherInfo.getCity()+"\"";
//            System.out.println(sql+val+");");
            String sql1 = sql+val+");";
            System.out.println(stmt.executeUpdate(sql1));
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public WeatherInfo findByCity(String city) throws ClassNotFoundException, SQLException {

        WeatherInfo weatherInfo = new WeatherInfo();

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weather", "root", "000000");
        stmt = con.createStatement();
        String sql = "SELECT * FROM weatherinfo WHERE city = ";
        String val = "\"" + city + "\"";

        String sql1 = sql + val + ";";
        System.out.println(sql1);
        ResultSet rs = stmt.executeQuery(sql1);

        while (rs.next()){
            String text=rs.getString("text");
            String temp = rs.getString("temp");
            String feels_like=rs.getString("feels_like");
            String rh = rs.getString("rh");
            String wind_class=rs.getString("wind_class");
            String wind_dir = rs.getString("wind_dir");
            String uptime=rs.getString("uptime");
            String aqi = rs.getString("aqi");

            weatherInfo.setText(text);
            weatherInfo.setTemp(temp);
            weatherInfo.setFeels_like(feels_like);
            weatherInfo.setRh(rh);
            weatherInfo.setWind_class(wind_class);
            weatherInfo.setWind_dir(wind_dir);
            weatherInfo.setUptime(uptime);
            weatherInfo.setAqi(aqi);
            weatherInfo.setCity(city);


        }



        con.close();
        return weatherInfo;
    }
    public void delete(WeatherInfo weatherInfo){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/weather","root", "000000");
            stmt = con.createStatement();
            String sql = "DELETE FROM weatherinfo WHERE city = ";
            String val = "\""+weatherInfo.getCity()+"\"";
            String sql1 = sql+val+";";
            System.out.println(stmt.executeUpdate(sql1));
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}



