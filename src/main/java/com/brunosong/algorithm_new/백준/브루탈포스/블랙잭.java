package com.brunosong.algorithm_new.백준.브루탈포스;

import java.util.Arrays;
import java.util.Scanner;

public class 블랙잭 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();

        Integer N = Integer.parseInt(tmp.split(" ")[0]);
        Integer M = Integer.parseInt(tmp.split(" ")[1]);

        int[] cards = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int answer = 0;

        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards.length; j++) {
                for (int k = 0; k < cards.length; k++) {
                    if ((i != j) && (j != k) && (i != k)) {
                        int sum = cards[i] + cards[j] + cards[k];
                        if (sum <= M) {
                            answer = Math.max(answer, sum);
                        }
                    }
                }
            }
        }

        System.out.println(answer);

    }
}
