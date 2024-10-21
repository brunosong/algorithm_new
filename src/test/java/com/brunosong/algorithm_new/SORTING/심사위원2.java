package com.brunosong.algorithm_new.SORTING;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 심사위원2 {

    @Test
    void test() {

        int k = 3;
        int[] score = {99, 97, 80, 91, 85, 95, 92};
        Assertions.assertThat(solution(k,score)).isEqualTo(89);

        k = 4;
        score = new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92};
        Assertions.assertThat(solution(k,score)).isEqualTo(88);

        k = 5;
        score = new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89};
        Assertions.assertThat(solution(k,score)).isEqualTo(92);
    }

    int solution(int k,int[] score) {
        int answer = Integer.MAX_VALUE;

        Arrays.sort(score);

        int p1 = 0;
        int p2 = k-1;
        int sum = 0;

        for (; p2 < score.length; p2++) {
            if (10 < score[p2] - score[p1]) {
                p1++;
            } else {
                sum = score[p1] + score[p2];
                for (int i = p1 + 1; i <= p2-1; i++) {
                    sum += score[i];
                }
                answer = Math.min(sum / k, answer);
            }
        }

        System.out.println(answer);

        return answer;
    }
}
