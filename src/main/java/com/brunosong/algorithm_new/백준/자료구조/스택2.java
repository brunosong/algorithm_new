package com.brunosong.algorithm_new.백준.자료구조;

import java.util.Scanner;
import java.util.Stack;

public class 스택2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        CustomStack stack = new CustomStack();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String tmp = sc.nextLine();
            String[] strings = tmp.split(" ");

            int num = Integer.parseInt(strings[0]);

            switch (num) {
                case 1 :
                    stack.one(Integer.parseInt(strings[1]));
                    break;
                case 2 :
                    sb.append(stack.two()).append("\n");
                    break;
                case 3 :
                    sb.append(stack.three()).append("\n");
                    break;
                case 4 :
                    sb.append(stack.four()).append("\n");
                    break;
                case 5 :
                    sb.append(stack.five()).append("\n");
                    break;
            }
        }

        System.out.println(sb);

    }


    public static class CustomStack {

        private Stack<Integer> stack;

        public CustomStack() {
            this.stack = new Stack<>();
        }

        public void one(Integer value) {
            stack.push(value);
        }

        public int two() {
            if (!stack.isEmpty()) {
                return stack.pop();
            }
            return -1;
        }

        public int three() {
            return stack.size();
        }

        public int four() {
            if (stack.isEmpty()) {
                return 1;
            } else {
                return 0;
            }
        }

        public int five() {
            if (!stack.isEmpty()) {
                return stack.peek();
            }
            return -1;
        }

    }
}
