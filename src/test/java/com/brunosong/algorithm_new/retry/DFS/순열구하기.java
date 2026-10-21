package com.brunosong.algorithm_new.retry.DFS;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Arrays;

public class 순열구하기 {

    @Test
    void test() {
        int[] arr = {3,6,9};
        int m = 2;

        DFS(0, arr, new int[arr.length], new int[m]);
    }

    void DFS(int level, int[] arr, int[] ch, int[] dis) {

        if (dis.length == level) {
            System.out.println(Arrays.toString(dis));
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (ch[i] == 0) {
                    dis[level] = arr[i];
                    ch[i] = 1;
                    DFS(level + 1, arr, ch, dis);
                    ch[i] = 0;
                }
            }
        }
    }
}
