package com.brunosong.algorithm_new.SORTING;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 로그구간합치기 {

    @Test
    void test() {
        int[][] intervals = {{8,10},{1,3},{15,18},{2,6},{9,12}};

        Assertions.assertArrayEquals(new int[][]{{1,6},{8,12},{15,18}}, solution(intervals));
    }

    int[][] solution(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] cur = intervals[0].clone();

        for (int i = 1; i < intervals.length; i++) {
            if (cur[1] >= intervals[i][0]) {
                cur[1] = Math.max(cur[1], intervals[i][1]);
            } else {
                merged.add(cur);
                cur = intervals[i].clone();
            }
        }

        merged.add(cur);

        return merged.toArray(new int[0][]);
    }

    
}
