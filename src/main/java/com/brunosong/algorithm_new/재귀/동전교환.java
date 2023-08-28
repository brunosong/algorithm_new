package com.brunosong.algorithm_new.재귀;

public class 동전교환 {


    /*
        다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환 해주려면 어떻게 주면 되는가?
        각단위의 동전은 무한히 쓸수 있다.

        첫번째 줄에 거슬러 줄 동전의 최소 개수를 출력한다.

        3
        1 2 5
        15
        1원 짜리 15개를 줘도 되고 , 5원 짜리 3개를 줘도 된다.
        가장 적은거니깐 5원짜리 3개가 정답이다.
    */


    public static void main(String[] args) {

        Solution solution = new Solution(15, new int[]{1,2,5});
        solution.DFS2(0,0);

        System.out.println(solution.min);

        solution.solution(10);
    }




}



class Solution {

    int min = Integer.MAX_VALUE;
    int target;
    int[] dis;

    public Solution(int target, int[] dis) {
        this.target = target;
        this.dis = dis;
    }

    public void DFS(int moneyUseCnt, int sum) {

        if(sum > target) return;

        if( sum == target ) {
            min = Math.min(moneyUseCnt, min);
        } else {
            for ( int moneyType : dis ) {
                DFS( moneyUseCnt + 1, sum + moneyType);
            }
        }

    }

    /*  */
    public void DFS2(int moneyUseCnt, int sum) {

        if(sum > target) return;

        /*
            만약 5 + 3 + 2 + 2 + 1 + 2 뭐 이렇게 레벨 6 이었을때 그 이하인 7개의 갯수로 15를 만들어 봐야
            아무 의미 없기 때문에 처리를 해준다.
        */
        if(moneyUseCnt >= min) return;

        if( sum == target ) {
            min = Math.min(moneyUseCnt, min);
        } else {
            for ( int moneyType : dis ) {
                DFS( moneyUseCnt + 1, sum + moneyType);
            }
        }

    }


    public int solution(int n) {

        int threeNumber = 0;
        int j = 1;

        for (; j <= n; j++) {

            threeNumber++;

            while (threeNumber % 3 == 0 || String.valueOf(threeNumber).indexOf("3") > -1) {
                threeNumber++;
            }

            System.out.println(j + " : " + threeNumber);

        }


        return threeNumber;
    }


}
