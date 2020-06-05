package com.company.heapsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Heap {
    private List<Integer> list = new ArrayList<>();

    private void checkHeap(int index){
        if (list.get(index/2) < list.get(index)) {
            Collections.swap(list, index / 2, index);
            checkHeap(index / 2);
        }
    }

    public void insert(int num){
        list.add(num);
        checkHeap(list.indexOf(num));
    }
    public void display(){
        list.forEach(System.out::println);
    }
}
