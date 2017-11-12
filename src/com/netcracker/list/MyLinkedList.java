package com.netcracker.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedList<E> implements ILinkedList<E>{
    //List<E> l=new LinkedList<>();


    @Override
    public void add(E element) {

    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public E[] toArray() {
        return new E[0];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<Node<E>>(){
            @Override
            public void remove() {

            }

            @Override
            public E next() {
                return null;
            }

            @Override
            public boolean hasNext() {
                return false;
            }
        };
    }
}
