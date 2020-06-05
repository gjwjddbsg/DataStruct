package com.company.stackqueue;

public class MyStack<T> {
    private Node<T> head = null;

    public T push(T s){
        if (head == null){
            head = new Node<>();
            head.data = s;
        }
        else {
            Node<T> cur = head;
            while (cur.next != null){
                cur = cur.next;
            }
            Node<T> newNode = new Node<>();
            newNode.data = s;
            cur.next = newNode;
        }
        return s;
    }
    public T pop(){
        if (head == null){
            System.out.println("ERROR : Empty Queue");
            return null;
        }
        Node<T> cur = head;
        Node<T> cur1 = head;
        while (cur.next != null){
            cur1 = cur;
            cur = cur.next;

        }
        T result = cur.data;
        cur1.next = null;
        if (cur == head){
            head = null;
        }
        return result;

    }
    public boolean empty(){
        return head == null;
    }
    public T search(T data){
        if (head == null){
            System.out.println("ERROR : Empty Queue");
            return null;
        }
        Node<T> cur = head;
        do {
            if (cur.data == data){
                return cur.data;
            }
            cur = cur.next;
        } while (cur.next != null);
        System.out.println("ERROR : No Data");
        return null;
    }
    public T peek(){
        if (head == null){
            System.out.println("ERROR : Empty Queue");
            return null;
        }
        Node<T> cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur.data;
    }

    @Override
    public String toString() {
        if (head == null){
            return "empty";
        }
        else{
            String result = "";
            Node cur = head;
            while(cur.next != null){
                result += cur.data + "->";
                cur = cur.next;
            }
            result += cur.data;
            return result;
        }
    }
}
