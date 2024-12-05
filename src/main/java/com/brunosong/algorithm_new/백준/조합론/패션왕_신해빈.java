package com.brunosong.algorithm_new.백준.조합론;

import java.util.*;

public class 패션왕_신해빈 {

    public static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            List<String[]> temp = new ArrayList<>();
            Map<String, Integer> checker = new HashMap<>();

            int clothesCnt = Integer.parseInt(sc.nextLine());
            answer = 0;

            for (int j = 0; j < clothesCnt; j++) {
                String[] clothes = sc.nextLine().split(" ");
                temp.add(new String[]{clothes[0], clothes[1]});
                checker.put(clothes[1], 0);
            }

            findMixClothes(0, temp, clothesCnt, checker);
            System.out.println(answer);
        }

    }

    public static void findMixClothes(int level, List<String[]> temp, int clothesCnt, Map<String, Integer> checker) {
        if (level == clothesCnt) {
            answer++;
        } else {
            String[] current = temp.get(level);
            if (checker.get(current[1]) == 0) {
                checker.put(current[1], 1);
                findMixClothes(level+1, temp, clothesCnt, checker);
                checker.put(current[1], 0);
                findMixClothes(level+1, temp, clothesCnt, checker);
            } else {
                findMixClothes(level+1, temp, clothesCnt, checker);
            }
        }
    }

}
