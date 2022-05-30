package com.example.demo.start.util;

import com.example.demo.start.dao.WeatherInfo;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.zip.GZIPInputStream;

/**
 * @author xylong
 * @date 2022/5/5 14:22
 */
public class AqiUtil {
    private static String key = "db61d20d4fda42fea7378951b5563f61";
    private static String weatherUrl = "https://devapi.qweather.com/v7/air/now?location=";


    public static String findAqi(String ip) throws MalformedURLException {
        String x = getXY.GetXY(ip).getX();
        String y = getXY.GetXY(ip).getY();
        URL url = new URL(weatherUrl + x+","+y + "&key=" + key);
        StringBuilder sb = new StringBuilder();
        InputStream is = null;
        BufferedReader br = null;

        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.setReadTimeout(1000);
            conn.setConnectTimeout(1000);
            conn.setRequestProperty("accept" , "*/*");
            conn.setRequestProperty("contentType", "application/json;charset=utf-8");


            is = new GZIPInputStream(conn.getInputStream());
            br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));

            String line;
            while((line = br.readLine()) != null){
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null){
                    br.close();
                }
                if(is != null){
                    is.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return lookAqi(sb.toString());

    }

    public static String lookAqi(String weatherInfobyJson){

        JSONObject dataOfJson = JSONObject.fromObject(weatherInfobyJson); // json天气数据
        dataOfJson = JSONObject.fromObject(dataOfJson.getString("now"));
        String s1 = dataOfJson.getString("aqi");
        return s1;
    }

}
