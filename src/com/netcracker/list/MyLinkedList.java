package com.netcracker.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyLinkedList<E> implements ILinkedList<E>{

    private Node<E> first=null;
    private Node<E> last=null;

    private void addFirst(E element){
        Node node=new Node(element);
        if (first==null){
            first=node;
            last=first;
        }
        else {
            Node nextNode=first;
            nextNode.link(node);
            first=node;
        }

    }

    private void addLast(E element){
        last=new Node(element, last);
    }

    private Node getPreviousNode(int index){
        if (index<0) throw new IndexOutOfBoundsException();
        if (index==0) return null;
        Node node=first;
        for (int i=0; node!=null && i<index-1; i++, node=node.nextNode);
        if (node==null) throw new IndexOutOfBoundsException();
        return node;
    }

    @Override
    public void add(E element) {
        if (last==null) {
            addFirst(element);
            return;
        }
        addLast(element);
    }

    @Override
    public void add(int index, E element) {
        if (index==0) {
            addFirst(element);
            return;
        }

        Node prevNode=getPreviousNode(index);
        if (prevNode.nextNode==null){
            addLast(element);
            return;
        }

        Node newNode=new Node(element);
        prevNode.nextNode.link(newNode);
        prevNode.nextNode=newNode;
    }

    @Override
    public void clear() {
        first=null;
        last=null;
    }

    @Override
    public E get(int index) {
        if (index==0) {
            return first.element;
        }
        Node prevNode=getPreviousNode(index);
        if (prevNode.nextNode==null) throw new IndexOutOfBoundsException();
        return (E) prevNode.nextNode.element;
    }

    @Override
    public int indexOf(E element) {
        Node node=first;
        int index;
        for (index=0; node!=null && node.element!=element; index++, node=node.nextNode);
        if (node==null) return -1;
        return index;
    }

    @Override
    public E remove(int index) {
        if (index==0) {
            E el=first.element;
            first=first.nextNode;
            return el;
        }
        Node prevNode=getPreviousNode(index);

        if (prevNode.nextNode==null) throw new IndexOutOfBoundsException();

        Node node=prevNode.nextNode;
        prevNode.nextNode=node.nextNode;
        return (E) node.element;
    }

    @Override
    public E set(int index, E element) {
        if (index==0){
            E prevEl=first.element;
            first.element=element;
            return prevEl;
        }
        Node prevNode=getPreviousNode(index);
        if (prevNode.nextNode==null) throw new IndexOutOfBoundsException();
        E prevEl=(E) prevNode.nextNode.element;
        prevNode.nextNode.element=element;
        return prevEl;
    }

    @Override
    public int size() {
        int size=0;
        Node node=first;
        for (;node!=null;size++, node=node.nextNode);
        return size;
    }

    @Override
    public E[] toArray() {
        Object[] arr=new Object[size()];
        int i=0;
        for (Node node=first; node!=null; node=node.nextNode, i++)
            arr[i]=node.element;
        return (E[]) arr;
    }

    @Override
    public String toString() {
        String str=new String("");
        for (Node node=first; node!=null; node=node.nextNode) {
            str +=node.element.toString();
            str+=" ";
        }
        return str;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
        /*return new Iterator<>(){
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
        };*/
    }
}
