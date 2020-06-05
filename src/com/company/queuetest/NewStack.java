package com.company.queuetest;

public class NewStack<E> {
    private Node<E> head;
    private Node<E> tail;

    public NewStack() {
        tail = head = null;
    }

    public void push(E data){
        if (head == null){
            tail = head = new Node<>(data);
            return;
        }
        Node<E> newNode = new Node<>(data,null,tail);
        tail.next = newNode;
        tail = tail.next;

    }

    public E pop(){
        try {
            Node<E> result = tail;
            if (head.next == null){
                head = tail = null;
            }
            tail = tail.prev;
            tail.next = null;
            return result.data;
        }catch (NullPointerException e){
            return null;
        }

    }

    @Override
    public String toString() {
        if (tail == null){
            return "empty";
        }
        StringBuilder builder = new StringBuilder();
        Node<E> temp = head;
        while(temp != null){
            builder.append(temp.data).append(" ");
            temp = temp.next;
        }
        return builder.toString();
    }
}
