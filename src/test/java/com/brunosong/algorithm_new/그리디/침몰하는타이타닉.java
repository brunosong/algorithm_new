package com.brunosong.algorithm_new.그리디;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 침몰하는타이타닉 {

    @Test
    void test() {
        Assertions.assertThat(solution(new int[]{90, 50, 70, 100, 60}, 140)).isEqualTo(3);
        Assertions.assertThat(solution(new int[]{86, 95, 107, 67, 38, 49, 116, 22, 78, 53}, 150)).isEqualTo(5);
        Assertions.assertThat(solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120)).isEqualTo(14);
    }

    public int solution(int[] nums, int m) {
        int answer = 0;

        Arrays.sort(nums);
        int lt = 0;
        int rt = nums.length-1;

        while (lt <= rt) {

            if(nums[lt] + nums[rt] <= m) {
                answer++;
                lt++;
                rt--;
            } else {
                answer++;
                rt--;
            }

        }

        return answer;
    }

}
