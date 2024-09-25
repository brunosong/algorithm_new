package com.brunosong.algorithm_new.백준.재귀;

import java.util.Scanner;

public class 재귀의귀재 {

    public static int reCnt = 0;
    public static int result = 0;

    public static int recursion(String s, int l, int r){
        reCnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            reCnt = 0;
            result = 0;
            String s = sc.nextLine();
            result = isPalindrome(s);
            sb.append(result + " " + reCnt).append("\n");
        }


        System.out.println(sb);
    }
}
