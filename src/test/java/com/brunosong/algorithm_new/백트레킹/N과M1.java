package com.brunosong.algorithm_new.백트레킹;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Scanner;

public class N과M1 {

    @Test
    void test() {

        Scanner sc = new Scanner(System.in);
        String stt = sc.nextLine();

        int n = 4;
        int m = 4;

        int[] dis = new int[m];
        int[] ch = new int[n+1];

        printNums(0,m,n,dis,ch);
    }

    void printNums(int l, int m, int n, int[] dis, int[] ch) {

        if(l == m) {
            for (int i = 0; i < dis.length; i++) {
                System.out.print(dis[i] + " ");
            }
            System.out.println();
            //System.out.println(Arrays.toString(dis));
        } else {
            for (int i = 0; i < n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    dis[l] = i+1;
                    printNums(l+1,m,n,dis,ch);
                    ch[i] = 0;
                }

            }

        }
    }




}
