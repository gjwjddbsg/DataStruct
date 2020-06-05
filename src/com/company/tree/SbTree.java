package com.company.tree;

import java.util.ArrayList;
import java.util.List;

public class SbTree {

    public static void main(String[] args) {
        SbTree tree = new SbTree();
        System.out.println(tree.find("parents"));

        tree.add(tree.find("grand parents"), "parents");
        System.out.println(tree.find("parents"));

        tree.add(tree.find("parents"),"sb");
        System.out.println(tree.find("sb"));
    }

    Node root = new Node("grand parents");

    public boolean add(Node parent, String name){
        parent.childList.add(new Node(name));
        return true;
    }

    public Node find(String name){
        return find(root, name);
    }

    private Node find(Node node, String name){
        if (node.data.equals(name))
            return node;
        for (int i = 0; i < node.childList.size(); i++) {
            Node temp = find(node.childList.get(i),name);
            if (temp != null){
                return temp;
            }
        }
        return null;
    }

    static class Node{
        String data;
        List<Node> childList;

        public Node(String name) {
            this.data = name;
            this.childList = new ArrayList<>();
        }

        @Override
        public String toString() {
            return this.data;
        }
    }
}

