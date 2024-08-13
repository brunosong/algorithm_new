package com.brunosong.algorithm_new.프로그래머스;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 배달 {

    @Test
    void test() {
        
        int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};

        Assertions.assertThat(solution(5,road,3)).isEqualTo(4);

    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        for (int[] r : road) {
            graph.get(r[0]).add(new Edge(r[1],r[2]));
            graph.get(r[1]).add(new Edge(r[0],r[2]));
        }

        return findRoad(graph,N,K);
    }


    int findRoad(List<List<Edge>> graph, int N, int K) {
        int[] dis = new int[N+1];
        Arrays.fill(dis,Integer.MAX_VALUE);

        PriorityQueue<Edge> pQueue = new PriorityQueue<>((e1,e2) -> e1.cost - e2.cost);
        pQueue.offer(new Edge(1,0));
        dis[1] = 0;

        while (!pQueue.isEmpty()) {
            Edge currentNode = pQueue.poll();
            int arrive = currentNode.arrive;
            int cost = currentNode.cost;

            if(dis[currentNode.arrive] < cost) continue;

            for (Edge nextNode : graph.get(arrive)) {
                int nextCost = cost + nextNode.cost;

                if(nextCost < dis[nextNode.arrive]) {
                    dis[nextNode.arrive] = nextCost;
                    pQueue.offer(new Edge(nextNode.arrive,nextCost));
                }
            }

        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dis[i] <= K) {
                answer++;
            }
        }

        return answer;

    }




    public static class Edge {

        int arrive;
        int cost;

        public Edge(int arrive, int cost) {
            this.arrive = arrive;
            this.cost = cost;
        }
    }



}
