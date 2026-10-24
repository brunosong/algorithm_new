package com.brunosong.algorithm_new.시뮬레이션;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 최대길이바이토닉수열2 {

    @Test
    void tset(){
        Assertions.assertThat(solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1})).isEqualTo(5);
        Assertions.assertThat(solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2})).isEqualTo(8);
        Assertions.assertThat(solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1})).isEqualTo(6);
        Assertions.assertThat(solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1})).isEqualTo(5);
    }

    public int solution(int[] ints) {
        int answer = 0;

        // 봉우리 인덱스 찾기
        List<Integer> peekIndies = new ArrayList<>();
        for (int i = 1; i < ints.length - 1; i++) {
            if (ints[i-1] < ints[i] && ints[i+1] < ints[i]) {
                peekIndies.add(i);
            }
        }

        for (Integer currentIndex : peekIndies) {
            int left = currentIndex;
            int right = currentIndex;

            // 현재 포인트도 카운트에 포함을 해야 하기 때문에 1부터시작
            int cnt = 1;

            // 왼쪽부터
            while (left-1 >= 0 && ints[left] > ints[left - 1]) {
                left--;
                cnt++;
            }

            // 오른쪽
            while (right < ints.length-1 && ints[right] > ints[right+1]) {
                right++;
                cnt++;
            }

            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}
