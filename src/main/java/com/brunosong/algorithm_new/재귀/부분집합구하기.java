package com.brunosong.algorithm_new.재귀;

import java.util.Arrays;

public class 부분집합구하기 {

    /*
    자연수 N이 주어지면 1부터 N까지의 원소를 갖는 집합의 부분집합을 모두 출력하는 프로그램을 작성하세요.

    ▣ 입력설명
    첫 번째 줄에 자연수 N(1<=N<=10)이 주어집니다.

    ▣ 출력설명
    첫 번째 줄부터 각 줄에 하나씩 부분집합을 아래와 출력예제와 같은 순서로 출력한다. 단 공집합은 출력하지 않습니다.

    ▣ 입력예제 1
    3

    ▣ 출력예제 1
    1 2 3
    1 2
    1 3
    1
    2 3
    2
    3

    잘 생각을 해보면 집합이라는것이 {1,2,3} 중에 하나가 있을수도 없을수도 있는것 이다.

    */
    static int m = 3;
    static int[] ch = new int[m + 1];
    public static void main(String[] args) {
        DFS(1);
    }

    static void DFS(int n) {
        if( n == m + 1) {

            for (int i = 0; i < ch.length; i++) {
                if(ch[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println(" ");
        } else {
            ch[n] = 1;
            DFS(n + 1);
            ch[n] = 0;
            DFS(n + 1);
        }

    }


}
