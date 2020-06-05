package com.company.priqueue;

import com.company.priqueue.priorityqueue.NewPriorityQueue;

public class Main {
    public static void main(String[] args) {
        NewPriorityQueue<String> queue = new NewPriorityQueue<>();
        queue.enqueue("hello",5);
        queue.enqueue("hell",4);
        queue.enqueue("string",4);
        queue.enqueue("sting",2);
        queue.enqueue("ring",2);
        queue.enqueue("tri",1);
        queue.enqueue("sri",3);

        queue.print();
    }

}
