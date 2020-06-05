package com.company.prim;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prim {
    private static final int I = Integer.MAX_VALUE;
    static int sum = 0;
    static int[][] arr
            = {
            {I, I, I, I, I, I, I, I},
            {I, I, 25, I, I, I, 5, I},
            {I, 25, I, 12, I, I, I, 10},
            {I, I, 12, I, 8, I, I, I},
            {I, I, I, 8, I, 16, I, 14},
            {I, I, I, I, 16, I, 20, 18},
            {I, 5, I, I, I, 20, I, I},
            {I, I, 10, I, 14, 18, I, I}};

    static List<Integer> vertexList = new ArrayList<>();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        prim();
        long end = System.currentTimeMillis();
        System.out.println("time : " + (end-start)/1000.0 + "ms" );
    }

    public static void prim() {
        int i = 0;
        int j = 0;
        int min = I;
        for (int k = 1; k < arr.length; k++) {
            for (int l = k+1; l < arr.length; l++) {
                if (arr[k][l] < min) {
                    i = k;
                    j = l;
                    min = arr[k][l];
                }
            }
        }
        sum += min;

        vertexList.add(i);
        vertexList.add(j);

        prim(i, j);
    }

    private static void prim(int i, int j) {
        System.out.printf("(%d, %d)\n",i,j);
        if (vertexList.size() == arr.length - 1) {
            System.out.println("total costs : " + sum);
            return;
        }
        int currentVertex = i;
        int nextVertex = -1;
        int minCost = I;
        int [] temp = arr[i];
        for (int k = 0; k < arr.length; k++) {
            if (!vertexList.contains(k) && temp[k] < minCost){
                minCost = temp[k];
                nextVertex = k;
            }
        }
        temp = arr[j];
        for (int k = 0; k < arr.length; k++) {
            if (!vertexList.contains(k) && temp[k] < minCost){
                currentVertex = j;
                minCost = temp[k];
                nextVertex = k;
            }
        }

        sum+=minCost;
        vertexList.add(nextVertex);
        prim(currentVertex,nextVertex);
    }
}
