package com.brunosong.algorithm_new.백준.자료구조;

import java.util.Scanner;
import java.util.Stack;

public class 균형잡힌_세상 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String str;
        while (!(str = sc.nextLine()).equals(".")) {

            if (isBalanced(str)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean isBalanced(String str) {

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            if (ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
