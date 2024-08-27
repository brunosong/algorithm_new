package com.brunosong.algorithm_new.백준.자료구조;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 괄호 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            arr[i] = s;
        }

        for (String s  : arr) {
            System.out.println(solution(s));
        }
    }


    public static String solution(String str) {
        String answer = "NO";

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return "NO";
                }
            }
        }

        if(stack.isEmpty()) answer = "YES";

        return answer;
    }
}
