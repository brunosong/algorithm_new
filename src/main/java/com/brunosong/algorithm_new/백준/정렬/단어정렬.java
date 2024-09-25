package com.brunosong.algorithm_new.백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class 단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeSet<String[]> set = new TreeSet<>((s1,s2) -> {
            if (s1[1].equals(s2[1])) {
                return s1[0].compareTo(s2[0]);
            }
            return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);
        });

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            set.add(new String[]{str,String.valueOf(str.length())});
        }

        for (String[] s : set) {
            System.out.println(s[0]);
        }

    }
}
