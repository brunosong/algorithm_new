package com.brunosong.algorithm_new.백준.자료구조;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 최소힙 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        Queue<Integer> queue = new PriorityQueue<>((a1,a2) -> a1 - a2);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            sc.nextLine();

            if (x == 0) {
                if (!queue.isEmpty()) {
                    sb.append(queue.poll());
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            } else {
                queue.offer(x);
            }
        }

        System.out.println(sb);

    }
}
