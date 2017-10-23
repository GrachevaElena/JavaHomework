package com.netcracker.task2.classes.ball;

public class Container {

    int x1;
    int x2;
    int y1;
    int y2;

    public Container(int x, int y, int width, int height) {
        this.x1 = x1;
        this.x2 = x1+width;
        this.y1 = y1;
        this.y2 = y1-height;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth(){
        return x2-x1;
    }

    public int getHeight(){
        return y1-y2;
    }

    @Override
    public String toString() {
        return "Container{" +
                "(" + x1 + "," + y1 + "),("
                + y1 + "," + y2 + ")" +
                '}';
    }

    public boolean collides(Ball ball){
        return collidesHeight(ball)&& collidesWidth(ball);
    }

    public boolean collidesWidth(Ball ball){
        return (ball.getX()-ball.getRadius()>x1 && ball.getX()+ball.getRadius()<x2);
    }

    public boolean collidesHeight(Ball ball){
        return (ball.getY()-ball.getRadius()>y2 && ball.getY()+ball.getRadius()<y1);
    }
}
