package com.brunosong.algorithm_new.BFS;

import org.junit.jupiter.api.Test;

import java.util.*;

public class 프로그래머스 {

    @Test
    void test2() {
        int[][] vertex = {
                {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
        };
        System.out.println(solution2(6, vertex));
    }

    @Test
    void test() {
//
//        문제 설명
//        n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.
//
//                노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.
//
//                제한사항
//        노드의 개수 n은 2 이상 20,000 이하입니다.
//                간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
//        vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.

//        n	vertex	return
//        6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3

        int n = 6;


        int[][] arr =
                    {
                        {3, 6},
                        {4, 3},
                        {3, 2},
                        {1, 3},
                        {1, 2},
                        {2, 4},
                        {5, 2}
                    };

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < arr.length; i++) {
            graph.get(arr[i][0]).add(arr[i][1]);
            graph.get(arr[i][1]).add(arr[i][0]);
        }

        System.out.println(graph);

        BFS(graph,n);

    }

    void BFS(List<List<Integer>> graph, int n) {

        int[] dis = new int[n + 1];
        Arrays.fill(dis, -1);
        dis[1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {

            int currentNode = queue.poll();

            for (int node : graph.get(currentNode)) {
                if(dis[node] == -1) {
                    dis[node] = dis[currentNode] + 1;
                    queue.offer(node);
                }
            }
        }

        int max = Arrays.stream(dis).max().orElse(-1);
        long count = Arrays.stream(dis).filter(i -> i == max).count();
        System.out.println(count);
    }


    public int solution2(int n, int[][] vertex) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : vertex) {
            //양방향을 지원해준다.
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        distances[1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int currentDistance = distances[current];

            for (int neighbor : graph.get(current)) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = currentDistance + 1;
                    queue.offer(neighbor);
                }
            }
        }

        int maxDistance = Arrays.stream(distances).max().orElse(-1);
        long count = Arrays.stream(distances).filter(d -> d == maxDistance).count();

        return (int) count;
    }

}
