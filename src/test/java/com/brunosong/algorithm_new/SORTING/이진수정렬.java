package com.brunosong.algorithm_new.SORTING;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class 이진수정렬 {

    @Test
    void test() {
        Assertions.assertThat(solution(new int[]{5, 6, 7, 8, 9})).isEqualTo(new int[]{8, 5, 6, 9, 7});
        Assertions.assertThat(solution(new int[]{5, 4, 3, 2, 1})).isEqualTo(new int[]{1, 2, 4, 3, 5});
        Assertions.assertThat(solution(new int[]{12, 5, 7, 23, 45, 21, 17})).isEqualTo(new int[]{5, 12, 17, 7, 21, 23, 45});
    }

    int[] solution(int[] nums) {
        int[] answer = new int[nums.length];

        PriorityQueue<int[]> queue = new PriorityQueue<>((a1, a2) -> a1[1] == a2[1] ? a1[0] - a2[0] : a1[1] - a2[1]);

        for (int x : nums) {
            queue.add(new int[]{x, Integer.toBinaryString(x).replace("0","").length()});
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            answer[idx++] = queue.poll()[0];
        }

        return answer;
    }


}
