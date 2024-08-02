package com.brunosong.algorithm_new.그리디;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 이동횟수 {

    @Test
    void test() {
        Assertions.assertThat(solution(new int[]{2, 5, 3, 4, 2, 3})).isEqualTo(4);
        Assertions.assertThat(solution(new int[]{2, 3, 4, 5})).isEqualTo(3);
        Assertions.assertThat(solution(new int[]{3, 3, 3, 3, 3})).isEqualTo(5);
    }

    public int solution(int[] nums) {
        int answer = 0;

        Arrays.sort(nums);

        int left = 0, right = nums.length-1;
        while (left <= right) {

            if(nums[left] + nums[right] <= 5) {
                answer++;
                left++;
                right--;
            } else {
                answer++;
                right--;
            }
        }

        return answer;
    }
}
