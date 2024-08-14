package com.brunosong.algorithm_new.백트레킹;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class N과M3 {

    @Test
    void test() throws Exception{

        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();

        int n = 3;
        int m = 3;

        //StringBuilder 도 통과함
        //BufferedWriter : 640ms, StringBuilder : 750ms
        int[] dis = new int[m];
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        printNums(0,m,n,dis,bw);

        bw.flush();
        bw.close();
    }

    void printNums(int l, int m, int n, int[] dis,BufferedWriter bw) throws IOException {

        if(l == m) {
            for (int i = 0; i < dis.length; i++) {
                bw.write(dis[i] + " ");
            }
            bw.newLine();

        } else {

            for (int i = 1; i <= n; i++) {
                dis[l] = i;
                printNums(l+1,m,n,dis,bw);
            }

        }



    }




}
