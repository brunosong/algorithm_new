package com.brunosong.algorithm_new.프로그래머스LV0;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 문자열정렬하기 {

    @Test
    void 문자열정렬하기(){

       String my_string	= "Bcad";
       //result "abcd"
       solution(my_string);

    }

    public String solution(String my_string) {
        String answer = "";

        String str = my_string.toLowerCase();

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        str = new String(chars);

        System.out.println(str);


        return answer;
    }
}
