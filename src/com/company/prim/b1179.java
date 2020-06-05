package com.company.prim;

import java.util.*;

public class b1179{
    static int [] parent;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<int[]> edges = new ArrayList<>();
        int vertex = scan.nextInt();
        int edge = scan.nextInt();

        parent = new int[vertex+1];
        for (int i = 0; i < vertex+1; i++)
            parent[i] = i;

        int sum = 0;
        for (int i = 0; i < edge; i++) {
            edges.add(new int[]{scan.nextInt(),scan.nextInt(),scan.nextInt()});
        }

        edges.sort(Comparator.comparingInt(x->x[2]));
        while(!edges.isEmpty()){
            int [] temp = edges.remove(0);
            if (find(temp[0]) != find(temp[1])) {
                union(temp[0], temp[1]);
                sum += temp[2];
            }
        }
        System.out.println(sum);
    }

    static void union(int i, int j){
        parent[i] = parent[j] = Math.min(find(i),find(j));
    }

    static int find(int i){
        int k = parent[i];
        if (k < i){
            return parent[i] = find(k);
        }
        return k;
    }
}
