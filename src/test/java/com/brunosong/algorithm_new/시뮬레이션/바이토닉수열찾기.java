package com.brunosong.algorithm_new.시뮬레이션;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class 바이토닉수열찾기 {

    @Test
    void test() {

        //Assertions.assertThat(solution(new int[]{1, 2, 1, 2, 3, 2, 1})).isEqualTo()
        Assertions.assertThat(solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2})).isEqualTo(8);
        Assertions.assertThat(solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1})).isEqualTo(6);
        Assertions.assertThat(solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1})).isEqualTo(5);

    }

    public int solution(int[] arr) {

        List<Integer> peeks = new ArrayList<>();
        //1.봉우리 찾기
        for (int i = 1; i < arr.length - 1; i++) {
            if(arr[i-1] < arr[i] && arr[i+1] < arr[i]) {
                peeks.add(i);
            }
        }

        int max = Integer.MIN_VALUE;

        for (int x : peeks) {

            int left = x;
            int right = x;

            int cnt = 1;

            while (left-1 >= 0 && arr[left] > arr[left-1]) {
                cnt++;
                left--;
            }

            while (right+1 < arr.length && arr[right] > arr[right + 1]) {
                cnt++;
                right++;
            }

            max = Math.max(cnt,max);
        }

        return max;
    }
}
