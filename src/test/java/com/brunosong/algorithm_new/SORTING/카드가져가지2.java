package com.brunosong.algorithm_new.SORTING;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

public class 카드가져가지2 {
    @Test
    void test() {

        int k = 2;
        int[] nums = {7, 8, 5, 12, 3, 1, 3, 1, 1, 12};
        Assertions.assertThat(solution(k,nums)).isEqualTo(28);

        k = 2;
        nums = new int[]{8, 2, 12, 12, 12, 12, 2, 2};
        Assertions.assertThat(solution(k,nums)).isEqualTo(34);

        k = 3;
        nums = new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7};
        Assertions.assertThat(solution(k,nums)).isEqualTo(60);

        k = 3;
        nums = new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12};
        Assertions.assertThat(solution(k,nums)).isEqualTo(283);


    }

    public int solution(int k, int[] nums) {
        int answer = 0;

        Integer[] array = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(array, (a1,a2) -> a2 - a1);

        Integer[] distance = new Integer[nums.length / 2 ];
        int idx = 0;
        for (int i = 0; i < array.length; i+=2) {
            answer += array[i+1];
            distance[idx] = array[i] - array[i+1];
            idx++;
        }

        Arrays.sort(distance, (a1,a2) -> a2 - a1);

        for (int i = 0; i < k; i++) {
            answer += distance[i];
        }

        return answer;
    }
}
