package com.brunosong.algorithm_new.투포인트;

import java.util.ArrayList;
import java.util.List;

public class 두배열합치기 {

    public static void main(String[] args) {

        int[] arr1 = {1,3,5};
        int[] arr2 = {2,3,6,7,9};

        //투포인트 알고리즘 사용
        List<Integer> list = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < arr1.length && p2 < arr2.length) {

            if(arr1[p1] < arr2[p2]) {
                list.add(arr1[p1++]);
            } else {
                list.add(arr2[p2++]);
            }
        }

        while (p1 < arr1.length) list.add(arr1[p1++]);
        while (p2 < arr2.length) list.add(arr2[p2++]);

        System.out.println(list);
    }


}
