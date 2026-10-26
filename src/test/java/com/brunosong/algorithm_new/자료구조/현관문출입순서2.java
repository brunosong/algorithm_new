package com.brunosong.algorithm_new.자료구조;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 현관문출입순서2 {
    @Test
    void test() {

        int[] arrival = {0, 1, 1, 1, 2, 3, 8, 8};
        int[] state = {1, 0, 0, 1, 0, 0, 1, 0};
//        int[] arrival = {3, 3, 4, 5, 5, 5};
//        int[] state = {1, 0, 1, 0, 1, 0};

//        int[] arrival = {2, 2, 2, 3, 4, 8, 8, 9, 10,10};
//        int[] state = {1, 0, 0, 0, 1, 1, 0, 1, 1,0};


        System.out.println(Arrays.toString(solution(arrival,state)));

    }

    // 이 방식은 한번에 큐에 다 밀어넣고 처리를 하는 방법
    public int[] solution(int[] arrival, int[] state) {
        int[] answer = new int[arrival.length];

        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();

        int n = arrival.length;
        int prev = 1;

        int time = 0;
        int cnt = 0;
        int i = 0;
        while (cnt < n) {

            if (enter.isEmpty() && exit.isEmpty()) {
                if (time < arrival[i]) {
                    time = arrival[i];
                }
            }

            while (i < n && arrival[i] == time) {
                if (state[i] == 0) enter.offer(i);
                else {
                    exit.offer(i);
                }
                i++;
            }

            // 초당 한번이니깐
            if (prev == 1) {
                if (!exit.isEmpty()) {
                    Integer exitIndex = exit.poll();
                    answer[exitIndex] = time;
                } else {
                    if (!enter.isEmpty()) {
                        Integer enterIndex = enter.poll();
                        answer[enterIndex] = time;
                        prev = 0;
                    }
                }
            } else {
                if (!enter.isEmpty()) {
                    Integer enterIndex = enter.poll();
                    answer[enterIndex] = time;
                    prev = 0;
                } else {
                    if (!exit.isEmpty()) {
                        Integer exitIndex = exit.poll();
                        answer[exitIndex] = time;
                        prev = 1;
                    }
                }
            }

            time++;
            cnt++;
        }

        return answer;
    }
}
