package com.brunosong.algorithm_new.백준.조합론;

import java.util.Scanner;

public class 이항개수 {

    public static int[] dis;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        dis = new int[Math.max(n,k) + 1];
        System.out.println(fac(n) / (fac(k) * fac(n - k)));

    }

    public static int fac(int val) {
        if (val <= 1) {
            return 1;
        } else {
            if (dis[val] > 0) {
                return dis[val];
            }
            dis[val] = val * fac(val - 1);
            return dis[val];
        }
    }
}
