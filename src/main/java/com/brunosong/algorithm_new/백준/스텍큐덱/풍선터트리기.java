package com.brunosong.algorithm_new.백준.스텍큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 풍선터트리기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] array = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).toArray(Integer[]::new);

        StringBuilder sb = new StringBuilder();

        Deque<int[]> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(new int[]{i,array[i-1]});
        }

        while (!deque.isEmpty()) {
            int[] start = deque.pollFirst();
            sb.append(start[0]).append(" ");
            if (!deque.isEmpty()) {
                if (start[1] > 0) {
                    for (int j = 0; j < start[1]-1; j++) {
                        deque.addLast(deque.pollFirst());
                    }
                } else {
                    int abs = Math.abs(start[1]);
                    for (int j = 0; j < abs; j++) {
                        deque.addFirst(deque.pollLast());
                    }
                }
            }
        }

        System.out.println(sb);
    }
}
