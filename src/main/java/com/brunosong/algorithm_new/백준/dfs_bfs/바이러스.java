package com.brunosong.algorithm_new.백준.dfs_bfs;

import java.util.*;

public class 바이러스 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nodeCnt = Integer.parseInt(sc.nextLine());
        int connectionCnt = Integer.parseInt(sc.nextLine());

        Map<Integer,List<Integer>> map = new HashMap();

        for (int i = 0; i < connectionCnt; i++) {
            String str = sc.nextLine();
            String[] s = str.split(" ");

            int node = Integer.parseInt(s[0]);
            int targetNode = Integer.parseInt(s[1]);

            List<Integer> connectPoints1 = map.getOrDefault(node, new ArrayList<>());
            connectPoints1.add(targetNode);
            map.put(node, connectPoints1);

            List<Integer> connectPoints2 = map.getOrDefault(targetNode, new ArrayList<>());
            connectPoints2.add(node);
            map.put(targetNode, connectPoints2);
        }

        int answer = 0;
        int[] dis = new int[nodeCnt + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dis[1] = 1;

        while (!queue.isEmpty() && map.containsKey(1)) {

            Integer current = queue.poll();

            for (Integer node : map.get(current)) {
                if (dis[node] == 0) {
                    dis[node] = 1;
                    answer++;
                    queue.add(node);
                }
            }
        }

        System.out.println(answer);

    }
}
