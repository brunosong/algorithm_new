package com.brunosong.algorithm_new.재귀;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 경로탐색 {

    /*

    방향그래프가 주어지면 1번 정점에서 N번 정점으로 가는 모든 경로의 가지 수를 출력하는 프 로그램을 작성하세요. 아래 그래프에서 1번 정점에서 5번 정점으로 가는 가지 수는
    1 2 3 4 5
    1 2 5
    1 3 4 2 5
    1 3 4 5
    1 4 2 5
    1 4 5
    총 6 가지입니다.

    ▣ 입력설명
    첫째 줄에는 정점의 수 N(1<=N<=20)와 간선의 수 M가 주어진다. 그 다음부터 M줄에 걸쳐 연결정보가 주어진다.

    ▣ 출력설명
    총 가지수를 출력한다.

    ▣ 입력예제 1
    5 9
    1 2
    1 3
    1 4
    2 1
    2 3
    2 5
    3 4
    4 2
    4 5

    ▣ 출력예제 1
    6

     */

    //경로의 노드수
    static int node = 5;

    //경로를 지나왔는지 아닌지 체크하기 위함
    static int[] ch = new int[node + 1];

    //갈수 있는 경로를 담아두기 위함
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2},
                {1, 3},
                {1, 4},
                {2, 1},
                {2, 3},
                {2, 5},
                {3, 4},
                {4, 2},
                {4, 5},
        };

        for (int i = 0; i <= node; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] a : arr) {
            graph.get(a[0]).add(a[1]);
        }

        System.out.println(graph);

        ch[1] = 1;
        DFS(1);

    }


    /* 인접 행렬 */
    static void DFS(int lv) {

        if(lv == node) {

            System.out.println(Arrays.toString(ch));

        } else {

            List<Integer> list = graph.get(lv);

            for (int i = 0; i < list.size() ; i++) {

                Integer n = list.get(i);

                if(ch[n] == 0) {
                    ch[n] = 1;
                    DFS(n);
                    ch[n] = 0;
                }

            }
        }

    }

}
