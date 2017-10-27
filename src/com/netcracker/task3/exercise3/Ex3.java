package com.netcracker.task3.exercise3;

public class Ex3 {

    public static void ex3a(){
        int size = 5;
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++)
                System.out.print("# ");
            System.out.print('\n');
        }

    }

    public static void ex3bf() {
        int size=7;
        for (int i=0; i<size; i++){
            System.out.print("# ");
        }
        System.out.print('\n');
        for (int j=1; j<size-1; j++) {
            for (int i = 0; i < size; i++)
                if (i == j) System.out.print("# ");
                else System.out.print("  ");
            System.out.print('\n');
        }
        for (int i=0; i<size; i++){
            System.out.print("# ");
        }
        System.out.print('\n');
    }

    public static void ex3bi() {
        int size=7;
        for (int i=0; i<size; i++){
            System.out.print("# ");
        }
        System.out.print('\n');
        for (int j=1; j<size-1; j++) {
            System.out.print("# ");
            for (int i = 1; i < size-1; i++)
                if (i == j || i==size-j-1) System.out.print("# ");
                else System.out.print("  ");
            System.out.print("# ");
            System.out.print('\n');
        }
        for (int i=0; i<size; i++){
            System.out.print("# ");
        }
        System.out.print('\n');
    }

    public static void ex3bd(){
        int size = 7;
        for (int i=0; i<size; i++){
            for (int j=0; j<size-i-1; j++)
                System.out.print("  ");
            for (int j=size-i-1; j<size; j++)
                System.out.print("# ");
            System.out.print('\n');
        }

    }

    public static void main(String[] args) {
        ex3a();
        System.out.println("");
        ex3bf();
        System.out.println("");
        ex3bi();
        System.out.println("");
        ex3bd();
        System.out.println("");
    }
}
