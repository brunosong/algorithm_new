package com.brunosong.algorithm_new.백준.조합론;

import java.util.*;

public class 패션왕_신해빈_시간초과해결 {

    public static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            List<String[]> temp = new ArrayList<>();
            Map<String, Integer> checker = new HashMap<>();

            int clothesCnt = Integer.parseInt(sc.nextLine());

            for (int j = 0; j < clothesCnt; j++) {
                String[] clothes = sc.nextLine().split(" ");
                temp.add(new String[]{clothes[0], clothes[1]});
                checker.put(clothes[1], checker.getOrDefault(clothes[1],0) + 1);
            }

            System.out.println(findMixClothes(checker));
        }

    }

    public static int findMixClothes(Map<String, Integer> checker) {
        int combinations = 1;
        for (int count : checker.values()) {
            combinations *= (count + 1);
        }

        return combinations - 1;
    }

}
