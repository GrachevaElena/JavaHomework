package com.netcracker.task3;

public class Time {

    public static long measureTime(iObjTime _obj, int it){
        long t1=0, t2=0,t=0;
        for (int i=0; i<it; i++){
            t1=System.nanoTime();
            _obj.func();
            t2=System.nanoTime();
            t+=t2-t1;
        }
        t=t/it;
        return t;
    }
}
