package com.brunosong.algorithm_new.백준.정렬;

import java.util.*;
import java.util.stream.Stream;

public class 좌표압축 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        String numberStr = sc.nextLine();
        String[] nums = numberStr.split(" ");

        Integer[] array = Stream.of(nums)
                                .map(Integer::parseInt)
                                .sorted()
                                .toArray(Integer[]::new);

        Map<Integer,Integer> map = new HashMap<>();
        int rank = 0;
        for (Integer x : array) {
            if (!map.containsKey(x)) {
                map.put(x, rank);
                rank++;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            result.append(map.get(Integer.parseInt(nums[i]))).append(" ");
        }

        System.out.println(result);
    }
}
