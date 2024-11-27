package com.brunosong.algorithm_new.백준.문자열;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 그룹단어체커 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int answer = 0;

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            if (isGroupWord(str)) {
                answer++;
            }
        }

        System.out.println(answer);

    }


    private static boolean isGroupWord(String word) {
        Set<Character> characters = new HashSet<>();
        char prevChar = '\0';

        for (char c : word.toCharArray()) {
            if (characters.contains(c) && prevChar != c) {
                return false;
            }
            characters.add(c);
            prevChar = c;
        }

        return true;
    }
}
