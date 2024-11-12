package com.brunosong.algorithm_new.백준.자료구조;

import java.util.*;
import java.util.stream.Collectors;

public class 요세푸스문제 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] NK = s.split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        List<Integer> list = new ArrayList<>();

        int cnt = 1;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (cnt % K == 0) {
                list.add(poll);
            } else {
                queue.add(poll);
            }
            cnt++;
        }

        String collect = list.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        System.out.println("<" + collect + ">");

        sc.close();

    }
}
