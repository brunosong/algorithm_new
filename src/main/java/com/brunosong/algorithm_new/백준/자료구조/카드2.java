package com.brunosong.algorithm_new.백준.자료구조;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 카드2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        boolean flag = true;
        while (queue.size() > 1) {
            if (flag) {
                queue.poll();
                flag = false;
            } else {
                queue.offer(queue.poll());
                flag = true;
            }
        }

        System.out.println(queue.peek());
    }
}
