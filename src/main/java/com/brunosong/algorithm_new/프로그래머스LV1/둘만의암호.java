package com.brunosong.algorithm_new.프로그래머스LV1;

import java.util.HashSet;
import java.util.Set;

public class 둘만의암호 {

    public static void main(String[] args) {
        //"aukks", skip = "wbqd", index = 5
       String s = "zzzzz";
        String skip = "a";
        int index = 1;
        //"happy"

        System.out.println(solution2(s,skip,index));

    }

    public static String solution(String s, String skip, int index) {

        char[] charArray = s.toCharArray();

        Set<Character> set = new HashSet<>();
        for( char x : skip.toCharArray()) set.add(x);

        StringBuilder answer = new StringBuilder();

        for(char x : charArray){
            int temp = x;
            for (int i = 1; i <= index; i++) {

                temp += 1;

                if( temp >= 123) {
                    temp -= 26;
                }

                while (set.contains((char)temp)){
                    temp++;
                    if( temp >= 123) {
                        temp -= 26;
                    }
                }

            }

            answer.append((char)temp);
        }


        return answer.toString();
    }


    public static String solution2(String s, String skip, int index) {

        char[] charArray = s.toCharArray();

        Set<Character> set = new HashSet<>();
        for( char x : skip.toCharArray()) set.add(x);

        StringBuilder answer = new StringBuilder();

        for(char x : charArray){
            int temp = x;
            int cnt = 0;
            while (cnt < index){
                temp++;
                if(temp >= 123) { temp -= 26; }

                if(!set.contains((char)temp)){
                    cnt++;
                }
            }

            answer.append((char)temp);
        }


        return answer.toString();
    }

}
