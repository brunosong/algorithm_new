package com.brunosong.algorithm_new.프로그래머스;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합의개수 {

    @Test
    void test() {
        int[] elements = {7,9,1,1,4};
        solution(elements);
    }

    public int solution(int[] elements) {
        int answer = 0;
        
        int size = elements.length;

        int[] extendedElements = new int[size * 2];
        System.arraycopy(elements, 0, extendedElements, 0, size);
        System.arraycopy(elements, 0, extendedElements, size, size);

        Set<Integer> set = new HashSet<>();

        for (int cnt = 1; cnt <= size; cnt++) {
            for (int j = 0; j < size; j++) {
                int sum = 0;
                for (int k = j; k < j + cnt; k++) {
                    sum += extendedElements[k];
                }
                set.add(sum);
            }
        }

        return answer;
    }
}
