package com.brunosong.algorithm_new.배열;

import java.util.ArrayList;
import java.util.List;

public class 배열합치기 {

    public static void main(String[] args) {

        //배열을 합친다.
        //오름차순으로 만든다.

        int[] arr1 = {1,3,5};
        int[] arr2 = {2,3,6,7,9};

        int p1 = 0, p2 = 0;
        int one = arr1.length;
        int two = arr2.length;

        //배열을 합치는 함수를 이용해도 될것 같다.
        //arr1 + arr2 합친후 오름차순 정렬
        List<Integer> answer = new ArrayList<>();

        //투포인트로 합치기
        while (p1 < one && p2 < two) {
            if(arr1[p1] < arr2[p2]) answer.add(arr1[p1++]);
            else {
                answer.add(arr2[p2++]);
            }
        }

        while (p1 < one) answer.add(arr1[p1++]);
        while (p2 < two) answer.add(arr2[p2++]);

        System.out.println(answer);

    }


}
