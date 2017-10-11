package com.netcracker.task1;

public class Main {

    public static void main(String[] args) {

        Circle c = new Circle();
        System.out.println(c);

        c.setColor("green");
        c.setRadius(2);
        System.out.println(c);
        System.out.println(c.getArea());

        System.out.println("");

        Rectangle r = new Rectangle(2,3);

        System.out.println(r);
        System.out.println(r.getPerimeter());
        System.out.println(r.getArea());

        System.out.println("");

        Employee emp=new Employee(1,"Vasya","Ivanov", 20000);

        System.out.println(emp);
        System.out.println(emp.raiseSalary(10));
        System.out.println(emp.getSalary());

        System.out.println("");

        Author[] authors = new Author[3];
        authors[0]=new Author("A.Pushkin");
        authors[1]=new Author("M.Lermontov");
        authors[2]=new Author("S.Esenin");
        Book b=new Book("Poems",authors,1000);

        System.out.println(b);
        System.out.println(b.getAuthorNames());

        System.out.println("");

        Point p=new Point(1,2);

        System.out.println(p);
        System.out.println(p.Distance(2,1));
        System.out.println(p.Distance(new Point (1,5)));
        int x,y;
        x=p.getXY()[0];
        y=p.getXY()[1];
        System.out.print(x);
        System.out.println(y);
        p.setX(10);
        System.out.println(x);

        System.out.println("");

        Triangle t=new Triangle(0,0,0,3,4,0);
        Triangle t1=new Triangle(0,0,0,1,1,0);

        System.out.println(t);
        System.out.println(t.getPerimeter());
        System.out.println(t.getType());
        System.out.println(t1.getType());




    }

}
