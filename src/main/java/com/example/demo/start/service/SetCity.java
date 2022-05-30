package com.example.demo.start.service;

import com.example.demo.start.dao.Address;
import com.example.demo.start.util.*;
/**
 * @author xylong
 * @date 2022/5/5 16:54
 */
public class SetCity {
    public static Address setadd(String ip){
        Address address = new Address();
        String city = getXY.GetXY(ip).getCity();
        address.setCity(city);
        return address;

    }
}
