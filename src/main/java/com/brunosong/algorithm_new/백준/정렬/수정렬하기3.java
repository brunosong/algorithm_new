package com.brunosong.algorithm_new.백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10000+1];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int i1 = Integer.parseInt(br.readLine());
            arr[i1]++;
            max = Math.max(max,i1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= max; i++) {
            if (arr[i] > 0) {
                for (int j = 0; j < arr[i]; j++) {
                    sb.append(i).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}
