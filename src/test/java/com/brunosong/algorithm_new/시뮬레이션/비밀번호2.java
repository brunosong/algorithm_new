package com.brunosong.algorithm_new.시뮬레이션;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class 비밀번호2 {


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

        // 키패드 맵을 만들어야 함
        Map<Integer, Integer[]> keypadMap = new HashMap<>();
        for (int i = 0; i < keypad.length; i++) {
            // 포지션을 넣어줘야 함
            keypadMap.put(keypad[i], new Integer[]{i/3,i%3});
        }

        int startNum = Character.getNumericValue(password.charAt(0));

        int beforeRow = keypadMap.get(startNum)[0];
        int beforeCol = keypadMap.get(startNum)[1];

        for (char key : password.toCharArray()) {
            int keyNum = Character.getNumericValue(key);
            Integer[] point = keypadMap.get(keyNum);

            int currentRow = point[0];
            int currentCol = point[1];

            int max = Math.max(Math.abs(beforeRow-currentRow),Math.abs(beforeCol-currentCol));
            answer += max;

            beforeRow = currentRow;
            beforeCol = currentCol;
        }

        return answer;
    }

}
