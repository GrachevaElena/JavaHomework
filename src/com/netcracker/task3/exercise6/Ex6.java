package com.netcracker.task3.exercise6;

import com.netcracker.task3.Time;
import com.netcracker.task3.iObjTime;

public class Ex6 {

     public static enum Items{
        item1,
        item2,
        item3,
        item4,
        item5,
        item6,
        item7,
        item8,
        item9,
        item10,
        item11,
        item12,
        item13,
        item14,
        item15
    }

    public static class ArrTime implements iObjTime {
        public int[] arr;
        public iArr f;

        public void genArr(){
            arr=new int[50];
            for (int i=0; i<50; i++)
                arr[i]=(int)(Math.random()*10);
        }

        public void func(){
            f.funcWithArr(arr);
        }
    }

    public static class ItemTime implements iObjTime {
        public Ex6.Items item=Ex6.Items.item3;
        public Ex6.iItem f;

        public void func(){
            f.funcWithItems(item);
        }
    }

    interface iItem{
         public void funcWithItems(Items item);
    }
    interface iArr{
        public int[] funcWithArr(int[] arr);
    }

    public static class ElseIfItem implements iItem {
        public void funcWithItems(Items item) {
            if (item == Items.item1) System.out.println("item1");
            else if (item == Items.item2) System.out.println("item2");
            else if (item == Items.item3) System.out.println("item3");
            else if (item == Items.item4) System.out.println("item4");
            else if (item == Items.item5) System.out.println("item5");
            else if (item == Items.item6) System.out.println("item6");
            else if (item == Items.item7) System.out.println("item7");
            else if (item == Items.item8) System.out.println("item8");
            else if (item == Items.item9) System.out.println("item9");
            else if (item == Items.item10) System.out.println("item10");
            else if (item == Items.item11) System.out.println("item11");
            else if (item == Items.item12) System.out.println("item12");
            else if (item == Items.item13) System.out.println("item13");
            else if (item == Items.item14) System.out.println("item14");
            else if (item == Items.item15) System.out.println("item15");
        }
    }

    public static class SwitchItem implements iItem {
        public void funcWithItems(Items item) {
            switch (item) {
                case item1:
                    System.out.println("item1");
                    break;
                case item2:
                    System.out.println("item2");
                    break;
                case item3:
                    System.out.println("item3");
                    break;
                case item4:
                    System.out.println("item4");
                    break;
                case item5:
                    System.out.println("item5");
                    break;
                case item6:
                    System.out.println("item6");
                    break;
                case item7:
                    System.out.println("item7");
                    break;
                case item8:
                    System.out.println("item8");
                    break;
                case item9:
                    System.out.println("item9");
                    break;
                case item10:
                    System.out.println("item10");
                    break;
                case item11:
                    System.out.println("item11");
                    break;
                case item12:
                    System.out.println("item12");
                    break;
                case item13:
                    System.out.println("item13");
                    break;
                case item14:
                    System.out.println("item14");
                    break;
                case item15:
                    System.out.println("item15");
                    break;
                default:
                    System.out.println("");
            }
        }
    }

    public static class ElseIfArr implements iArr {
        public  void funcForElement(int e) {
            if (e == 0) System.out.println("0");
            else if (e == 1) System.out.println("1");
            else if (e == 2) System.out.println("2");
            else if (e == 3) System.out.println("3");
            else if (e == 4) System.out.println("4");
            else if (e == 5) System.out.println("5");
            else if (e == 6) System.out.println("6");
            else if (e == 7) System.out.println("7");
            else if (e == 8) System.out.println("8");
            else if (e == 9) System.out.println("9");
            else if (e == 10) System.out.println("10");
        }

        public int[] funcWithArr(int[] arr){
            int[] res = new int[11];
            for (int i=0; i<11;i++) res[i]=0;
            for (int e:arr) {
                funcForElement(e);
                res[e]++;
            }
            return res;
        }
    }

    public static class SwitchArr implements iArr {
        public static void funcForElement(int e) {
            switch (e) {
                case 0:
                    System.out.println("0");
                    break;
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
                    break;
                case 6:
                    System.out.println("6");
                    break;
                case 7:
                    System.out.println("7");
                    break;
                case 8:
                    System.out.println("8");
                    break;
                case 9:
                    System.out.println("9");
                    break;
                case 10:
                    System.out.println("10");
                    break;
                default:
                    System.out.println("");
            }
        }

        public int[] funcWithArr(int[] arr) {
            int[] res = new int[11];
            for (int i=0; i<11;i++) res[i]=0;
            for (int e:arr) {
                funcForElement(e);
                res[e]++;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        ItemTime funcItem=new ItemTime();
        int it=10;

        funcItem.f=new ElseIfItem();
        System.out.println("time of if-else with item is "+ Time.measureTime(funcItem,it));

        funcItem.f=new SwitchItem();
        System.out.println("time of switch-case with item is "+ Time.measureTime(funcItem,it));


        ArrTime funcArr=new ArrTime();
        funcArr.genArr();

        funcArr.f=new ElseIfArr();
        System.out.println("time of if-else with arr is "+ Time.measureTime(funcArr,it));

        funcArr.f=new SwitchArr();
        System.out.println("time of switch-case with arr is "+ Time.measureTime(funcArr,it));


        int[] res=funcArr.f.funcWithArr(funcArr.arr);

        for (int i=0; i<11; i++)
            System.out.print(res[i]+" ");



    }
}
