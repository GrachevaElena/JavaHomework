package com.netcracker.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E>{

    private Node<E> head=new Node();
    private Node<E> last=null;

    public MyLinkedList() {
        last=head;
    }

    private Node getPreviousNode(int index){
        if (index<0) throw new IndexOutOfBoundsException();
        Node node=head;
        for (int i=-1; node!=null && i<index-1; i++, node=node.nextNode);
        if (node==null) throw new IndexOutOfBoundsException();
        return node;
    }

    @Override
    public void add(E element) {
        last=new Node(element,last,null);
    }

    @Override
    public void add(int index, E element) {
        Node prevNode=getPreviousNode(index);
        new Node(element, prevNode,prevNode.nextNode);
    }

    @Override
    public void clear() {
        head.nextNode=null;
        last=head;
    }

    @Override
    public E get(int index) {
        Node prevNode=getPreviousNode(index);
        if (prevNode.nextNode==null) throw new IndexOutOfBoundsException();
        return (E) prevNode.nextNode.element;
    }

    @Override
    public int indexOf(E element) {
        Node node=head.nextNode;
        int index;
        for (index=0; node!=null && node.element!=element; index++, node=node.nextNode);
        if (node==null) return -1;
        return index;
    }

    @Override
    public E remove(int index) {
        Node prevNode=getPreviousNode(index);

        if (prevNode.nextNode==null) throw new IndexOutOfBoundsException();

        Node node=prevNode.nextNode;
        prevNode.nextNode=node.nextNode;
        return (E) node.element;
    }

    @Override
    public E set(int index, E element) {
        Node prevNode=getPreviousNode(index);
        if (prevNode.nextNode==null) throw new IndexOutOfBoundsException();
        E prevEl=(E) prevNode.nextNode.element;
        prevNode.nextNode.element=element;
        return prevEl;
    }

    @Override
    public int size() {
        int size=0;
        Node node=head.nextNode;
        for (;node!=null;size++, node=node.nextNode);
        return size;
    }

    @Override
    public E[] toArray() {
        Object[] arr=new Object[size()];
        int i=0;
        for (Node node=head.nextNode; node!=null; node=node.nextNode, i++)
            arr[i]=node.element;
        return (E[]) arr;
    }

    @Override
    public String toString() {
        String str=new String("");
        for (Node node=head.nextNode; node!=null; node=node.nextNode) {
            str +=node.element.toString();
            str+=" ";
        }
        return str;
    }

    private class MyListIterator<E> implements Iterator<E>{
        Node curNode;

        public MyListIterator() {
            curNode=head;
        }

        @Override
        public void remove() {
            if (curNode==head) throw new IllegalStateException();
            int index=0;
            for (Node node=head.nextNode; node!=null && node!=curNode; index++, node=node.nextNode);
            curNode=curNode.nextNode;
            MyLinkedList.this.remove(index);
        }

        @Override
        public E next() {
            curNode=curNode.nextNode;
            if (curNode==null) throw new NoSuchElementException();
            return (E) curNode.element;
        }

        @Override
        public boolean hasNext() {
            return (curNode.nextNode!=null);
        }

        public E current(){
            return (E) curNode.element;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyListIterator<>();
    }

}
