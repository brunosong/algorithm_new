package com.brunosong.algorithm_new.재귀기초;

import org.junit.jupiter.api.Test;

import java.util.*;

public class 그래프최단거리 {

    int node = 6;

    int[] dis = new int[node + 1];

    public List<List<Integer>> graph;

    int[] ch = new int[node + 1];

    @Test
    void 그래프최단거리(){

        int[][] arr = {
                {1 ,3},
                {1 ,4},
                {2 ,1},
                {2 ,5},
                {3 ,4},
                {4 ,5},
                {4 ,6},
                {6 ,2},
                {6 ,5}
        };

        graph = new ArrayList<>();

        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < arr.length; i++) {
            int node = arr[i][0];
            int goNode = arr[i][1];

            graph.get(node).add(goNode);
        }

        BFS(1);

        System.out.println(Arrays.toString(dis));

    }




    void BFS(int v){

        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);

        while (!queue.isEmpty()) {

            Integer node = queue.poll();

            List<Integer> nextNodes = graph.get(node);

            for (int i = 0 ; i < nextNodes.size() ; i++ ){

                Integer nextNode = nextNodes.get(i);

                if(ch[nextNode] == 0) {
                    ch[nextNode] = 1;
                    queue.add(nextNode);
                    dis[nextNode] = dis[node] + 1;
                }
            }

        }


    }





}
