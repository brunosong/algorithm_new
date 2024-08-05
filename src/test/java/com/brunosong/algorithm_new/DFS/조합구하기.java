package com.brunosong.algorithm_new.DFS;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 조합구하기 {

    int n = 4;
    int m = 2;

    @Test
    void test() {
//        1 2
//        1 3
//        1 4
//        2 3
//        2 4
//        3 4
        int[] dis = new int[m];
        printNumbers(0,1, dis);



    }


    public void printNumbers(int level, int start, int[] dis) {

        if (level == m) {

            System.out.println(Arrays.toString(dis));
        } else {

            for (int i = start; i <= 4; i++) {
                dis[level] = i;
                printNumbers(level+1,i+1, dis);
            }

        }
    }

}
