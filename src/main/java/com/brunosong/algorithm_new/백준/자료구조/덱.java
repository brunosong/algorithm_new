package com.brunosong.algorithm_new.백준.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        CustomDeck customDeck = new CustomDeck();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "push_back" :
                    customDeck.pushBack(Integer.parseInt(command[1]));
                    break;
                case "push_front" :
                    customDeck.pushFront(Integer.parseInt(command[1]));
                    break;
                case "pop_front" :
                    sb.append(customDeck.popFront()).append("\n");
                    break;
                case "pop_back" :
                    sb.append(customDeck.popBack()).append("\n");
                    break;
                case "front" :
                    sb.append(customDeck.front()).append("\n");
                    break;
                case "back" :
                    sb.append(customDeck.back()).append("\n");
                    break;
                case "empty" :
                    sb.append(customDeck.empty()).append("\n");
                    break;
                case "size" :
                    sb.append(customDeck.size()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }

    public static class CustomDeck {

        Deque<Integer> deque;

        public CustomDeck() {
             deque = new LinkedList<>();
        }

        public void pushFront(int val) {
            deque.addFirst(val);
            // push_front X: 정수 X를 덱의 앞에 넣는다.
        }

        public void pushBack(int val) {
            deque.addLast(val);
            // push_back X: 정수 X를 덱의 뒤에 넣는다.
        }

        public int popFront() {
            // pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
            if (deque.isEmpty()) {
                return -1;
            }
            return deque.pollFirst();
        }

        public int popBack() {
            if (deque.isEmpty()) {
                return -1;
            }
            return deque.pollLast();
            // pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        }

        public int size() {
            return deque.size();
            // size: 덱에 들어있는 정수의 개수를 출력한다.
        }

        public int empty() {
            if (deque.isEmpty()) {
                return 1;
            }
            return 0;
            //empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
        }

        public int front() {
            if (deque.isEmpty()) {
                return -1;
            }
            return deque.peekFirst();

            //front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        }

        public int back() {
            if (deque.isEmpty()) {
                return -1;
            }
            return deque.peekLast();
            //: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        }

    }
}
