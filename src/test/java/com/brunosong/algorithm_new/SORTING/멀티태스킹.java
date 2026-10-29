package com.brunosong.algorithm_new.SORTING;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 멀티태스킹 {

    @Test
    void test() {
        int[] arr = {8, 5, 2, 9, 10, 7};
        int k = 30;

        // answer
        Assertions.assertEquals(6, solution(arr, k));
    }

    int solution(int[] arr, int k) {
        int answer = -1;

        List<Integer> temp = new ArrayList<>();
        temp.add(0);

        for (int a : arr) {
            temp.add(a);
        }

        Collections.sort(temp);

        int rest = arr.length;
        int max = 0;
        for (int i = 1; i < temp.size(); i++) {
            int time = temp.get(i) - temp.get(i - 1);
            if (time * rest < k) {
                k = k - time * rest;
                rest--;
            } else {
                long idx = k % rest;
                int cnt = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] >= temp.get(i)) {
                        if (cnt == idx) {
                            return j + 1;
                        }
                        cnt++;
                    }
                }
            }
        }

        return answer;
    }


}
