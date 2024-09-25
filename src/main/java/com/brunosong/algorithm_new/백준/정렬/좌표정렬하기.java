package com.brunosong.algorithm_new.백준.정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 좌표정렬하기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] nums = sc.nextLine().split(" ");
            list.add(new int[]{Integer.parseInt(nums[0]),Integer.parseInt(nums[1])});
        }

        Collections.sort(list, (a1,a2) -> a1[0] == a2[0] ? a1[1] - a2[1] : a1[0] - a2[0]);

        for (int[] x : list){
            System.out.println(x[0] + " " + x[1]);
        }
    }
}
