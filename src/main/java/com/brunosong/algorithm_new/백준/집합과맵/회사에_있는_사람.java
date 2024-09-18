package com.brunosong.algorithm_new.백준.집합과맵;

import org.apache.logging.log4j.util.PropertySource;

import java.util.*;

public class 회사에_있는_사람 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        Set<String> memberSet = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            String name = str.split(" ")[0];
            String status = str.split(" ")[1];

            if (status.equals("enter")) {
                memberSet.add(name);
            } else {
                if (memberSet.contains(name)){
                    memberSet.remove(name);
                }
            }
        }

        for (String member : memberSet) {
            System.out.println(member);
        }
    }
}
