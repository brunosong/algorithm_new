package com.brunosong.algorithm_new.프로그래머스LV1;

import java.util.*;

public class 명예의전당 {

    public static void main(String[] args) {

        int[] score = {10, 100, 20, 150, 1, 100, 200};
        int K = 8;

        System.out.println(Arrays.toString(solution(K,score)));

    }



    public static int[] solution(int k, int[] score) {

        int[] answer = new int[score.length];
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < k; i++) {
            if(i < score.length) {
                stack.push(score[i]);
                stack.sort(Comparator.reverseOrder());
                answer[i] = stack.peek();
            }

        }

        for (int i = k; i < score.length; i++) {

            Integer peek = stack.peek();

            if( peek < score[i] ) {
                stack.pop();
                stack.push(score[i]);
                stack.sort(Comparator.reverseOrder());
                peek = stack.peek();
            }

            answer[i] = peek;


        }

        return answer;
    }

}
