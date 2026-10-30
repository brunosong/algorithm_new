package com.brunosong.algorithm_new.SORTING;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class 최소회의실개수 {

    @Test
    void test() {
        int[][] meeting = {{0, 10}, {12, 25}, {5, 15}, {2, 5}};

        Assertions.assertEquals(2, solution(meeting));
    }

    int solution(int[][] meeting) {
        int answer = 0;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < meeting.length; i++) {
            list.add(new int[]{meeting[i][0],1});
            list.add(new int[]{meeting[i][1],2});
        }

        list.sort((a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[1] == 1) {
                cnt++;
            } else {
                cnt--;
            }
            answer = Math.max(cnt, answer);
        }

        return answer;
    }
}
