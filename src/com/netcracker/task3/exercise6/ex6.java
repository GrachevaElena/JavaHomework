package com.netcracker.task3.exercise6;

public class ex6 {

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

    public static void else_if(Items item){
        if (item== Items.item1) System.out.println("item1");
        else if (item== Items.item2) System.out.println("item2");
        else if (item== Items.item3) System.out.println("item3");
        else if (item== Items.item4) System.out.println("item4");
        else if (item== Items.item5) System.out.println("item5");
        else if (item== Items.item6) System.out.println("item6");
        else if (item== Items.item7) System.out.println("item7");
        else if (item== Items.item8) System.out.println("item8");
        else if (item== Items.item9) System.out.println("item9");
        else if (item== Items.item10) System.out.println("item10");
        else if (item== Items.item11) System.out.println("item11");
        else if (item== Items.item12) System.out.println("item12");
        else if (item== Items.item13) System.out.println("item13");
        else if (item== Items.item14) System.out.println("item14");
        else if (item== Items.item15) System.out.println("item15");
    }

    public static void switch_case(Items item){
        switch (item){
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
            default: System.out.println("");
        }
    }

    public static void else_if_for_int(int e){
        if (e== 0) System.out.println("0");
        else if (e== 1) System.out.println("1");
        else if (e== 2) System.out.println("2");
        else if (e== 3) System.out.println("3");
        else if (e== 4) System.out.println("4");
        else if (e== 5) System.out.println("5");
        else if (e== 6) System.out.println("6");
        else if (e== 7) System.out.println("7");
        else if (e== 8) System.out.println("8");
        else if (e== 9) System.out.println("9");
        else if (e== 10) System.out.println("10");
    }

    public static void switch_case_for_int(int e){
        switch (e){
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
            default: System.out.println("");
        }
    }

    public static void main(String[] args) {
        long t1=0, t2=0;
        Items item=Items.item3;

        t1=System.nanoTime();
        else_if(item);
        t2=System.nanoTime();
        System.out.println("else_if time="+(t2-t1));

        t1=System.nanoTime();
        switch_case(item);
        t2=System.nanoTime();
        System.out.println("else_if time="+(t2-t1));

        int[] arr=new int[50];
        for (int i=0; i<50; i++)
            arr[i]=(int)(Math.random()*10);

        int[] res=new int[11];
        for (int i=0; i<11;i++) res[i]=0;

        t1=System.nanoTime();
        for (int e:arr) {
            else_if_for_int(e);
            res[e]++;
        }
        t2=System.nanoTime();
        System.out.println("else_if time="+(t2-t1));
        for (int i=0; i<11;i++) System.out.print(res[i]+" ");
        System.out.println("");

        for (int i=0; i<11;i++) res[i]=0;

        t1=System.nanoTime();
        for (int e:arr) {
            switch_case_for_int(e);
            res[e]++;
        }
        t2=System.nanoTime();
        System.out.println("switch_case time="+(t2-t1));
        for (int i=0; i<11;i++) System.out.print(res[i]+" ");
        System.out.println("");



    }
}
