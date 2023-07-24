package com.brunosong.algorithm_new.재귀;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 경로탐색_DFS {

    public static List<List<Integer>> graph;
    public static int[] dis;

    public static int max = 5;

    public static void main(String[] args) {
        dis = new int[max + 1];

        int[][] arr = {
            {1 ,2},
            {1 ,3},
            {1 ,4},
            {2 ,1},
            {2 ,3},
            {2 ,5},
            {3 ,4},
            {4 ,2},
            {4 ,5}
        };

        graph = new ArrayList<>();

        for (int i = 0; i <= 5; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < arr.length; i++) {
            int node = arr[i][0];
            int goNode = arr[i][1];

            graph.get(node).add(goNode);
        }

        dis[1] = 1;

        DFS(1);

    }


    public static void DFS(int node){

        if(node == max) {
            System.out.println(Arrays.toString(dis));
        } else {

            List<Integer> nodes = graph.get(node);

            for (int i = 0; i < nodes.size(); i++) {

                Integer n = nodes.get(i);

                if( dis[n] == 0 ) {
                    dis[n] = 1;
                    DFS(n);
                    dis[n] = 0;
                }
            }
        }

    }


}
