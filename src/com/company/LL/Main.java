package com.company.LL;

class Node{
    int data;
    Node next;
    Node before; //if need
}

public class Main {
    public static void main(String[] args) {
        SingleLinkedList l1 = new SingleLinkedList();
        SingleLinkedList l2 = new SingleLinkedList();
        for(int i=0; i<50; i++) {
            l1.add((int)(Math.random()*100));
        }
        for(int i=1; i<49; i++){
            l2.add((int)(Math.random()*100));
        }
        l1.sort();
        l2.sort();
        System.out.println(l1);
        System.out.println(l2);
        l1.concat(l2);
        System.out.println(l1);
        System.out.println(l2);
    }
    public static SingleLinkedList merge (SingleLinkedList l1, SingleLinkedList l2){
        SingleLinkedList result = new SingleLinkedList();
        int p=1;
        int q=1;
        while (p<=l1.size() && q<=l2.size()){
            if (l1.get(p)<l2.get(q)){
                result.add(l1.get(p));
                p++;
            }
            else {
                result.add(l2.get(q));
                q++;
            }
        }
        if (p<=l1.size()){
            for (; p <= l1.size() ; p++){
                result.add(l1.get(p));
            }
        }
        else if (q<=l2.size()){
            for (; q <= l2.size() ; q++){
                result.add(l2.get(q));
            }
        }
        return result;
    }
}