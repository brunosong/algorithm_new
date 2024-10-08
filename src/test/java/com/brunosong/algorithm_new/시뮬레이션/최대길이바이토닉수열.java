package com.brunosong.algorithm_new.시뮬레이션;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 최대길이바이토닉수열 {
    @Test
    void test() {
        //가장 긴 바이토닉 수열 찾기 ( 2, 5, 7, 4, 2 )
        Assertions.assertThat(solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1})).isEqualTo(5);
        Assertions.assertThat(solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2})).isEqualTo(8);
        Assertions.assertThat(solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1})).isEqualTo(6);
        Assertions.assertThat(solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1})).isEqualTo(5);

    }

    public int solution(int[] ints) {
        int answer = 0;

        for (int i = 0; i < ints.length; i++) {
            int cnt = 1;
            int current = ints[i];

            int lt = i-1;
            while (lt >= 0 && ints[lt] < current) {
                current = ints[lt];
                cnt++;
                lt--;
            }

            current = ints[i];
            int rt = i+1;
            while (rt < ints.length && ints[rt] < current) {
                current = ints[rt];
                cnt++;
                rt++;
            }

            answer = Math.max(cnt,answer);
        }

        return answer;
    }
}
