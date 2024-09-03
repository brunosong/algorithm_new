package com.brunosong.algorithm_new.백준.자료구조;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class 제로 {
    public static void main(String[] args) {

//        4
//        3
//        0
//        4
//        0

        Scanner scanner = new Scanner(System.in);

        int K = scanner.nextInt();
        scanner.nextLine();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int n = scanner.nextInt();

            if (n == 0) {
                stack.pop();
            } else {
                stack.push(n);
            }
        }
        scanner.nextLine();

        System.out.println(stack.stream().mapToInt(Integer::intValue).sum());

    }
}
