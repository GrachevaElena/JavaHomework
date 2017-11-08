package com.netcracker.library;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MyDate extends GregorianCalendar {
    //Месяцы 0->11 на 1->12

    public MyDate(int year, int month, int dayOfMonth) {
        super(year, month, dayOfMonth);
    }
    public MyDate(String line){
        int day = Integer.parseInt(line.substring(0, 2));
        int month = Integer.parseInt(line.substring(3, 5));
        int year = Integer.parseInt(line.substring(6, 10));
        set(DATE,day);
        set(MONTH,month-1);
        set(YEAR,year);
    }

    public MyDate() {
        super();
    }

    @Override
    public String toString() {
        String s="";
        if (get(DATE)<10) s+="0";
        s+=get(DATE);
        s+=".";
        if(get(MONTH)<10) s+="0";
        s+=(get(MONTH)+1);
        s+=".";
        s+=get(YEAR);
        return s;
    }

}
