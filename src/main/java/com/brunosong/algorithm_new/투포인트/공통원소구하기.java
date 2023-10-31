package com.brunosong.algorithm_new.투포인트;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 공통원소구하기 {
    public static void main(String[] args) {

        int[] arr1 = {1,3,9,5,2};
        int[] arr2 = {3,2,5,7,8};

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1 = 0;
        int p2 = 0;

        List<Integer> list = new ArrayList<>();

        while (p1 < arr1.length && p2 < arr2.length) {
            if(arr1[p1] == arr2[p2]) {
                list.add(arr1[p1]);
                p1++;p2++;
            } else if(arr1[p1] > arr2[p2]) {
                p2++;
            } else {
                p1++;
            }
        }

        System.out.println(list);

    }
}
