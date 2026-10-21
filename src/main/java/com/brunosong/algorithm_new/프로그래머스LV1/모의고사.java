package com.brunosong.algorithm_new.프로그래머스LV1;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class 모의고사 {

    public static void main(String[] args) {

        모의고사 main = new 모의고사();
        main.solution(new int[]{1,2,3,4,5});
    }

    public int[] solution(int[] answers) {

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] countArr = new int[3];

        for (int i = 0; i < answers.length; i++) {

            if (arr1[i % arr1.length] == answers[i]) {
                countArr[0]++;
            }

            if (arr2[i % arr2.length] == answers[i]) {
                countArr[1]++;
            }

            if (arr3[i % arr3.length] == answers[i]) {
                countArr[2]++;
            }
        }

        int max = Arrays.stream(countArr).max().getAsInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < countArr.length; i++) {
            if (max == countArr[i]) {
                list.add(i + 1);
            }
        }

        return list.stream().mapToInt( i -> i).toArray();
    }
}
