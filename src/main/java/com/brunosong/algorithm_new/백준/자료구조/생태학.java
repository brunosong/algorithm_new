package com.brunosong.algorithm_new.백준.자료구조;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class 생태학 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> map = new TreeMap<>();

        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            map.put(str, map.getOrDefault(str,0) + 1);
        }

        map.forEach((k,v) -> {
            System.out.print(k + " " + Math.round((map.size() / v) * 10000.0) / 10000.0);
        });

    }
}
