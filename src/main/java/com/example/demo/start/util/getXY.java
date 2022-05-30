package com.example.demo.start.util;

import com.example.demo.start.dao.Address;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author xylong
 * @date 2022/5/3 17:04
 */
public class getXY {

    private static String ak = "FENmUfNmFYj3zIK7unEnLqCPKiA86PXr";
    private static String weatherUrl = "http://api.map.baidu.com/location/ip?ak="+ak+"&ip=";
    public static Address GetXY(String ip) {

        StringBuilder sb = new StringBuilder();

        BufferedReader reader = null;

        try {

            URL url = new URL(weatherUrl + ip + "&coor=bd09ll");

            URLConnection conn = url.openConnection();

            InputStream is = conn.getInputStream();

//            GZIPInputStream gzin = new GZIPInputStream(is);



            InputStreamReader isr = new InputStreamReader(is, "utf-8");


            reader = new BufferedReader(isr);

            String line = null;

            while((line = reader.readLine()) != null){

                sb.append(line + " ");

            }

            reader.close();

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (Exception e) {

            e.printStackTrace();

        }

        String xy = sb.toString();

        JSONObject dataOfJson = JSONObject.fromObject(xy);
        JSONObject s1 = JSONObject.fromObject(dataOfJson.getString("content"));
        JSONObject s2 = JSONObject.fromObject( s1.getString("address_detail"));
        String adcode = s2.getString("adcode");
        String city = s2.getString("city");

        Address add = new Address();
        JSONObject point =JSONObject.fromObject( s1.getString("point"));

        String x = point.getString("x");
        String y = point.getString("y");

        add.setAdcode(adcode);

        add.setX(x);
        add.setY(y);
        add.setCity(city);
        return add;




    }
}
