package com.brunosong.algorithm_new.백준.수학;

import java.util.Scanner;

public class 벌집 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int N = Integer.parseInt(str);

        //13이면 13이 몇레벨인지 구해야한다.
        int level = 1;
        int sum = 1;

        if (N == 1) {
            System.out.println(N);
        } else {
            while (true) {
                sum += 6 * level;
                level++;
                if (sum >= N) {
                    break;
                }
            }
            System.out.println(level);
        }

    }
}
