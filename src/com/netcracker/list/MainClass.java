package com.netcracker.list;

import java.util.Iterator;

public class MainClass {

    public static void main(String[] args) {
        ILinkedList<Double> list = new MyLinkedList<>();

        System.out.println("created: "+list);

        list.add(1.0);
        list.add(2.0);
        list.add(3.0);

        System.out.println("add: "+list);

        list.add(0, 0.5);
        list.add(2, 1.5);
        list.add(5, 4.0);

        System.out.println("add with index: "+list);

        System.out.print("iterator: ");
        for(Iterator<Double> it = list.iterator(); it.hasNext();)
            System.out.print(it.next()+" ");
        System.out.println("");

        list.set(0, 0.6);
        list.set(2, 1.6);
        list.set(5, 4.1);

        System.out.println("set: "+list);

        System.out.println("get: "+list.get(0));
        System.out.println("get: "+list.get(2));
        System.out.println("get: "+list.get(5));

        System.out.println("size: "+list.size());

        list.remove(5);
        list.remove(2);
        list.remove(0);

        System.out.println("remove: "+list);

        Iterator<Double> it=list.iterator();
        it.next();
        it.remove();
        it.next();
        it.remove();

        System.out.println("iterator removed, list is : "+list);

        list.clear();

        System.out.println("clear: "+list);


    }
}
