package com.brunosong.algorithm_new.프로그래머스LV0;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 컨트롤제트 {

    @Test
    void test(){
        String s =  "10 20 30 40";
        System.out.println(solution(s));
    }


    public int solution(String s) {
        int answer = 0;

        String[] strs = s.split(" ");

        for (int i = 0; i < strs.length; i++) {
            if(strs[i].equals("Z")) {
               answer += Integer.parseInt(strs[i-1]);
            }
        }

        int sum = Arrays.stream(strs)
                .filter(v -> v.matches("[-+]?\\d*\\.?\\d+"))
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.println("10".matches("\\D"));

        System.out.println(sum);


        return sum - answer;
    }



}
