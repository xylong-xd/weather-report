package com.example.demo.start.dao;

/**
 * @author xylong
 * @date 2022/5/3 10:43
 */
public class WeatherInfo {
    private String text;
    private String temp;
    private String feels_like;
    private String rh;
    private String wind_class;
    private String wind_dir;
    private String uptime;
    private String aqi;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public WeatherInfo() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public String getWind_class() {
        return wind_class;
    }

    public void setWind_class(String wind_class) {
        this.wind_class = wind_class;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public void setWind_dir(String wind_dir) {
        this.wind_dir = wind_dir;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    @Override
    public String toString() {
        return "WeatherInfo{" +
                "text='" + text + '\'' +
                ", temp='" + temp + '\'' +
                ", feels_like='" + feels_like + '\'' +
                ", rh='" + rh + '\'' +
                ", wind_class='" + wind_class + '\'' +
                ", wind_dir='" + wind_dir + '\'' +
                ", uptime='" + uptime + '\'' +
                ", aqi='" + aqi + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public WeatherInfo(String text, String temp, String feels_like, String rh, String wind_class, String wind_dir, String uptime, String aqi, String city) {
        this.text = text;
        this.temp = temp;
        this.feels_like = feels_like;
        this.rh = rh;
        this.wind_class = wind_class;
        this.wind_dir = wind_dir;
        this.uptime = uptime;
        this.aqi = aqi;
        this.city = city;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

}
