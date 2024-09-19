package com.brunosong.algorithm_new.백준.집합과맵;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 서로_다른_부분_문자열의_개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j <= str.length(); j++) {
                set.add(str.substring(i,j));
            }
        }

        System.out.println(set.size());
    }

}
