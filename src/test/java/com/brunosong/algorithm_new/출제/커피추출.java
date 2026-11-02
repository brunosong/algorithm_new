package com.brunosong.algorithm_new.출제;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 커피추출 {


    @Test
    void test() {
        //System.out.println(Arrays.toString(solution(3, new int[]{4, 2, 2, 5, 3})) + " (기대값: [2, 3, 1, 5, 4])");
        System.out.println(Arrays.toString(solution(1, new int[]{100, 1, 50, 1, 1})) + " (기대값: [1, 2, 3, 4, 5])");
    }

    public int[] solution(int N, int[] coffee_times) {
        int m = coffee_times.length;
        int[] answer = new int[m];

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> {
           if (a[0] != b[0]) {
               return Long.compare(a[0],b[0]);
           }
           return Long.compare(a[1],b[1]);
        });

        // 1. 처음에는 추출구 N개에 앞에서 부터 주문을 넣는다. (시작시간 0)
        int next = 0;
        while (next < m && next < N) {
            pq.add(new long[]{coffee_times[next], next + 1});
            next++;
        }

        // 2. 가장 먼저 끝나는 커피를 꺼내고, 비는 추출구에 다음 주문을 넣는다.
        int idx = 0;
        while (!pq.isEmpty()) {
            long[] done = pq.poll();
            long endTime = done[0];
            answer[idx] = (int)done[1];
            idx++;

            if (next < m) {
                // 방금 끝난 시간부터 다음 주문을 만들기 시작
                pq.add(new long[]{endTime + coffee_times[next], next + 1});
                next++;
            }

        }

        return answer;
    }


}
