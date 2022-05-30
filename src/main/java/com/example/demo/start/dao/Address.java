package com.example.demo.start.dao;

/**
 * @author xylong
 * @date 2022/5/5 15:19
 */
public class Address {
    private String adcode;
    private String x;
    private String y;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address(String city) {
        this.city = city;
    }

    public Address() {
    }

    public Address(String adcode, String x, String y) {
        this.adcode = adcode;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Address{" +
                "adcode='" + adcode + '\'' +
                ", x='" + x + '\'' +
                ", y='" + y + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}
