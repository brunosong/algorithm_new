package com.brunosong.algorithm_new.백준.조합론;

import java.util.Arrays;
import java.util.Scanner;

public class 암호만들기 {

    public static String[] password;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] LC = sc.nextLine().split(" ");
        int l = Integer.parseInt(LC[0]);
        int c = Integer.parseInt(LC[1]);

        password = new String[l];

        String alpha = sc.nextLine();
        String[] pw = alpha.split(" ");
        Arrays.sort(pw);

        generatePassword(0, pw, l, 0);

    }

    public static void generatePassword(int level, String[] pw, int l, int startIdx) {
        if (level == l) {
            if (isValidPassword(password)) { // 조건 확인
                System.out.println(String.join("", password));
            }
        } else {
            for (int i = startIdx; i < pw.length; i++) {
                password[level] = pw[i];
                generatePassword(level+1, pw, l, i + 1);
                password[level] = null;
            }
        }
    }

    // 조건이 모음 1개, 자음 2개 포함
    public static boolean isValidPassword(String[] password) {
        int vowels = 0; // 모음 개수
        int consonants = 0; // 자음 개수
        for (String ch : password) {
            if (isVowel(ch)) {
                vowels++;
            } else {
                consonants++;
            }
        }
        return vowels >= 1 && consonants >= 2;
    }

    // 모음인지 확인
    public static boolean isVowel(String ch) {
        return "aeiou".contains(ch);
    }
}
