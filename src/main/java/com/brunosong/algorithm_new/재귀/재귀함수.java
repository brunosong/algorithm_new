package com.brunosong.algorithm_new.재귀;

public class 재귀함수 {

    /*
        문제 1 :
        자연수 N이 입력되면 재귀함수를 이용하여 1부터 N까지를 출력하는 프로그램을 작성하세요.

        ▣ 입력설명
        첫 번째 줄은 정수 N(3<=N<=10)이 입력된다.

        ▣ 출력설명
        첫째 줄에 출력한다.

        ▣ 입력예제 1
        3

        ▣ 출력예제 1
        1 2 3

        문제 2 :
        10진수 N이 입력되면 2진수로 변환하여 출력하는 프로그램을 작성하세요. 단 재귀함수를 이용
        해서 출력해야 합니다.

    */

    public static void main(String[] args) {
        System.out.println("============== 재귀함수 ================");
        fac(3);
        System.out.println();
        System.out.println("============== 재귀함수를 이용한 이진수 출력 ================");
        binaryNumberFac(11);
    }

    /* 재귀함수 */
    static void fac(int n){

        if( n == 0 ) return;
        else {
            fac(n-1);
            System.out.print(n + " ");
        }
    }


    /* 재귀함수를 이용한 이진수 출력 */
    static void binaryNumberFac(int n){
        if(n == 0) {
            return;
        } else {
            binaryNumberFac(n / 2);
            System.out.print(n % 2);
        }


    }


}
