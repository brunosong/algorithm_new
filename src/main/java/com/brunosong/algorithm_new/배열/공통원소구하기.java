package com.brunosong.algorithm_new.배열;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 공통원소구하기 {
    /*
        A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하세요.

        ▣ 입력설명
        첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
        두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
        세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
        네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
        각 집합의 원소는 1,000,000,000이하의 자연수입니다.

        ▣ 출력설명
        두 집합의 공통원소를 오름차순 정렬하여 출력합니다.

        ▣ 입력예제 1
        5
        1 3 9 5 2
        5
        3 2 5 7 8

        ▣ 출력예제 1
        2 3 5
    */

    public static void main(String[] args) {

        int[] arr1 = {1 ,3 ,9 ,5 ,2};
        int[] arr2 = {3 ,2 ,5 ,7 ,8};

        int m = arr1.length;
        int n = arr2.length;

        //투포인트 알고리즘으로 진행
        int p1 = 0;
        int p2 = 0;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        List<Integer> answer = new ArrayList<>();

        while (p1 < m && p2 < n) {

            if (arr1[p1] == arr2[p2]) {
                answer.add(arr1[p1++]);
                p2++;
            } else if (arr1[p1] > arr2[p2]) {
                p2++;
            } else p1++;

        }


        System.out.println(answer);
    }






}
