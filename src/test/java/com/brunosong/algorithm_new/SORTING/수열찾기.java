package com.brunosong.algorithm_new.SORTING;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 수열찾기 {

    @Test
    void test() {
        Assertions.assertThat(solution(new int[]{1, 10, 2, 3, 5, 6})).isEqualTo(new int[]{1, 3, 5});
        Assertions.assertThat(solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})).isEqualTo(new int[]{1, 1, 3, 7});
        Assertions.assertThat(solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})).isEqualTo(new int[]{2, 3, 5, 5, 7, 7});
    }

    int[] solution(int[] nums) {
        //int[] answer = {};

        LinkedList<Integer> list = Arrays.stream(nums).boxed()
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));

        List<Integer> answer = new ArrayList<>();

        while (!list.isEmpty()) {
            Integer num = list.peekFirst();
            int idx =  list.indexOf(num * 2);
            if (idx != -1) list.remove(idx);
            answer.add(list.pollFirst());
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

}
