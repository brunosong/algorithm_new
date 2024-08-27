package com.brunosong.algorithm_new.백준.백트레킹;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class N과M2 {

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();

        int n = 4;
        int m = 4;

        int[] dis = new int[m];

        printNums(0,1,m,n,dis);
    }

    public static void printNums(int l, int start, int m, int n, int[] dis) {

        if(l == m) {
            for (int i = 0; i < dis.length; i++) {
                System.out.print(dis[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i <= n; i++) {
                dis[l] = i;
                printNums(l+1, i+1,m,n,dis);
            }
        }
    }




}
