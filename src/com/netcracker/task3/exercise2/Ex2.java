package com.netcracker.task3.exercise2;
import com.netcracker.task3.Time;
import com.netcracker.task3.iObjTime;

public class Ex2 {

    public static class FactTime implements iObjTime {
        public int n;
        public Ex2.iFact f;

        @Override
        public void func(){
            f.fact(this.n);
        }

    }

    interface iFact {
         long fact(int n);
    }

    static class RecFact implements iFact {
        public long fact(int n) {
            if (n == 0) return 1;
            return n * fact(n - 1);
        }
    }

    static class LoopFact implements iFact {
        public long fact(int n) {
            long res = 1;
            for (int i = 1; i <= n; i++)
                res *= i;
            return res;
        }
    }

    public static void main(String[] args) {
        FactTime objT=new FactTime();

        objT.n=25;
        long res=0;
        int it=10000;

        objT.f=new LoopFact();
        System.out.println("time of fact by loop is "+Time.measureTime(objT,it));

        objT.f=new RecFact();
        System.out.println("time of fact by recursion is "+Time.measureTime(objT,it));

    }
}
