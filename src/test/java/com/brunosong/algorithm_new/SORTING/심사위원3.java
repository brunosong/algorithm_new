package com.brunosong.algorithm_new.SORTING;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 심사위원3 {


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
        int answer = 0;

        Arrays.sort(score);

        for (int i = 0; i < score.length - k; i++) {
            if (score[i+k-1] - score[i] <= 10) {
                return getAvg(i, i+k-1, score);
            }
        }

        return answer;
    }

    int getAvg(int i, int j, int[] score) {
        int sum = 0;
        int cnt = 0;
        for (int k = i; k <= j; k++) {
            sum += score[k];
            cnt++;
        }
        return sum / cnt;
    }
}
