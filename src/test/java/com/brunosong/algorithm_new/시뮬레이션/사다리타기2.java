package com.brunosong.algorithm_new.시뮬레이션;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 사다리타기2 {

    @Test
    void test(){

        int n = 5;
        int[][] ladder = {{1, 3}, {2, 4}, {1, 4}};
        Assertions.assertThat(solution(n,ladder)).isEqualTo(new char[]{'D', 'B', 'A', 'C', 'E'});

        n = 7;
        ladder = new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}};
        Assertions.assertThat(solution(n,ladder)).isEqualTo(new char[]{'A', 'C', 'B', 'F', 'D', 'G', 'E'});

        n = 8;
        ladder = new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}};
        Assertions.assertThat(solution(n,ladder)).isEqualTo(new char[]{'C', 'A', 'B', 'F', 'D', 'E', 'H', 'G'});

        n = 12;
        ladder = new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11},{2, 5, 7, 10}, {3, 6, 8, 11}};
        Assertions.assertThat(solution(n,ladder)).isEqualTo(new char[]{'C', 'A', 'F', 'B', 'D', 'I', 'E', 'K', 'G', 'L', 'J', 'H'});


    }

    public char[] solution(int n, int[][] ladder) {
        char[] answer = new char[n];

        for (int i = 0; i < n; i++) {
            answer[i] = (char) (65 + i);
        }

        for (int[] nums : ladder) {
            for (int x : nums) {
                char tmp = answer[x-1];
                answer[x-1] = answer[x];
                answer[x] = tmp;
            }
        }

        System.out.println(Arrays.toString(answer));



        return answer;
    }


}
