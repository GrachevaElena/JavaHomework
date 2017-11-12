package com.netcracker.list;

public class Node<E> {
    E element;
    Node nextNode;

    Node(E element){
        this.element=element;
        Node nextNode=null;
    }

    void link(Node<E> previous){
        previous.nextNode=this;
    }

    Node(E element, Node<E> previous){
        this.element=element;
        this.nextNode=null;
        link(previous);
    }
}
