package com.brunosong.algorithm_new.백준.자료구조;

import java.util.ArrayDeque;
import java.util.Scanner;

public class 큐 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomQueue queue = new CustomQueue();

        int N  = sc.nextInt();
        sc.nextLine();

        String[] str = new String[N];
        for (int i = 0; i < N; i++) {
            str[i] = sc.nextLine();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            String action = str[i].split(" ")[0];

            switch (action) {
                case "push" :
                    queue.push(Integer.parseInt(str[i].split(" ")[1]));
                    break;
                case "front" :
                    sb.append(queue.front());
                    sb.append("\n");
                    break;
                case "back" :
                    sb.append(queue.back());
                    sb.append("\n");
                    break;
                case "size" :
                    sb.append(queue.size());
                    sb.append("\n");
                    break;
                case "pop" :
                    sb.append(queue.pop());
                    sb.append("\n");
                    break;
                case "empty" :
                    sb.append(queue.empty());
                    sb.append("\n");
                    break;
            }
        }

        System.out.println(sb);

    }

    public static class CustomQueue {

        private ArrayDeque<Integer> queue;

        public CustomQueue() {
             queue = new ArrayDeque<>();
        }

        public void push(Integer val) {
            queue.offer(val);
        }

        public int size() {
            return queue.size();
        }

        public int empty() {
            return queue.isEmpty() ? 1 : 0;
        }

        public int pop() {
            return queue.isEmpty() ? -1 : queue.poll();
        }

        public int front() {
            return queue.isEmpty() ? -1 : queue.peek();
        }

        public int back() {
            return queue.isEmpty() ? -1 : queue.peekLast();
        }
    }
}
