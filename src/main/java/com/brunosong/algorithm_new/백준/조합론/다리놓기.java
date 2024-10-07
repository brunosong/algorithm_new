package com.brunosong.algorithm_new.백준.조합론;

import java.math.BigDecimal;
import java.util.Scanner;

public class 다리놓기 {
    public static void main(String[] args) {

//        3
//        2 2
//        1 5
//        13 29
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        sc.nextLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            String[] numbers = sc.nextLine().split(" ");
            int N = Integer.parseInt(numbers[0]);
            int M = Integer.parseInt(numbers[1]);

            BigDecimal mFac = factorial(M);
            BigDecimal nFac = factorial(N);
            BigDecimal nmFoc = factorial(M-N);

            BigDecimal divide = mFac.divide(nFac.multiply(nmFoc));

            sb.append(divide).append("\n");
        }

        System.out.println(sb);
    }

    public static BigDecimal factorial(int n) {

        BigDecimal sum = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) {
            sum = sum.multiply(BigDecimal.valueOf(i));
        }
        return sum;
    }
}
