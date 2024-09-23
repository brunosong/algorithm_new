package com.brunosong.algorithm_new.백준.스텍큐덱;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class 큐2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        CustomQueue queue = new CustomQueue();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] tmp = str.split(" ");

            switch (tmp[0]) {
                case "push" :
                    queue.push(Integer.parseInt(tmp[1]));
                    break;
                case "pop" :
                    sb.append(queue.pop()).append("\n");
                    break;
                case "size" :
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty" :
                    sb.append(queue.empty()).append("\n");
                    break;
                case "front" :
                    sb.append(queue.front()).append("\n");
                    break;
                case "back" :
                    sb.append(queue.back()).append("\n");
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static class CustomQueue {

        Deque<Integer> queue;

        public CustomQueue() {
            this.queue = new LinkedList<>();
        }

        public void push(int value) {
            queue.add(value);
        }

        public int pop() {
            if (queue.isEmpty()) return -1;
            return queue.poll();
        }

        public int size() {
            return queue.size();
        }

        public int empty() {
            if (queue.isEmpty()) return 1;
            return 0;
        }

        public int front() {
            if (queue.isEmpty()) return -1;
            return queue.peek();
        }

        public int back() {
            if (queue.isEmpty()) return -1;
            return queue.peekLast();
        }

    }

}
