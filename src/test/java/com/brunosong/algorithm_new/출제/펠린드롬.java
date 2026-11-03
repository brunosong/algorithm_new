package com.brunosong.algorithm_new.출제;

import org.junit.jupiter.api.Test;

public class 펠린드롬 {

    @Test
    void test() {
        System.out.println(solution(1, 100) + " (기대값: 18)");
        System.out.println(solution(100, 300) + " (기대값: 20)");
    }

    public int solution(int n, int m) {
        int answer = 0;

        for (int i = n; i <= m; i++) {
            if (isPalindrome(i)) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isPalindrome(int n) {
        String s = String.valueOf(n);

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
