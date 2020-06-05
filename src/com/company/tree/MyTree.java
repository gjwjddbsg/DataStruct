package com.company.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyTree {

    private static Scanner sc = new Scanner(System.in);
    private static Queue BUFFER = new Queue();
    private static Stack stack = new Stack();

    private Node root;

    public void insert() {
        System.out.print("input root value : ");
        root = new Node(sc.nextInt());
        BUFFER.enqueue(root);

        while (true) {
            Node cur = BUFFER.dequeue();
            //left
            int value = sc.nextInt();
            if (value == -1) return;
            cur.left = new Node(value);
            BUFFER.enqueue(cur.left);
            //right
            value = sc.nextInt();
            if (value == -1) return;
            cur.right = new Node(value);
            BUFFER.enqueue(cur.right);
        }
    }

    public void printWithStack() {
        stack = new Stack();
        List<Node> list = new ArrayList<>();
        stack.push(root);
        list.add(root);
        Node newNode = root;
        while (stack.size() != 0){
            if (newNode.left != null && list.indexOf(newNode.left) == -1){
                newNode = newNode.left;
                list.add(newNode);
                stack.push(newNode);
            }else if (newNode.right != null && list.indexOf(newNode.right) == -1){
                newNode = newNode.right;
                list.add(newNode);
                stack.push(newNode);
            }else{
                stack.pop(); newNode = stack.get();
            }
        }
        System.out.println(list);
    }

    public void printWithLevel() {
        BUFFER = new Queue();
        BUFFER.enqueue(root);
        List<Node> toPrint = new ArrayList<>();
        while (!BUFFER.isEmpty()) {
            Node newNode = BUFFER.dequeue();
            toPrint.add(newNode);
            if (newNode.left != null) {
                BUFFER.enqueue(newNode.left);
            }
            if (newNode.right != null) {
                BUFFER.enqueue(newNode.right);
            }
        }
        System.out.println(toPrint);
    }

    public void insertByRound() {

    }

    public void height(){
        stack = new Stack();
        List<Node> list = new ArrayList<>();
        int MAX = 0;
        stack.push(root);
        list.add(root);
        Node newNode = root;
        while (stack.size() != 0){
            if (newNode.left != null && list.indexOf(newNode.left) == -1){
                newNode = newNode.left;
                list.add(newNode);
                stack.push(newNode);
            }else if (newNode.right != null && list.indexOf(newNode.right) == -1){
                newNode = newNode.right;
                list.add(newNode);
                stack.push(newNode);
            }else{
                if (MAX < stack.size())
                    MAX = stack.size();
                stack.pop(); newNode = stack.get();
            }
        }
        System.out.println(MAX);

    }

    public void countNode() {
        System.out.println(countNode(root));
    }

    private int countNode(Node node) {
        if (node == null)
            return 0;
        return countNode(node.left) + countNode(node.right) + 1;
    }

    public void traverse() {
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            preOrder(node.left);
            System.out.print(node);
            preOrder(node.right);
        }

    }

    private void postOrder(Node node) {
        if (node != null) {
            preOrder(node.left);
            preOrder(node.right);
            System.out.print(node);
        }
    }

    static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data + " ";
        }
    }

    static class Queue {
        private final ArrayList<Node> queue = new ArrayList<>();

        public void enqueue(Node node) {
            queue.add(node);
        }

        public Node dequeue() {
            if (!queue.isEmpty()) {
                return queue.remove(0);
            }
            return null;
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    static class Stack {
        private final ArrayList<Node> stack = new ArrayList<>();

        public void push(Node node) {
            stack.add(node);
        }

        public Node pop() {
            if (!stack.isEmpty()) {
                return stack.remove(stack.size() - 1);
            }
            return null;
        }

        public Node get(){
            if (!stack.isEmpty()) {
                return stack.get(stack.size() - 1);
            }
            return null;
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }

        public int size() {
            return stack.size();
        }
    }
}