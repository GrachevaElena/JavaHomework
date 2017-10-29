package com.netcracker.task3.exercise5;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Ex5 {

    public static<T> void print(T[][] arr){
        for (int i=0; i<arr.length;i++){
            for (int j=0; j<arr[i].length; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println("");
        }

    }
    public static void ex5a(){
        int n=8;
        double[][] arr =new double[n][n];
        for (int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                arr[i][j]=(Math.random()*98)+1;
        double sm=0, mm=1, snm=0, mnm=1;
        for (int i=0; i<n; i++){
            sm+=arr[i][i];
            mm*=arr[i][i];
            snm+=arr[i][n-i-1];
            mnm*=arr[i][n-i-1];
        }
        System.out.println("sum main="+sm);
        System.out.println("mult main="+mm);
        System.out.println("sum not main="+snm);
        System.out.println("mult not main="+mnm);

    }

    public static void ex5b(){
        int m=8,n=5;
        Double[][] arr =new Double[m][n];
        double max=Double.MIN_VALUE, imax=-1, jmax=-1;
        for (int i=0; i<m; i++)
            for (int j = 0; j < n; j++) {
                arr[i][j] = (Math.random() * 198) - 99;
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    imax = i;
                    jmax = j;
                }
            }
        print(arr);
        System.out.println("max="+max);
    }

    public static void ex5c() {
        int m = 8, n = 5;
        Integer[][] arr = new Integer[m][n];
        int max=0, imax=-1;
        for (int i=0; i<m; i++) {
            int mult=1;
            for (int j = 0; j < n; j++) {
                arr[i][j] = (int)(Math.random() * 20) - 10;
                mult*=arr[i][j];
            }
            if(Math.abs(mult)>max) {max=mult; imax=i;}
        }
        print(arr);
        System.out.println("imax="+imax);
    }

    public static void ex5d() {
        int m = 10, n = 7;
        Integer[][] arr = new Integer[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                arr[i][j] = (int) (Math.random() * 100);
        print(arr);
        System.out.println("");
        for (int i=0; i<m; i++)
            Arrays.sort(arr[i], Collections.reverseOrder());
        print(arr);

    }

    public static void main(String[] args) {
        System.out.println("#####A");
        ex5a();
        System.out.println("#####B");
        ex5b();
        System.out.println("#####C");
        ex5c();
        System.out.println("#####D");
        ex5d();
    }
}
