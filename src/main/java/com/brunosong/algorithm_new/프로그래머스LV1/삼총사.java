package com.brunosong.algorithm_new.프로그래머스LV1;

import java.util.Arrays;

public class 삼총사 {

    public static void main(String[] args) {

        // 투포인트로 해결 가능하다고 본다.. 아 슬라이딩 윈도우
        // 3개를 합쳐서 0이되면 카운트 1 증가
//                number	result
//                [-2, 3, 0, 2, -5]	2
//                [-3, -2, -1, 0, 1, 2, 3]	5
//                [-1, 1, -1, 1]	0
        int[] number = {-3, -2, -1, 0, 1, 2, 3};
        solution2(number);

    }

    public static int solution(int[] number) {

        Arrays.sort(number);
        int answer = 0;

        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            sum += number[i];
        }

        if(sum == 0) cnt++;

        for (int i = 3; i < number.length; i++) {
            sum -= number[i - 3];
            sum += number[i];
            if(sum == 0) cnt++;
        }


        System.out.println(cnt);

        return answer;
    }


    public static int solution2(int[] number) {

        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number.length && i != j ; j++) {
                for (int k = 0; k < number.length && i != k && j != k ; k++) {
                    sum = number[i] + number[j] + number[k];
                    if(sum == 0) cnt++;
                }
            }
        }


        System.out.println(cnt);

        return cnt;
    }

}
