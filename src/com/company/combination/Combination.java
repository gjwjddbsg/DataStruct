package com.company.combination;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    private static List<Integer> list = new ArrayList<>();

    public static void getAllComb(int n, int r){
        getAllComb(n,r,1);
    }
    private static void getAllComb(int n, int r, int index){
        if (list.size() == r){
            System.out.println(list);
            return;
        }
        for (int i = index; i <= n ; i++) {
            if (!list.contains(i)){
                list.add(i);
                getAllComb(n,r,i+1);
                list.remove(list.size()-1);
            }
        }
    }

    public static int comb(int n, int r){
        if (n == r || r == 0)
            return 1;
        return comb(n-1,r) + comb(n-1,r-1);
    }
}
