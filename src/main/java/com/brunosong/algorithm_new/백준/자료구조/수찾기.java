package com.brunosong.algorithm_new.백준.자료구조;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 수찾기 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();
        String arrN = scanner.nextLine();

        int M = scanner.nextInt();
        scanner.nextLine();
        String arrM = scanner.nextLine();

        Set<Integer> setN = Stream.of(arrN.split(" ")).map(Integer::parseInt)
                .collect(Collectors.toSet());

        List<Integer> collect = Stream.of(arrM.split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        for (int x : collect) {
            if (setN.contains(x)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
