package com.brunosong.algorithm_new.백준.정렬;

import java.util.*;

public class 로프 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(sc.nextLine()));
        }

        Collections.sort(list);

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            Integer num = list.get(i);
            set.add(num * (list.size() - i));
        }

        System.out.println(set.last());

    }
}
