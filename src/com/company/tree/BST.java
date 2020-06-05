package com.company.tree;

public class BST {
    private Node root = null;

    public void insert(int input){
        if (root == null){
            root = new Node(input);
            return;
        }
        Node cur = root;
        while(true) {
            if (input < cur.data) {
                if (cur.left == null){
                    cur.left = new Node(input);
                    return;
                }
                cur = cur.left;
            }
            else {
                if (cur.right == null){
                    cur.right = new Node(input);
                    return;
                }
                cur = cur.right;
            }
        }
    }

    public boolean search(int input){
        if (root == null){
            System.out.println("empty");
            return false;
        }
        Node cur = root;
        while(true) {
            if (input < cur.data) {
                if (cur.left == null){
                    System.out.println("can't find");
                    return false;
                }
                cur = cur.left;
            }
            else if (input == cur.data) {
                System.out.println("found it!");
                return true;
            }
            else {
                if (cur.right == null){
                    System.out.println("can't find");
                    return false;
                }
                cur = cur.right;
            }
        }
    }

    public int delete(int input){
        return delete(input, root);
    }
    private int delete(int input,Node node){
        return 0;
    }

    public void print(){
        print(root);
    }

    private void print(Node node){
        if (node == null)
            return;
        System.out.print(node.data);
        print(node.left);
        print(node.right);
    }

    static class Node{
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
}
