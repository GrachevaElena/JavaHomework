package com.netcracker.time;

import java.util.Collection;
import java.util.Map;

public class Time {
    public void measureTime(Collection<Double> coll,final int N){

        System.out.println(coll.getClass().getName()+" (number of operations=" + N +"): ");

        long t1=System.nanoTime();
        for (int i=0; i<N; i++)
            coll.add(new Double(i));
        long t2=System.nanoTime();

        System.out.println("add: "+(t2-t1));

        t1=System.nanoTime();
        for (int i=0; i<N; i++)
            coll.remove((double)i);
        t2=System.nanoTime();

        System.out.println("remove: "+(t2-t1));

        System.out.println("");

    }

    public void measureTime(Map<Integer, Double> map, final int N){

        System.out.println(map.getClass().getName()+" (number of operations=" + N +"): ");

        long t1=System.nanoTime();
        for (int i=0; i<N; i++)
            map.put(i+N,(double)i);
        long t2=System.nanoTime();

        System.out.println("put: "+(t2-t1));

        t1=System.nanoTime();
        for (int i=0; i<N; i++)
            map.remove(i+N);
        t2=System.nanoTime();

        System.out.println("remove: "+(t2-t1));

        System.out.println("");

    }

}
