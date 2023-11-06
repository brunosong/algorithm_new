package com.brunosong.algorithm_new.프로그래머스LV0;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 문자열밀기 {

    @Test
    void test() {
       String A = "hello";
       String B = "ohell";

       solution(A,B);
    }


    public int solution(String A, String B) {
        return (B + B).indexOf(A);
    }

}
