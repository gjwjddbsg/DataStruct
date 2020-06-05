package com.company.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyGraph {

    private int arr[][] = new int[][]{
            {0, 1, 1, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0},
            {1, 1, 0, 1, 1, 0, 0},
            {1, 0, 1, 0, 1, 0, 0},
            {0, 0, 1, 1, 0, 1, 1},
            {0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 0}
    };

    private int arr2[][] = new int[][]{
            {0, 946, 916, 482, 639, 185},
            {946, 0, 497, 747, 237, 956},
            {916, 497, 0, 768, 601, 886},
            {482, 747, 768, 0, 124, 258},
            {639, 237, 601, 124, 0, 361},
            {185, 956, 886, 258, 361, 0}
    };

    private final MyQueue queue = new MyQueue();
    private final MyStack stack = new MyStack();
    private List<Integer> checkList = new ArrayList<>();

    public void prim(int input) {
        checkList = new ArrayList<>();
        checkList.add(input);
        int sum = 0;
        while (checkList.size() < 6) {
            List<Integer> minList = new ArrayList<>();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < checkList.size(); i++) {
                for (int j = 0; j < 6; j++) {
                    int index = arr2[checkList.get(i) - 1][j];
                    if (index != 0 && checkList.indexOf(index) == -1) {
                        minList.add(index);
                        tempList.add(j + 1);
                    }
                }
            }
            while (checkList.indexOf(tempList.get(minList.indexOf(Collections.min(minList)))) != -1) {
                tempList.remove(minList.indexOf(Collections.min(minList)));
                minList.remove(minList.indexOf(Collections.min(minList)));
            }
            sum += Collections.min(minList);
            checkList.add(tempList.get(minList.indexOf(Collections.min(minList))));
        }
        System.out.println(sum);
    }



    public void kruskal() {
        List<int[]> minList = new ArrayList<>();
        for (int i = 0 ; i < 7; i ++){
            for (int j = i; j < 7; j++) {
                if (arr2[i][j] != 0){
                    int [] nums = new int[3];
                    nums[0] = arr2[i][j];
                    nums[1] = i; nums[2] = j;
                    minList.add(nums);
                }
            }
        }
        for (int i = 0; i < minList.size(); i++) {
            for (int j = i + 1; j < minList.size(); j++) {
                if (minList.get(i)[0] > minList.get(j)[0]) {
                    Collections.swap(minList, i, j);
                }
            }
        }

    }

    public void BFS(int n) {
        // use queue
        int index = n - 1;
        checkList = new ArrayList<>();
        checkList.add(n);
        System.out.print(n + " ");

        int[] curArr = arr[index];
        for (int i = 0; i < curArr.length; i++) {
            if (curArr[i] == 1) {
                if (checkList.indexOf(i + 1) == -1) {
                    queue.enqueue(i + 1);
                    checkList.add(i + 1);
                }
            }
        }
        if (!queue.isEmpty())
            BFS(queue.dequeue());
    }

    public void DFS(int n) {
        int index = n - 1;
        checkList = new ArrayList<>();
        checkList.add(n);
        System.out.print(n + " ");
        // use stack or recursive
        int[] curArr = arr[index];
        for (int i = 0; i < curArr.length; i++) {
            if (curArr[i] == 1) {
                if (checkList.indexOf(i + 1) == -1) {
                    stack.push(i + 1);
                    checkList.add(i + 1);
                    DFS(i + 1);
                }
            }
        }
        if (!stack.isEmpty())
            stack.pop();
    }

    private class MyQueue {
        private List<Integer> list = new ArrayList<>();

        public void enqueue(int num) {
            list.add(num);
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public int dequeue() {
            if (!list.isEmpty()) {
                return list.remove(0);
            }
            System.out.println("empty");
            return -1;
        }
    }

    private class MyStack {
        private List<Integer> list = new ArrayList<>();

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public void push(int num) {
            list.add(num);
        }

        public int pop() {
            if (!list.isEmpty()) {
                return list.remove(list.size() - 1);
            }
            System.out.println("empty");
            return -1;
        }
    }
}
