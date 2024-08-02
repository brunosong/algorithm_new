package com.brunosong.algorithm_new.DFS;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 바둑이승차 {

    @Test
    void test() {
        int n = 259;
        int[] arr = { 81 ,58 ,42 ,33 ,61 };

        // n에 가까운 가장 무거운 무게를 출력한다 DFS 사용
        solution2(n,arr);


    }

    int solution(int n, int[] arr) {
        int answer = 0;
        int[] max = new int[]{Integer.MIN_VALUE};
        DFS(0,0,max,arr,n);

        System.out.println(max[0]);
        return answer;
    }

    // 그리디 가능?
    int solution2(int n, int[] arr) {
        int answer = 0;
        int[] max = new int[]{Integer.MIN_VALUE};

        Arrays.sort(arr);

        //정렬해서 오른쪽 끝에서 부터 왼쪽으로 n보다 커지기전까지 더하고
        //마지막 더할때 남은 공간이 이전 값보다 작으면 while을 사용해서 더해주면?? 가능할지도





        return answer;
    }


    // 결국은 완전탐색을 해야하는 문제 (완전탐색을 해보라는문제)
    public void DFS(int L, int sum, int[] max, int[] arr, int n) {

        if(sum > n) return;

        if(L == arr.length) {
            max[0] = Math.max(max[0],sum);
        } else {
            DFS(L+1, sum + arr[L], max, arr, n);
            DFS(L+1, sum , max, arr, n);
        }
    }




}
