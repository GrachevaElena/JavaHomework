package com.netcracker.task3.exercise2;

public class ex2 {

    public static long recFact(int n) {
        if (n==0) return 1;
        return n*recFact(n-1);
    }

    public static long loopFact(int n){
        long res=1;
        for (int i=1; i<=n; i++)
            res*=i;
        return res;
    }

    public static void main(String[] args) {
        int n=25;
        long res=0;

        long t1=System.nanoTime(), t2=0;
        res=loopFact(n);
        t2=System.nanoTime();
        System.out.println("time loop="+(t2-t1));
        System.out.println("res="+res);

        t1=System.nanoTime();
        res=recFact(n);
        t2=System.nanoTime();
        System.out.println("time rec="+(t2-t1));
        System.out.println("res="+res);

    }
}
