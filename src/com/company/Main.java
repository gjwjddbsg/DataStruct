package com.company;

import com.company.queuetest.NewStack;

public class Main {
    public static void main(String[] args) {
        NewStack<Integer> stack = new NewStack<>();
        System.out.println(stack);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        for (int i = 0; i < 15; i++) {
            stack.pop();
            System.out.println(stack);
        }
    }
}
