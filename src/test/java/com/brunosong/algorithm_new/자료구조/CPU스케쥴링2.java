package com.brunosong.algorithm_new.자료구조;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class CPU스케쥴링2 {

    @Test
    void test(){

        int[][] tasks = {
                {2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}
//                {5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}
                //{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}
        };

        solution(tasks);
    }

    public int[] solution(int[][] tasks) {

        int[] answer = new int[tasks.length];

        LinkedList<int[]> programs = new LinkedList<>();
        for (int i = 0; i < tasks.length; i++) {
            programs.add(new int[]{tasks[i][0],tasks[i][1],i});
        }
        Collections.sort(programs, (a,b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // 넣는 조건
        int finishTime = 0;
        int idx = 0;
        while (!programs.isEmpty() || !pq.isEmpty()) {

            if (pq.isEmpty() && finishTime < programs.peek()[0]) {
                finishTime = Math.max(programs.peek()[0], finishTime);
            }

            while (!programs.isEmpty() && programs.peek()[0] >= finishTime) {
                int[] first = programs.pollFirst();
                pq.offer(new int[]{first[1],first[2]});
            }

            int[] current = pq.poll();
            finishTime = finishTime + current[0];
            answer[idx++] = current[1];
        }


        return new int[]{};
    }
}
