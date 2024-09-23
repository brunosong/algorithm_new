package com.brunosong.algorithm_new.백준.스텍큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 덱2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        CustomDeque deque = new CustomDeque();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] tmp = str.split(" ");

            switch (tmp[0]) {
                case "1" :
                    deque.addFirst(Integer.parseInt(tmp[1]));
                    break;
                case "2" :
                    deque.addLast(Integer.parseInt(tmp[1]));
                    break;
                case "3" :
                    sb.append(deque.pollFirst()).append("\n");
                    break;
                case "4" :
                    sb.append(deque.poolLast()).append("\n");
                    break;
                case "5" :
                    sb.append(deque.size()).append("\n");
                    break;
                case "6" :
                    sb.append(deque.empty()).append("\n");
                    break;
                case "7" :
                    sb.append(deque.peekFirst()).append("\n");
                    break;
                case "8" :
                    sb.append(deque.peekLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    public static class CustomDeque {

        Deque<Integer> deque;

        public CustomDeque() {
            this.deque = new LinkedList<>();
        }

        public void addFirst(int value) {
            deque.addFirst(value);
        }

        public void addLast(int value) {
            deque.addLast(value);
        }

        public int pollFirst() {
            if (deque.isEmpty()) return -1;
            return deque.pollFirst();
        }

        public int poolLast() {
            if (deque.isEmpty()) return -1;
            return deque.pollLast();
        }

        public int size() {
            return deque.size();
        }

        public int empty() {
            if (deque.isEmpty()) return 1;
            return 0;
        }

        public int peekFirst() {
            if (deque.isEmpty()) return -1;
            return deque.peekFirst();
        }

        public int peekLast() {
            if (deque.isEmpty()) return -1;
            return deque.peekLast();
        }
    }

}
