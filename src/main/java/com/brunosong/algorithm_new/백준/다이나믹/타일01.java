package com.brunosong.algorithm_new.백준.다이나믹;

import java.util.Scanner;

public class 타일01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        if (N == 1) {
            System.out.println(1);
            return;
        }

        if (N == 2) {
            System.out.println(2);
            return;
        }

        //굳이 dp가 필요없다.
        int prev1 = 2;
        int prev2 = 1;
        int current = 0;

        for (int i = 2; i <= N; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        System.out.println(current % 15746);

    }


}
