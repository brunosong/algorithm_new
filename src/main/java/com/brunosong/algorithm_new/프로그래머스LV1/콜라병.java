package com.brunosong.algorithm_new.프로그래머스LV1;

public class 콜라병 {


    public static void main(String[] args) {
//        a	b	n	result
//        2	1	20	19
//        3	1	20	9
        // 5 2  20     20 병을 가져가면 20 / 5 = 4가 나오는데 이게 한병일때 여기에서 2를 곱해야 한다. 그럼 8병
        // 8 에서 5개를 주면 2개를 주니깐 8 / 5 2개를 받아서 10개
        // 그럼 나머지가 3개고 2개를 더하니깐 5
        System.out.println(solution(5,2,20));

    }

    public static int solution(int a, int b, int n) {

        int cnt = 0;
        int namuge = 0;

        while (n > 0) {
            if (n % a == 0) {
                int temp = n / a * b;
                cnt += temp;
                n = temp;
            } else {
                if(namuge > 0) {
                    n = n + namuge;
                    namuge = 0;
                }
                int temp = n / a * b;
                cnt += temp;
                namuge += n % a;
                n = temp;
            }
        }



        return cnt;
    }

}
