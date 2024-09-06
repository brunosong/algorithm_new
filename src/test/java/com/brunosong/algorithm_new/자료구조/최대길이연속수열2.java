package com.brunosong.algorithm_new.자료구조;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class 최대길이연속수열2 {

    @Test
    void test() {
        Assertions.assertThat(solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3})).isEqualTo(5);
        Assertions.assertThat(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0})).isEqualTo(10);
        Assertions.assertThat(solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3})).isEqualTo(1);
        Assertions.assertThat(solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1})).isEqualTo(7);
        Assertions.assertThat(solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7})).isEqualTo(3);
    }

    int solution(int[] arr) {
        int answer = Integer.MIN_VALUE;

        HashSet<Integer> set = new HashSet<>();
        for (int a : arr) set.add(a);

        for (int x : set) {
            if (set.contains(x-1)) continue;
            int cnt = 0;
            while (set.contains(x)) {
                cnt++;
                x++;
            }
            answer = Math.max(cnt,answer);
        }
        return answer;
    }




}
