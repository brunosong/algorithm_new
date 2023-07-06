package com.brunosong.algorithm_new.프로그래머스LV1;

public class 기사단원의무기 {

    public static void main(String[] args) {

//        number	limit	power	result
//        5	    3	2	10
//        10	3	2	21

        int a;
        int num = 4;

        //단순 약수 구하기
        for(a = 1; a <= num; a++) {
            if ((num % a) == 0) {
                System.out.println(a);
            }
        }

        int cnt = 0;

        for (int i = 1 ; i * i <= num ; i++){
            if( i * i == num ) cnt++;
            else if (num % i == 0) {
                cnt += 2;
            }
        }

        System.out.println(cnt);




    }


    public static int solution(int number, int limit, int power) {

        int answer = 0;

        int totalPower = 0;

        for (int pNum = 1; pNum <= number; pNum++){

            int cnt = 0;

            for (int i = 1 ; i * i <= pNum ; i++){
                if( i * i == pNum ) cnt++;
                else if (pNum % i == 0) {
                    cnt += 2;
                }
            }

            if (limit < cnt) totalPower += power;
            else {
                totalPower += cnt;

            }




        }



        return answer;

    }

}
