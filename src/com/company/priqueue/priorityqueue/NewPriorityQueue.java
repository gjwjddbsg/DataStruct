package com.company.priqueue.priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NewPriorityQueue<E>{
    private final List<PriorityData<E>> list = new ArrayList<>();

    public void enqueue(E data, int cost){
        list.add(new PriorityData<>(data,cost));
        list.sort(Comparator.comparing(PriorityData::getCosts));
    }
    public E dequeue(){
        return list.remove(0).getData();
    }

    public void print(){
        list.forEach(System.out::println);
    }
}
class PriorityData<T> {
    private T data;
    private int costs;

    public PriorityData(T data, int costs) {
        this.data = data;
        this.costs = costs;
    }

    public T getData() {
        return data;
    }

    public int getCosts() {
        return costs;
    }

    @Override
    public String toString() {
        return "data=" + data +
                ", costs=" + costs;
    }
}
