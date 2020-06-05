package com.company.LL;

interface myLinkedList{
    void add(int data);
    void add(int index, int data);
    void addFirst(int data);
    void addLast(int data);
    int remove(int index);
    int removeFirst();
    int removeLast();
    int get(int index);
    String display();
    void sort();
    String sorted();
}
