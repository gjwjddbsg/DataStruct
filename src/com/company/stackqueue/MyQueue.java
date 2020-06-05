package com.company.stackqueue;
import java.util.LinkedList;

public class MyQueue<T> {
    private Node<T> head = null;

    public T add(T s){
        if (head == null){
            head = new Node<T>();
            head.data = s;
        }
        else {
            Node cur = head;
            while (cur.next != null){
                cur = cur.next;
            }
            Node newNode = new Node<>();
            newNode.data = s;
            cur.next = newNode;
        }
        return s;
    }
    public T remove(){
        if (head == null){
            System.out.println("ERROR : Empty Queue");
            return null;
        }
        T result = head.data;
        head = head.next;
        return result;
    }
    public T peek(){
        if (head == null){
            System.out.println("ERROR : Empty Queue");
            return null;
        }
        Node<T> cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }return cur.data;
    }
    public boolean empty(){
        return head == null;
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
    public T search(T data){
        if (head == null){
            System.out.println("ERROR : Empty Queue");
            return null;
        }
        Node<T> cur = head;
        do {
            if (cur.data == data){
                return data;
            }
            cur = cur.next;
        } while (cur.next != null);
        System.out.println("ERROR : No Data");
        return null;
    }

}
