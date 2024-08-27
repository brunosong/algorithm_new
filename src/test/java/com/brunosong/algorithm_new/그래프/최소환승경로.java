package com.brunosong.algorithm_new.그래프;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class 최소환승경로 {

    @Test
    void test() {
        int[][] routes = {
                        {1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10},
                        {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}
        };

        Assertions.assertThat(solution(routes,1,12)).isEqualTo(2);

        routes = new int[][]{
                {1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14,15}, {2, 14, 16}
        };

        Assertions.assertThat(solution(routes,1,15)).isEqualTo(2);
        
    }


    public int solution(int[][] routes, int s, int e) {
        int answer = -1;

        Map<Integer, Set<Integer>> subway = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                Set<Integer> lineNumber = subway.getOrDefault(routes[i][j], new HashSet<>());
                lineNumber.add(i);
                subway.put(routes[i][j],lineNumber);
            }
        }

        int[] dis = new int[routes.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer currentNumber = queue.poll();

                //지하철이 몇개의 라인을 가지고 있는지 확인하고 현재의 라인에서 이동할 수 있는 라인을 가진 지하철 넘버를 찾는다.
                for(Integer line : subway.get(currentNumber)) {
                    if (dis[line] == 1) continue;
                    dis[line] = 1;

                    for (int num : routes[line]) {
                        if (e == num) return level;
                        queue.offer(num);
                    }
                    
                }
            }
            level++;
        }

        return answer;
    }



}
