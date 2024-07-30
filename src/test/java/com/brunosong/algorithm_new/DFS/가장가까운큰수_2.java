package com.brunosong.algorithm_new.DFS;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 가장가까운큰수_2 {

    int n = 321;

    boolean flag = false;

    int answer = -1;

    @Test
    void test() {

        String str = String.valueOf(n);
        String[] arr = str.split("");

        int[] ch = new int[str.length()];

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        DFS(0, "", arr, ch);

        System.out.println(answer);
    }


    void DFS(int L, String S, String[] arr, int[] ch) {

        if(flag) return;

        if(L == arr.length) {
            System.out.println(S);
            if(n < Integer.parseInt(S)) {
                answer =  Integer.parseInt(S);
                flag = true;
            }
        } else {

            for (int i = 0; i < arr.length; i++) {
                // 레벨이 0일때는 n의 첫번째 숫자보다 작은 숫자들은 돌릴 필요가 없다.
                // 54312라고 한다면 정렬했을때 1,2,3,4,5이다. 5보다 작은것들은 굳히 시작할 이유가 없다.
                if(L == 0 && Integer.parseInt(arr[i]) < Integer.parseInt(Integer.toString(n).substring(0,1)) ) continue;
                if(ch[i] == 0) {
                    ch[i] = 1;
                    DFS(L+1, S + arr[i], arr, ch);
                    ch[i] = 0;
                }
            }
        }

    }



}
