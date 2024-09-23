package com.brunosong.algorithm_new.백준.스텍큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class 요세푸스문제0 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nums = br.readLine().split(" ");
        int N = Integer.parseInt(nums[0]);
        int target = Integer.parseInt(nums[1]);

        Deque<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) queue.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int cnt = 1;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (cnt == target) {
                if (queue.size() == 0) {
                    sb.append(poll);
                } else {
                    sb.append(poll).append(", ");
                }
                cnt = 0;
            } else {
                queue.add(poll);
            }
            cnt++;
        }

        sb.append(">");
        System.out.println(sb);

    }
}
