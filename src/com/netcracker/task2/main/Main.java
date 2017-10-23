package com.netcracker.task2.main;
import com.netcracker.task2.classes.*;
import com.netcracker.task2.classes.ball.*;

public class Main {

    public static void main(String[] args) {

        MyComplex a1,a2;
        a1=new MyComplex(1,2);
        a2=new MyComplex(1,2);

        System.out.println(a1==a2);
        System.out.println(a1.equals(a2));
        System.out.println(a1.equals(1,2));

        System.out.println("");

        MyPolynomial p1=new MyPolynomial(1,2,3,4,5);
        MyPolynomial p2=new MyPolynomial(1,1);

        System.out.println(p1.GetDegree());
        System.out.println(p1);
        System.out.println(p2.GetDegree());
        System.out.println(p2);

        System.out.println(p1.add(p2));
        System.out.println(p1.multiply(p2));
        System.out.println(p2.multiply(p1));

        System.out.println("");

        Container cont=new Container(0,0,12,8);
        Ball ball=new Ball(6,-4, 1, 2, 30);
        for (int i=0; i<10; i++){
            ball.move();
            if (!cont.collidesHeight(ball)) ball.reflectVertical();
            if (!cont.collidesWidth(ball)) ball.reflectHorisontal();
            System.out.println(ball.getX()+" "+ball.getY());
        }
    }
}
