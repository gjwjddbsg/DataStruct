package com.company.LL;

class CircularLinkedList implements myLinkedList{
    @Override
    public String toString() {
        return display();
    }

    public Node head = null;
    public Node tail = null;

    public void add(int data){
        if (head == null){
            head = new Node();
            head.data = data;
            head.next = head;
            tail = head;
        }
        else {
            Node cursor = head;
            while (cursor != tail){
                cursor = cursor.next;
            }
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = head;
            cursor.next = newNode;
            tail = newNode;
        }
    }
    public void add(int index, int data){
        if (index < 1){
            System.out.println("index is too small");
        }
        else if (head == null && index !=1){
            System.out.println("there is no list");
        }
        else {
            if (index == 1){
                addFirst(data);
            }
            else{
                Node cursor = head;
                for (int i = 1 ; i < index-1 ; i ++){
                    if (cursor.next == head){
                        System.out.println("index is out of bound");
                        return;
                    }
                    cursor = cursor.next;
                }
                Node newNode = new Node();
                newNode.data = data;
                newNode.next = cursor.next;
                cursor.next = newNode;
            }
        }
    }
    public void addFirst(int data){
        if (head == null){
            head = new Node();
            head.data = data;
            head.next = head;
            tail = head;

        }
        else {
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }
    public void addLast(int data){
        add(data);
    }

    public String display(){
        String result = "";
        if (head == null){
            return "empty";
        }
        Node cursor = head;
        while (cursor != tail){
            result += cursor.data + "->";
            cursor = cursor.next;
        }

        return result + cursor.data;
    }
    public int get(int index){
        if (head == null){
            System.out.println("There is no data");
            return 0;
        }
        else {
            Node cursor = head;
            for (int i = 0; i < index - 1; i++) {
                if (cursor == tail){
                    System.out.println("There is no data");
                    return 0;
                }
                cursor = cursor.next;
            }
            return cursor.data;
        }
    }
    public int remove(int index){
        if (head == null){
            System.out.println("list is empty");
            return 0;
        }
        if (index < 0){
            System.out.println("new index please");
            return 0;
        }
        Node cursor = head;
        if (index <= 1){
            int result = head.data;
            removeFirst();
            return result;
        }
        for (int i = 1; i < index-1 ; i ++){
            cursor = cursor.next;
            if (cursor == tail){
                System.out.println("list is out of bound");
                return 0;
            }
        }
        int result = cursor.next.data;
        cursor.next = cursor.next.next;
        return result;
    }
    public int removeFirst(){
        if (head == null){
            System.out.println("list is empty");
            return 0;
        }
        int result = head.data;
        if (head.next == head){
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            tail.next = head;
        }
        return result;
    }
    public int removeLast(){
        if (head == null){
            System.out.println("list is empty");
            return 0;
        }
        if (size() == 1){
            return removeFirst();
        }
        else {
            Node cursor = head;
            while (cursor.next != tail){
                cursor = cursor.next;
            }
            int result = cursor.next.data;
            cursor.next = head;
            tail = cursor;
            return result;
        }
    }
    public int size(){
        if (head == null){
            return 0;
        }
        else {
            int size = 1;
            Node cursor = head;
            while (cursor != tail){
                size ++;
                cursor = cursor.next;
            }
            return size;
        }
    }
    public String sorted(){
        int size = size();
        int [] arr= new int[size];
        Node cursor = head;
        for (int i = 0 ; i < size ; i ++){
            arr[i] = cursor.data;
            cursor = cursor.next;
        }
        for (int i = 0 ; i < size ; i ++ ){
            for (int j = i+1 ; j < size ; j ++ )
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
        }
        String result = "";
        for (int i = 0 ; i < size-1; i ++){
            result += arr[i] + "->";
        }
        return result+arr[size-1];
    }
    public void sort(){
        int size = size();
        int [] arr= new int[size];
        Node cursor = head;
        for (int i = 0 ; i < size ; i ++){
            arr[i] = cursor.data;
            cursor = cursor.next;
        }
        for (int i = 0 ; i < size ; i ++ ){
            for (int j = i+1 ; j < size ; j ++ )
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
        }
        cursor = head;
        for (int i = 0 ; i < size ; i++){
            cursor.data = arr[i];
            cursor = cursor.next;
        }
    }
    public boolean loopCheck(){

        if (head == null){
            return false;
        }
        else{
            boolean flag = false;
            Node p = head;
            Node q = head;
            do{
                p = p.next.next;
                q = q.next;
                if(p==q){
                    flag = true;
                    break;
                }
            }while(q.next != null && p.next.next != null);
            return flag;
        }

    }
}
