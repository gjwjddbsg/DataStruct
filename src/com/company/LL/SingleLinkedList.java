package com.company.LL;

class SingleLinkedList implements myLinkedList{
    @Override
    public String toString() {
        return display();
    }

    private Node head = null;

    public void add(int data){
        if (head == null){
            head = new Node();
            head.data = data;
        }
        else {
            Node cursor = head;
            while (cursor.next != null){
                cursor = cursor.next;
            }
            Node newNode = new Node();
            newNode.data = data;
            cursor.next = newNode;
        }
    }
    public void add(int index, int data){
        if (index < 1){
            System.out.println("index is too small");
        }
        else if (head == null && index != 1 ){
            System.out.println("index is out of bound");
        }
        else {
            if (index == 1){
                addFirst(data);
            }
            else{
                Node cursor = head;
                for (int i = 1 ; i < index-1 ; i ++){
                    if (cursor.next == null){
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
        }
        else {
            Node newNode = new Node();
            newNode.data = data;
            newNode.next = head;
            head = newNode;
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
        while (cursor.next!=null){
            result += cursor.data + "->";
            cursor = cursor.next;
        }
        return result+cursor.data;
    }
    public int get(int index){
        if (head == null){
            System.out.println("There is no data");
            return 0;
        }
        else {
            Node cursor = head;
            for (int i = 0; i < index - 1; i++) {
                if (cursor.next == null){
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
            if (cursor.next == null){
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
        head = head.next;
        return result;
    }
    public int removeLast(){
        if (head == null){
            System.out.println("list is empty");
            return 0;
        }
        Node cursor = head;
        if (size() == 1){
            return removeFirst();
        }
        while (cursor.next.next != null){
            cursor = cursor.next;
        }
        int result = cursor.next.data;
        cursor.next = null;
        return result;
    }
    public int size(){
        int size = 0;
        Node cursor = head;
        while (cursor != null){
            size ++;
            cursor = cursor.next;
        }
        return size;
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
            for (int j = 0 ; j < size-1 ; j ++ )
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        }
        cursor = head;
        for (int i = 0 ; i < size ; i++){
            cursor.data = arr[i];
            cursor = cursor.next;
        }
    }
    public SingleLinkedList merge(SingleLinkedList list){
        SingleLinkedList result = new SingleLinkedList();
        Node p = head;
        Node q = list.head;
        while (p != null && q != null){
            if (p.data < q.data){
                result.add(p.data);
                p = p.next;
            }
            else {
                result.add(q.data);
                q = q.next;
            }
        }
        for (;p!=null;p=p.next){
            result.add(p.data);
        }
        for (;q!=null;q=q.next){
            result.add(q.data);
        }
        return result;
    }
    public void concat(SingleLinkedList list){
        SingleLinkedList result = new SingleLinkedList();
        Node p = head;
        Node q = list.head;
        int index = 1;
        while (p!= null && q != null){
            if (p.data > q.data) {
                this.add(index,q.data);
                q = q.next;
            }
            else {
                p = p.next;
            }
            index++;
        }
        for (;q!=null;q=q.next){
            this.add(q.data);
        }
    }
}
