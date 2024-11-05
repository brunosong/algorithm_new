package com.brunosong.algorithm_new.백준.수학;

import java.util.Arrays;
import java.util.Scanner;

public class 더하기사이클 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nums = sc.nextLine();
        int N = Integer.parseInt(nums);

        nums = addZeroNum(N);

        String newNum = nums;
        int cnt = 0;

        while (true) {
            String lastNums = getLastNums(Integer.parseInt(newNum));
            int sum = getSum(newNum);
            newNum = lastNums + getLastNums(sum);
            cnt++;
            if (newNum.equals(nums)) {
                break;
            }
        }

        System.out.println(cnt);
    }

    public static String getLastNums(Integer num) {
        String s = addZeroNum(num);
        return s.split("")[1];
    }

    public static String addZeroNum(Integer num) {
        return String.format("%02d", num);
    }

    public static int getSum(String num) {
        int[] arr = Arrays.stream(num.split(""))
                .mapToInt(Integer::parseInt).toArray();
        return arr[0] + arr[1];
    }
}
