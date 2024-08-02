package com.brunosong.algorithm_new.DFS;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 합이같은부분집합_2 {

    boolean isFlag = false;

    @Test
    void test() {
        // {1, 3, 5, 6, 7, 10}이 입력되면 {1, 3, 5, 7} = {6, 10} 으로 두 부분집합의 합이
        // 16으로 같은 경우가 존재하는 것 찾기
        int[] arr = {1 ,3 ,5 ,6 ,7 ,10};

        solution(arr);

    }

    public String solution(int[] arr) {
        String answer = "";
        int[] ch = new int[arr.length + 1];
        int total = Arrays.stream(arr).sum();

        System.out.println(DFS(0, 0, arr, total));

        return answer;
    }

    public String DFS(int L, int sum, int[] arr, int total) {

        if(total / 2 < sum) return "NO";
        if(isFlag) return "NO";

        if(L == arr.length) {
            if(total / 2 == sum) {
                isFlag = true;
                return "YES";
            }
        } else {
            String dfs = DFS(L + 1, arr[L] + sum, arr, total);
            if(dfs.equals("YES")) {
                isFlag = true;
                return "YES";
            }
            String dfs1 = DFS(L + 1, sum, arr, total);
            if(dfs1.equals("YES")) {
                isFlag = true;
                return "YES";
            }
        }

        return "NO";
    }

}
