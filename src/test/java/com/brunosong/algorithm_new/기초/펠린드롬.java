package com.brunosong.algorithm_new.기초;

import org.junit.jupiter.api.Test;

public class 펠린드롬 {

    @Test
    void test() {

    }

    boolean solution(String str) {
        boolean check = false;

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return check;
    }
}
