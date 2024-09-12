package com.brunosong.algorithm_new.백준.정렬;

import java.util.*;

public class 좌표_정렬하기_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String position = sc.nextLine();
            Integer x = Integer.parseInt(position.split(" ")[0]);
            Integer y = Integer.parseInt(position.split(" ")[1]);

            list.add(new int[]{x,y});
        }

        Collections.sort(list, (l1,l2) -> l1[1] == l2[1] ? l1[0] - l2[0] : l1[1] - l2[1]);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i)[0] + " " + list.get(i)[1]);
        }
    }
}
