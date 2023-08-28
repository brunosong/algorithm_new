package com.brunosong.algorithm_new.temp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 배열테스트4 {

    @Test
    void test(){

        int[] num_list = {4, 2, 6, 1, 7, 6};
        int n = 2;

        solution(num_list,n);

        String str = "Programmers";
        solution(str);


    }

    public int[] solution(int[] num_list, int n) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();
        list.add(num_list[0]);

        for (int i = 1; i < num_list.length; i++) {
            if(i % n == 0) {
                list.add(num_list[i]);
            }
        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }


    public int[] solution(String my_string) {
        int[] answer = new int[52];

        char[] arr = my_string.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if(Character.isUpperCase(c)) {
                answer[(int)c - 65]++;
            } else {
                answer[(int)c - 97 + 26]++;
            }

        }
        System.out.println((int)'a');
        System.out.println((int)'z' - (int)'a');
        System.out.println(Arrays.toString(answer));

        return answer;
    }




}