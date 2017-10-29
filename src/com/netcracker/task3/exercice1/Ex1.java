package com.netcracker.task3.exercice1;
import com.netcracker.task3.iObjTime;
import com.netcracker.task3.Time;
import java.util.*;

public class Ex1 {
    public static class SortTime implements iObjTime{
        public int n;
        public int[] arr;
        public iSort f;

        private void printArr() {
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
            System.out.println("");
        }

        public void genArr() {
            n=1000;
            arr=new int[n];
            for (int i=0; i<n; i++)
                arr[i]=(int) (Math.random()*10000000);
        }

        @Override
        public void func() {
            genArr();
            f.sort(arr);
        }
    }

    public static abstract class iSort{
        public abstract void sort(int[] arr);
        public void swap(int[] arr, int i, int j){
            int tmp=arr[i];
            arr[i]=arr[j];
            arr[j]=tmp;
        }
    }

    public static class SelectSort extends iSort{
        public void sort(int[] arr){
            int n=arr.length;
            int min=Integer.MAX_VALUE, jmin=-1;
            for (int i=0; i<n-1; i++) {
                min = Integer.MAX_VALUE;
                for (int j = i + 1; j < n; j++)
                    if (arr[j] < min) {
                        min = arr[j];
                        jmin = j;
                    }
                if (arr[i] > min) swap(arr, i, jmin);
            }


        }
    }

    public static class BubbleSort extends iSort{
        public void sort(int[] arr) {
            int n = arr.length;
            boolean f=false;
            do {
                f = false;
                for (int j = 0; j < n-1; j++)
                    if (arr[j+1] < arr[j]) {
                        swap(arr, j+1, j);
                        f = true;
                    }
                n--;
            }while (f);
        }
    }

    public static class ArraySort extends iSort{
        public void sort(int[] arr){
            Arrays.sort(arr);
        }
    }

    public static void main(String[] args) {
        int it=1000;

        SortTime objT1=new SortTime();
        objT1.f=new BubbleSort();
        System.out.println("time of bubble sort is "+Time.measureTime(objT1,it));
        objT1.printArr();

        SortTime objT2=new SortTime();
        objT2.f=new SelectSort();
        System.out.println("time of select sort is "+Time.measureTime(objT2,it));
        objT2.printArr();

        SortTime objT3=new SortTime();
        objT3.f=new ArraySort();
        System.out.println("time of array sort is "+Time.measureTime(objT3,it));
        objT3.printArr();

    }
}
