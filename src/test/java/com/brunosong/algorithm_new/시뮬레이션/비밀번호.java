package com.brunosong.algorithm_new.시뮬레이션;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class 비밀번호 {

    @Test
    void test() {
        int[] keypad = {2, 5, 3, 7, 1, 6, 4, 9, 8};
        String answer = "7596218";
        Assertions.assertThat(solution(keypad, answer)).isEqualTo(8);
        Assertions.assertThat(solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592")).isEqualTo( 12);
        Assertions.assertThat(solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677")).isEqualTo( 13);
        Assertions.assertThat(solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122")).isEqualTo( 8);

    }

    int solution(int[] keypad, String password) {
        int answer = 0;

        Map<Integer, Integer[]> maps = new HashMap<>();

        int startNum = Character.getNumericValue(password.charAt(0));
        int beforeX = -1, beforeY = -1;

        for (int i = 0; i < keypad.length; i++) {
            if (startNum == keypad[i]) {
                beforeX = i / 3;
                beforeY = i % 3;
            }
            maps.put(keypad[i], new Integer[]{i / 3, i % 3});
        }

        for (char ch : password.toCharArray()) {
            int num = Character.getNumericValue(ch);
            Integer[] position = maps.get(num);
            int x = position[0];
            int y = position[1];

            answer += Math.max(Math.abs(beforeX - x), Math.abs(beforeY - y));
            beforeX = x;
            beforeY = y;
        }

        return answer;
    }
}
