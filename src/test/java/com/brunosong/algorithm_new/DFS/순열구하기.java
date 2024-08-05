package com.brunosong.algorithm_new.DFS;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class 순열구하기 {

    int[] nums = {3,6,9};
    int m = 2;

    @Test
    void test() {
        // 3 6
        // 3 9
        // 6 3
        // 6 9
        // 9 3
        // 9 6
        // 위와 같이 출력

        int[] dis = new int[m];
        int[] ch = new int[nums.length+1];

        printNumbers(0,dis,ch);
    }


    public void printNumbers(int level, int[] dis, int[] ch) {
        if (level == m) {
            System.out.println(Arrays.toString(dis));
        } else {

            for (int i = 0; i < nums.length; i++) {
                if(ch[i] == 0) {
                    dis[level] = nums[i];
                    ch[i] = 1;
                    printNumbers(level+1,dis,ch);
                    ch[i] = 0;
                }
            }

        }
    }
}
