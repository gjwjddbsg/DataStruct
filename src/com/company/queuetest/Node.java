package com.company.queuetest;

class Node<E>{
    E data;
    Node<E> next;
    Node<E> prev;

    public Node(E data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    public Node (E data, Node<E> next, Node<E> prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
