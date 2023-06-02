package com.brunosong.algorithm_new.재귀;

import java.util.*;

public class 그래프최단거리 {


    /*
        그래프 최단거리(BFS)
        다음 그래프에서 1번 정점에서 각 정점으로 가는 최소 이동 간선수를 출력하세요.
        1 <-  2 - > 5

        3 ->  4  -> 6      1 -> 4 ,

        ▣ 입력설명
        첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.

        ▣ 출력설명
        1번 정점에서 각 정점으로 가는 최소 간선수를 2번 정점부터 차례대로 출력하세요.

        ▣ 입력예제 1
        6 9
        1 3
        1 4
        2 1
        2 5
        3 4
        4 5
        4 6
        6 2
        6 5

        ▣ 출력예제 1
        2 : 3
        3 : 1
        4 : 1
        5 : 2
        6 : 2

    */

    static int[][] arr = {
            {1, 3},
            {1, 4},
            {2, 1},
            {2, 5},
            {3, 4},
            {4, 5},
            {4, 6},
            {6, 2},
            {6, 5},
    };

    //갈수 있는 경로를 담아두기 위함
    static List<List<Integer>> graph = new ArrayList<>();

    static int node = 6;
    static int[] ch = new int[node + 1];

    static int[] total = new int[node + 1];

    static int[] dis = new int[node + 1];

    public static void main(String[] args) {

        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] a : arr) {
            graph.get(a[0]).add(a[1]);
        }

        BFS();

        System.out.println(Arrays.toString(total));
    }

    /* 그래프 최단거리(BFS) : 레벨로 처리 */
    static void BFS() {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        int lv = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Integer poll = queue.poll();

                for ( int num : graph.get(poll) ) {

                    int now = total[num];
                    if(now == 0 && num != 1) {
                        total[num] = lv;
                        queue.offer(num);
                    }

                }
            }

            lv++;
        }


    }


    /* 그래프 최단거리(BFS) : 배열로 처리 */
    static void BFS2(int v) {

        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);

        while (!queue.isEmpty()) {
            int cv = queue.poll();

            for ( int nv : graph.get(cv) ) {

                if(ch[nv] == 0) {   //지나왔냐 안지나왔냐를 확인하는것
                    ch[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[cv] + 1;
                }

            }

        }


    }

}
