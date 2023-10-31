package com.brunosong.algorithm_new.투포인트;

public class 연속부분수열 {
    public static void main(String[] args) {

        int[] arr = {1,2,1,3,1,1,1,2};
        int m = 6;

        //더했을때 m값이 되는 경우의 수

        int lt = 0;
        int rt;
        int sum = 0;

        int cnt = 0;

        for (rt = 0; rt < arr.length; rt++) {
            sum += arr[rt];
            if(sum == m) cnt++;

            while (sum >= m) {
                sum -= arr[lt++];
                if(sum == m) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
