package com.brunosong.algorithm_new.BFS;

import org.junit.jupiter.api.Test;

import java.util.*;

public class 최소비행료 {

    static class Flight {

        int next;
        int money;

        public Flight(int next, int money) {
            this.next = next;
            this.money = money;
        }
    }

    int n = 4;

    
    @Test
    void test() {

        int[][] flights = {
                {0, 1, 10},
                {1, 2, 20},
                {0, 2, 70},
                {0, 3, 100},
                {1, 3, 80},
                {2, 3, 10},
                {2, 4, 30},
                {3, 4, 10}
        };
        //0 3 1 80

        int start = 0; //시작지
        int arri = 3; //도착지
        int k = 1; //경유지

        List<List<Flight>> graph = new ArrayList<>();

        for (int i = 0; i <= 4; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] arr : flights) {
            graph.get(arr[0]).add(new Flight(arr[1],arr[2]));
        }

        int[] dis = new int[n + 1];
        Arrays.fill(dis,Integer.MAX_VALUE);

        System.out.println(BFS(start,graph,dis,arri,k));
        //System.out.println(solution2(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
    }


    public int BFS(int start, List<List<Flight>> graph, int[] dis, int endPoint, int k) {

        int answer = -1;

        Queue<Flight> queue = new LinkedList<>();
        queue.offer(new Flight(0, 0));

        dis[start] = 0;
        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Flight f = queue.poll();
                int now = f.next;
                int nowCost = f.money;

                for (Flight flight : graph.get(now)) {
                    int next = flight.next;
                    int cost = flight.money;

                    // 현재의 비용과 다음목적지 비용을 더해서 넣어준다.
                    if(dis[next] > cost + nowCost){
                        dis[next] = cost + nowCost;
                        queue.add(new Flight(next, dis[next]));
                    }

                }
            }
            level++;
            if(level > k) break;

        }

        if(dis[endPoint] == 1000000000) return -1;
        else return dis[endPoint];

    }


    public int solution2(int n, int[][] flights, int s, int e, int k){
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<int[]>());
        }
        int[] costs = new int[n];
        Arrays.fill(costs, 1000000000);
        for(int[] x : flights){
            graph.get(x[0]).add(new int[]{x[1], x[2]});
        }
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{s, 0});
        costs[s] = 0;
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int[] p = Q.poll();
                int now = p[0];
                int nowcost = p[1];
                for(int[] x : graph.get(now)){
                    int next = x[0];
                    int cost = x[1];
                    if(nowcost + cost < costs[next]){
                        costs[next] = nowcost + cost;
                        Q.offer(new int[]{next, costs[next]});
                    }
                }
            }
            L++;
            if(L > k) break;
        }
        if(costs[e] == 1000000000) return -1;
        else return costs[e];
    }



}
