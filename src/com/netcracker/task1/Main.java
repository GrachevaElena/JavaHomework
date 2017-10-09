package com.netcracker.task1;

public class Main {

    public static void main(String[] args) {

        Circle c = new Circle();
        System.out.println(c.toString());

        c.setColor("green");
        c.setRadius(2);
        System.out.println(c.toString());
        System.out.println(c.getArea());

    }

}
