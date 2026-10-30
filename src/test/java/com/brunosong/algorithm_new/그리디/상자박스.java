package com.brunosong.algorithm_new.그리디;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 상자박스 {

    @Test
    void test() {
        Assertions.assertEquals(3,solution(15));
    }

    int solution(int n) {
        int answer = 0;

        while (n >= 0) {
            if (n % 7 == 0) {
                return answer + n / 7;
            }
            n = n - 4;
            answer++;
        }

        return answer;
    }
}
