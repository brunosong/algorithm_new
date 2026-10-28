package com.brunosong.algorithm_new.SORTING;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 이진수정렬2 {

    @Test
    void test() {
        Assertions.assertThat(solution(new int[]{5, 6, 7, 8, 9})).isEqualTo(new int[]{8, 5, 6, 9, 7});
        Assertions.assertThat(solution(new int[]{5, 4, 3, 2, 1})).isEqualTo(new int[]{1, 2, 4, 3, 5});
        Assertions.assertThat(solution(new int[]{12, 5, 7, 23, 45, 21, 17})).isEqualTo(new int[]{5, 12, 17, 7, 21, 23, 45});
    }

    int[] solution(int[] nums) {

        int[] answer = new int[nums.length];

        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int cnt = 0;
            while (num > 0) {
                cnt += num % 2;
                num = num / 2;
            }

            temp.add(new int[]{nums[i], cnt});
        }

        Collections.sort(temp, (a1,a2) -> a1[1] == a2[1] ? a1[0] - a2[0] : a1[1] - a2[1]);

        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i)[0];
        }

        return answer;
    }
}
