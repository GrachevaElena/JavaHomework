package com.netcracker.list;

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

        list.clear();

        System.out.println("clear: "+list);

    }
}
