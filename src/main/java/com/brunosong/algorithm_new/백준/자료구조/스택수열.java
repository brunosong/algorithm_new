package com.brunosong.algorithm_new.백준.자료구조;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 스택수열 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sequence = new int[n];

        for (int i = 0; i < n; i++) {
            sequence[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int current = 1;
        boolean possible = true;

        for (int num : sequence) {
            while (num >= current) {
                stack.push(current);
                sb.append("+\n");
                current++;
            }

            if (num == stack.peek()) {
                stack.pop();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }

        }

        if (possible) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }




    }
}
