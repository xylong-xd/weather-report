package com.example.demo.start.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xylong
 * @date 2022/5/6 19:02
 */
public class getNow {

    ArrayList<String> dateArray = new ArrayList<String>();
    public ArrayList<String> getdateArray(){
        Calendar cal = Calendar.getInstance();

        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");

        dateArray.add(sdf.format(cal.getTime()));


        try {
            for (int i = 0; i < 5; i++) {

                Date sDate = sdf.parse(sdf.format(cal.getTime()));
                cal.setTime(sDate);
                cal.add(Calendar.DAY_OF_MONTH,1);

                sDate = cal.getTime();

                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

                dateArray.add(sdf1.format(sDate));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return dateArray;
    }
}
