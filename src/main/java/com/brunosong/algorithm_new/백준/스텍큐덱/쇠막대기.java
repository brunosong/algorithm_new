package com.brunosong.algorithm_new.백준.스텍큐덱;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();

        int pipe = 0;
        char before = ' ';
        for (char ch : chars) {
            if (ch == '(') {
                stack.push(ch);
                before = '(';
            } else {
                if (before != ')') {
                    stack.pop();
                    pipe += stack.size();
                    before = ')';
                } else {
                    stack.pop();
                    pipe += 1;
                }
            }

        }

        System.out.println(pipe);


    }
}
