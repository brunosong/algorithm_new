package com.brunosong.algorithm_new.백준.자료구조;

import java.util.Scanner;
import java.util.Stack;

public class 스택 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            arr[i] = s;
        }

        CustomStackStructure<Integer> stackStructure = new CustomStackStructure<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (String s  : arr) {
            switch (s.split(" ")[0]) {
                case "push" :
                    stackStructure.push(Integer.parseInt(s.split(" ")[1]));
                    break;
                case "pop" :
                    stringBuilder.append(stackStructure.pop());
                    break;
                case "size" :
                    stringBuilder.append(stackStructure.size());
                    break;
                case "empty" :
                    stringBuilder.append(stackStructure.empty());
                    break;
                case "top" :
                    stringBuilder.append(stackStructure.top());
                    break;
            }

            if(!s.startsWith("push")) stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);

    }

    public static class CustomStackStructure<E extends Number> {

        private Stack<E> stack = new Stack<>();

        public void push(E e) {
            stack.push(e);
        }

        public int top() {
            if(stack.isEmpty()) {
                return -1;
            } else {
                return stack.peek().intValue();
            }
        }

        public int size() {
            return stack.size();
        }

        public int pop() {
            if(stack.isEmpty()) {
                return -1;
            } else {
                return stack.pop().intValue();
            }
        }

        public int empty(){
            if(stack.isEmpty()) {
                return 1;
            } else {
                return 0;
            }
        }
    }

}
