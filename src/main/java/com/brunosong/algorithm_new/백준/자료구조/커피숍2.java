package com.brunosong.algorithm_new.백준.자료구조;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 커피숍2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nq = sc.nextLine();

        int N = Integer.parseInt(nq.split(" ")[0]);
        int Q = Integer.parseInt(nq.split(" ")[1]);

        String[] nArr = sc.nextLine().split(" ");
        int[] nArrInt = Stream.of(nArr).mapToInt(Integer::parseInt).toArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            String[] xyab = sc.nextLine().split(" ");
            int[] xyabInts = Stream.of(xyab).mapToInt(Integer::parseInt).toArray();

            int sum = 0;
            if (xyabInts[0] < xyabInts[1]) {
                for (int j = xyabInts[0]-1; j <= xyabInts[1]-1; j++) {
                    sum += nArrInt[j];
                }
            } else {
                for (int j = xyabInts[1]-1; j > xyabInts[0]-1; j--) {
                    sum += nArrInt[j];
                }
            }


            int temp = nArrInt[xyabInts[2]];
            nArrInt[xyabInts[2]] = nArrInt[xyabInts[3]];
            nArrInt[xyabInts[3]] = temp;
            sb.append(sum);
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
