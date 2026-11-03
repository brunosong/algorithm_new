package com.brunosong.algorithm_new.출제;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 등수매기기 {

    @Test
    void test() {
        System.out.println(Arrays.toString(solution(new int[]{2, 2, 1})) + " (기대값: [1, 1, 3])");
        System.out.println(Arrays.toString(solution(new int[]{3, 2, 1, 2})) + " (기대값: [1, 2, 4, 2])");
    }

    public int[] solution(int[] grade) {


        int[] temp = grade.clone();
        Arrays.sort(temp);

        int n = temp.length;

        Map<Integer, Integer> rankMap = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!rankMap.containsKey(temp[i])) {
                rankMap.put(temp[i], n - i);
            }
        }

        int[] answer = new int[n];
        for (int i = 0; i < grade.length; i++) {
            answer[i] = rankMap.get(grade[i]);
        }

        return answer;
    }
}
