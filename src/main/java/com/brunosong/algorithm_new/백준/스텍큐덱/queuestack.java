package com.brunosong.algorithm_new.백준.스텍큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class queuestack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (A[i].equals("0")) {
                deque.addLast(Integer.parseInt(B[i]));
            }
        }

        int size = Integer.parseInt(br.readLine());
        String[] values = br.readLine().split(" ");

        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < size; x++) {
            int value = Integer.parseInt(values[x]);
            deque.addFirst(value);
            value = deque.pollLast();

            sb.append(value).append(" ");
        }

        System.out.println(sb);
    }

}
