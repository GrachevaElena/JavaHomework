package com.netcracker.task3.exercise4;

public class Ex4 {

    public static<T> void print(T[] arr){
        for (int i=0; i<arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println("");
    }

    public static void ex4a(){
        Integer[] arr=new Integer[50];
        for (int i=0; i<50;i++)
            arr[i]=1+i*2;
        print(arr);
        for (int i=49; i>=0; i--)
            System.out.print(arr[i]+" ");
        System.out.println("");
    }

    public static void ex4b(){
        Integer[] arr=new Integer[20];
        for (int i=0; i<20;i++) {
            arr[i] = (int) (Math.random() * 10);
        }
        print(arr);
        int ch=0, nch=0;
        for (int i=0; i<20; i++) {
            if (arr[i]%2==0) ch++;
            else nch++;
        }
        System.out.println("ch="+ch);
        System.out.println("nch="+nch);

    }

    public static void ex4c(){
        Integer[] arr=new Integer[10];
        for (int i=0; i<10;i++) {
            arr[i] = (int) (Math.random() * 99)+1;
        }
        print(arr);
        for (int i=0; i<5; i++) {
            arr[2*i+1]=0;
        }
        print(arr);
    }

    public static void ex4d(){
        Integer[] arr=new Integer[15];
        int max=-Integer.MAX_VALUE, imax=-1, min=Integer.MAX_VALUE, imin=-1;
        for (int i=0; i<15;i++) {
            arr[i] = (int) (Math.random() * 100)-50;
            if (arr[i]<min) {min=arr[i]; imin=i;}
            else if (arr[i]>max) {max=arr[i]; imax=i;}
        }
        System.out.println("max="+max);
        System.out.println("min="+min);
        System.out.println("imax="+imax);

    }

    public static void ex4e(){
        int n=10;
        int s1=0, s2=0;
        Integer[] arr1=new Integer[n], arr2=new Integer[n];
        for (int i=0; i<n;i++) {
            arr1[i] = (int) (Math.random() * 10);
            s1+=arr1[i];
            arr2[i] = (int) (Math.random() * 10);
            s2+=arr2[i];
        }
        print(arr1);
        print(arr2);
        double sa1=((double)s1)/n;
        double sa2=((double)s2)/n;
        System.out.println("sa1="+sa1);
        System.out.println("sa2="+sa2);
        if (sa1>sa2) System.out.println("sa1>sa2");
        else if (sa1<sa2) System.out.println("sa1<sa2");
        else System.out.println("sa1=sa2");
    }

    public static void ex4f(){
        int n=20, n1=0, n_1=0, n0=0;
        int[] arr=new int[n];
        for (int i=0; i<n; i++) {
            arr[i]=(int)(Math.random()*2)-1;
            switch(arr[i]){
                case -1: n_1++; break;
                case 0: n0++; break;
                case 1: n1++; break;
            }
        }
        int max=Math.max(Math.max(n_1,n0), n1);
        if (max==n_1) System.out.println("-1");
        if (max==n0) System.out.println("0");
        if (max==n1) System.out.println("1");

    }

    public static void main(String[] args) {
        System.out.println("#####A");
        ex4a();
        System.out.println("#####B");
        ex4b();
        System.out.println("#####C");
        ex4c();
        System.out.println("#####D");
        ex4d();
        System.out.println("#####E");
        ex4e();
        System.out.println("#####F");
        ex4f();
    }
}
