package com.brunosong.algorithm_new.투포인트;

public class 최대매출 {

    public static void main(String[] args) {

        //연속된 K일간의 최대 매출액
        int[] arr = {12,15,11,20,25,10,19,13,15};
        int k = 3;

        int sum = 0;

        //슬라이딩 윈도우로 풀어야 한다.

        //k 만큼의 값을 미리 더해둔다.
        for (int i = 0; i < k; i++) sum += arr[i];

        int max = sum;

        for (int i = k; i < arr.length; i++) {
            sum -= arr[i - k];
            sum += arr[i];
            max = Math.max(max,sum);
        }

        System.out.println(max);

    }
}
