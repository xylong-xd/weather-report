package com.example.demo.start.util;

import com.example.demo.start.dao.HistoryWeather;
import com.example.demo.start.dao.WeatherInfo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xylong
 * @date 2022/5/5 13:02
 */
public class WeatherUtils {
    private static String ak = "FENmUfNmFYj3zIK7unEnLqCPKiA86PXr";
    private static String weatherUrl = "https://api.map.baidu.com/weather/v1/?district_id=";
    private static Map<String, HistoryWeather> map = new HashMap<>();


    public static String GetWeatherData(String dis) {

        StringBuilder sb = new StringBuilder();

        BufferedReader reader = null;

        try {

            URL url = new URL(weatherUrl + dis +"&data_type=all&ak="+ak);

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

        return sb.toString();

    }

    public static JSONObject getRes(String s){
        JSONObject dataOfJson = JSONObject.fromObject(s);
        dataOfJson = JSONObject.fromObject(dataOfJson.getString("result"));
        return dataOfJson;
    }


    public static Map<String,HistoryWeather> GetHis(String weatherInfobyJson){

        JSONObject dataOfJson = getRes(weatherInfobyJson);
//        JSONObject s1 = JSONObject.fromObject(dataOfJson.getString("forecasts"));
        String s = dataOfJson.getString("forecasts");
//        String high = s1.getString("high");

        JSONArray jsonArray = JSONArray.fromObject(s);


        for (int i = 0; i < 5; i++) {
            HistoryWeather historyWeather = new HistoryWeather();
            JSONObject res = (JSONObject) jsonArray.get(i);
            String date = res.getString("date");
            String week = res.getString("week");
            String high = res.getString("high");
            String low = res.getString("low");
            historyWeather.setHigh(high);
            historyWeather.setLow(low);
            historyWeather.setDate(date);
            historyWeather.setWeek(week);
            map.put(date,historyWeather);
        }
//        for (int i = 0; i < 5; i++) {
//            JSONObject res = (JSONObject) jsonArray.get(i);

//        }
        return map;
    }

    public static WeatherInfo GetWeather(String weatherInfobyJson){

//        JSONObject dataOfJson = JSONObject.fromObject(weatherInfobyJson); // json天气数据


        WeatherInfo weatherInfo = new WeatherInfo();

        Calendar cal = Calendar.getInstance(); // Calendar类的实例化
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日"); // 时间的格式化
        weatherInfo.setUptime(sdf1.format(cal.getTime())); // 时间

//        dataOfJson = JSONObject.fromObject(dataOfJson.getString("result"));
        JSONObject dataOfJson = getRes(weatherInfobyJson);
        JSONObject s1 = JSONObject.fromObject(dataOfJson.getString("now"));
        weatherInfo.setText(s1.getString("text"));

        weatherInfo.setTemp(s1.getString("temp"));

        weatherInfo.setFeels_like(s1.getString("feels_like"));

        weatherInfo.setRh(s1.getString("rh"));
        weatherInfo.setWind_class(s1.getString("wind_class"));
        weatherInfo.setWind_dir(s1.getString("wind_dir"));
//        weatherInfo.setAqi(s1.getString("aqi"));
        weatherInfo.setAqi("5");


        return weatherInfo;

    }

}
