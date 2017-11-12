package com.netcracker.list;

public class Node<E> {
    E element;
    Node nextNode;

    public Node() {
        element=null;
        nextNode=null;
    }

    Node(E element){
        this.element=element;
        Node nextNode=null;
    }

    Node(E element, Node<E> previous, Node<E> next){
        this.element=element;
        this.nextNode=next;
        previous.nextNode=this;
    }


}
