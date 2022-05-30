package com.example.demo.start.dao;



/**
 * @author xylong
 * @date 2022/5/5 17:06
 */
public class HistoryWeather{
    private String date;
    private String week;
    private String high;
    private String low;

    public HistoryWeather(String date, String week, String high, String low) {
        this.date = date;
        this.week = week;
        this.high = high;
        this.low = low;
    }

    public HistoryWeather() {
    }

    @Override
    public String toString() {
        return "HistoryWeather{" +
                "date='" + date + '\'' +
                ", week='" + week + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }
}
