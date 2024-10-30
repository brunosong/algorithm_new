package com.brunosong.algorithm_new.백준.그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

public class DFS와BFS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strNums = br.readLine().split(" ");

        int[] nums = Stream.of(strNums)
                .mapToInt(Integer::parseInt).toArray();

        int n = nums[0];
        int m = nums[1];
        int v = nums[2];

        Map<Integer,List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int left_num = Integer.parseInt(line[0]);
            int right_num = Integer.parseInt(line[1]);

            List<Integer> left = graph.getOrDefault(left_num, new ArrayList<>());
            left.add(right_num);
            graph.put(left_num, left);

            List<Integer> right = graph.getOrDefault(right_num, new ArrayList<>());
            right.add(left_num);
            graph.put(right_num, right);

        }

        int[] dis = new int[1001];
        StringBuilder sb = new StringBuilder();
        sb.append(v).append(" ");
        dis[v] = 1;
        if (graph.get(v) != null) {
            DFS(v, graph, dis, sb);
        }

        int[] dis2 = new int[1001];
        StringBuilder bfsStr = new StringBuilder();
        BFS(graph,v,bfsStr,dis2);

        System.out.println(sb.toString());
        System.out.println(bfsStr.toString());
    }

    public static void DFS(int currentNode, Map<Integer, List<Integer>> graph, int[] dis, StringBuilder sb) {

        List<Integer> nodes = graph.get(currentNode);
        Collections.sort(nodes);

        for (int node : nodes) {
            if (dis[node] == 0) {
                dis[node] = 1;
                sb.append(node).append(" ");
                DFS(node, graph, dis, sb);
            }
        }
    }

    public static void BFS(Map<Integer, List<Integer>> graph, int v, StringBuilder sb, int[] dis) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        dis[v] = 1;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            sb.append(poll).append(" ");

            List<Integer> nodes = graph.get(poll);
            if (nodes != null) {
                Collections.sort(nodes);

                for (int num : nodes) {
                    if (dis[num] == 0) {
                        dis[num] = 1;
                        queue.add(num);
                    }
                }
            }
        }
    }
}