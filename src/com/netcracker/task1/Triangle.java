package com.netcracker.task1;

public class Triangle {
    Point v1;
    Point v2;
    Point v3;

    public Triangle(Point v1, Point v2, Point v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.v1 = new Point(x1,y1);
        this.v2 = new Point(x2,y2);;
        this.v3 = new Point(x3,y3);;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "v1=" + v1 +
                ", v2=" + v2 +
                ", v3=" + v3 +
                '}';
    }

    public double getPerimeter(){
        return this.v1.Distance(v2)+this.v2.Distance(v3)+this.v3.Distance(v1);
    }

    public String getType(){
        if (v1.Distance(v2)==v2.Distance(v3)){
            if (v1.Distance(v2)==v1.Distance(v3)) return "Equilateral";
            else return "Isosceles";
        }
        if (v1.Distance(v2)==v1.Distance(v3)){
            return "Isosceles";
        }
        if (v3.Distance(v2)==v1.Distance(v3)){
            return "Isosceles";
        }
        return "Scalene";
    }
}
