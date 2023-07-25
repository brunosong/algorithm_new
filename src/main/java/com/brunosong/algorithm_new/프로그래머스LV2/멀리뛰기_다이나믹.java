package com.brunosong.algorithm_new.프로그래머스LV2;

/*
    멀리 뛰기

    문제 설명
    효진이는 멀리 뛰기를 연습하고 있습니다. 효진이는 한번에 1칸, 또는 2칸을 뛸 수 있습니다. 칸이 총 4개 있을 때, 효진이는
    (1칸, 1칸, 1칸, 1칸)
    (1칸, 2칸, 1칸)
    (1칸, 1칸, 2칸)
    (2칸, 1칸, 1칸)
    (2칸, 2칸)
    의 5가지 방법으로 맨 끝 칸에 도달할 수 있습니다. 멀리뛰기에 사용될 칸의 수 n이 주어질 때, 효진이가 끝에 도달하는 방법이 몇 가지인지 알아내, 여기에 1234567를 나눈 나머지를 리턴하는 함수, solution을 완성하세요. 예를 들어 4가 입력된다면, 5를 return하면 됩니다.

    제한 사항
    n은 1 이상, 2000 이하인 정수입니다.
    입출력 예
    n	result
    4	5
    3	3
    입출력 예 설명
    입출력 예 #1
    위에서 설명한 내용과 같습니다.

    입출력 예 #2
    (2칸, 1칸)
    (1칸, 2칸)
    (1칸, 1칸, 1칸)
    총 3가지 방법으로 멀리 뛸 수 있습니다.
*/
public class 멀리뛰기_다이나믹 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.solution(4);
    }

}


class Solution {
    /* 다이나믹으로 풀수 있다. */
    public long solution(int n) {

        long answer = 0;

        if(n == 1) return 1;
        if(n == 2) return 2;

        long[] dy = new long[n+1];
        dy[1] = 1L;
        dy[2] = 2L;

        for (int i = 3; i <= n; i++) {
            //dy[i] = dy[i - 2] + dy[ i - 1]; //이거는 틀리고
            dy[i] = (dy[i - 2] + dy[ i - 1]) % 1234567;  //이거는 맞았다고 나옴.... 이유가 뭐지
        }

        return dy[n];

    }
}