package com.brunosong.algorithm_new.자료구조;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class 겹쳐진압축해제2 {

    @Test
    void test() {

        Assertions.assertThat(solution("3(a2(b))ef")).isEqualTo("abbabbabbef");
        Assertions.assertThat(solution("2(ab)k3(bc)")).isEqualTo("ababkbcbcbc");
        Assertions.assertThat(solution("2(ab3(((cd))))")).isEqualTo("abcdcdcdabcdcdcd");
        Assertions.assertThat(solution("2(2(ab)3(2(ac)))")).isEqualTo("ababacacacacacacababacacacacacac");
        Assertions.assertThat(solution("3(ab2(sg))")).isEqualTo("absgsgabsgsgabsgsg");

    }

    public String solution(String s) {
        String answer = "";

        Stack<String> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ')') {
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty() && stack.peek().charAt(0) != '(') {
                    temp.append(stack.pop());
                }
//                StringBuilder reverse = temp.reverse();
                stack.pop();

                StringBuilder result = new StringBuilder();
                if (Character.isDigit(stack.peek().charAt(0))) {
                    String pop = stack.pop();
                    int numericValue = Character.getNumericValue(pop.charAt(0));
                    for (int j = 0; j < numericValue; j++) {
                        result.append(temp);
                    }
                } else {
                    result.append(temp);
                }

                stack.push(result.toString());
            } else {
                stack.push(String.valueOf(charArray[i]));
            }
        }

        StringBuilder n = new StringBuilder();
        while (!stack.isEmpty()) {
            n.append(stack.pop());
        }

        return n.reverse().toString();
    }
}
