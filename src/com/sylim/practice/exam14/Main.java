package com.sylim.practice.exam14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        // 1 현재의 날짜를 Date형으로 얻는다
        Date now = new Date();
        
        // 2 얻은 날짜정보를 Calendar에 설정한다
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        
        // 3 Calendar에서 일(day)값을 얻는다
        int day = calendar.get(Calendar.DATE);
        // System.out.println(day);
        
        // 4 얻은 값에 100을 더한 값을 Calendar의 일에 설정한다
        calendar.add(Calendar.DATE, 100);
        // System.out.println(calendar);
        
        // 5 Calendar의 날짜정보를 Date형으로 변환한다 
        Date caldate = calendar.getTime();
        
        // 6 SimpleDateFormat을 이용하여 Data 인스턴스의 내용을 표시한다
        SimpleDateFormat format = new SimpleDateFormat("서기 yyyy년 MM월 dd일");
        
        String calstr = format.format(caldate);
        System.out.println(calstr);
//        
//        Date result = format.parse(calstr);
//        System.out.println(result);
        
        
    }
}
