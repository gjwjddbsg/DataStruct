package com.company.sorting;

import java.util.*;

public class MySort {

    static List<Integer> tempList = new ArrayList<>();

    public static void radixSort(int [] arr){
        List<MyQueue> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new MyQueue());
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }

        int pow = 1;
        while (pow <= max) {
            for (int i = 0; i < arr.length; i++) {
                list.get((arr[i]/pow)%10).enqueue(arr[i]);
            }
            for (int i = 0; i < 10; i++) {
                MyQueue temp = list.get(i);
                while(!temp.isEmpty()){
                   tempList.add(temp.dequeue()) ;
                }
            }
            System.out.println(tempList);
            tempList = new ArrayList<>();
            pow*=10;
        }
    }

    public static void quickSort(int [] arr) {
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,arr.length-1);
        System.out.println("QuickSort : "+Arrays.toString(arr));
    }

    private static void quickSort(int [] arr, int start, int end){
        if (start >= end)
            return;
        int pivot = arr[start];
        int i = start + 1;
        int j = end;
        while (i < j){
            if (arr[i] > pivot && pivot > arr[j]){
                swap(arr,i,j);
                i++; j--;
            }
            if (arr[i] <= pivot)
                i++;
            if (arr[j] >= pivot)
                j--;
        }
        if (pivot > arr[j]) {
            arr[start] = arr[j];
            arr[j] = pivot;
        }
        System.out.println(Arrays.toString(arr));
        quickSort(arr,start,j-1);
        quickSort(arr,j,end);

    }

    public static void bubbleSort(int [] arr){
        final int size = arr.length;
        for (int i = 0; i < size ; i ++){
            boolean flag = false;
            for (int j = 1; j < size - i; j++) {
                if (arr[j-1] > arr[j]){
                    flag = true;
                    swap(arr,j-1,j);
                }
            }
            if(!flag) break;
        }
        System.out.println("bubblePop : " + Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        final int size = arr.length;
        for (int i = 1; i <size ; i++) {
            int temp = arr[i];
            int j = i;
            while(true) {
                if (j  == 0 || arr[j-1] < temp) {
                    arr[j] = temp;
                    break;
                }
                else{
                    arr[j] = arr[j-1];
                    j --;
                }
            }
        }
        System.out.println("insertSort :"+Arrays.toString(arr));
    }

    private static void swap(final int [] arr, final int i, final int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class MyQueue{
    private List<Integer> list = new ArrayList<>();
    public void enqueue(int num){
        list.add(num);
    }
    public int dequeue(){
        return list.remove(0);
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
}