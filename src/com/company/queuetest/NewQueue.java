package com.company.queuetest;

public class NewQueue<E> {
    Node<E> head;
    Node<E> tail;

    public NewQueue(){
        tail = head = null;
    }

    public void push(int data){
        if (head == null){
            tail = head = new Node(data);
            return;
        }
        tail.next = new Node(data);
        tail = tail.next;
    }
    public E pop(){
        try {
            E result = head.data;
            head = head.next;
            return result;
        } catch (NullPointerException e){
            System.out.print("NO DATA::ERRORCODE ");
            return null;
        }

    }

    @Override
    public String toString(){
        if (head == null)
            return null;
        StringBuilder builder = new StringBuilder();
        Node temp = head;
        while(temp.next!= null) {
            builder.append(temp.data).append(" -> ");
            temp = temp.next;
        }
        builder.append(temp.data);
        return builder.toString();
    }
}

