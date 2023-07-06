package com.brunosong.algorithm_new.프로그래머스LV1;

import java.util.ArrayList;
import java.util.List;

public class 옹알이 {
    public static void main(String[] args) {
        String[] babbling = //{"aya", "yee", "u", "maa"};	//1
                 {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};	//2
                //{"ayayeyeayayeaya"};
                //{"ayaaya"};

        solution2(babbling);
    }


    public static int solution2(String[] babbling) {

        String[] baby = {"aya", "ye", "woo", "ma"};

        int answer = 0;
        int cnt = 0;


        for (int i = 0; i < babbling.length; i++) {

            String s = babbling[i];

            boolean ch = true;

            for (int j = 0; j < baby.length; j++) {
                if(s.equals("")) break;
                String b = baby[j];

                while (s.indexOf(b) > -1){
                    //중복검사를 위한 시작위치
                    int startPoint = s.indexOf(b) + b.length();
                    if(s.length() >= startPoint + b.length()) {
                        String substring = s.substring(startPoint, startPoint + b.length());
                        if(substring.equals(b)){
                            System.out.println("중복");
                            ch = false;
                            break;
                        }
                    }
                    s = s.replaceFirst( b , " ");
                }
            }

            s = s.replaceAll(" ","");

            if(s.length() == 0 && ch) {
                cnt++;
            }


        }
        return answer;
    }



    public static int solution(String[] babbling) {

        String[] baby = {"aya", "ye", "woo", "ma"};

        int answer = 0;
        int cnt = 0;


        for (int i = 0; i < babbling.length; i++) {

            String s = babbling[i];

            boolean ch = true;

            for (int j = 0; j < baby.length; j++) {
                if(s.equals("")) break;
                String b = baby[j];

                if(s.indexOf(b) > -1){
                    // 단어가 하나밖에 없다는거
                    if(s.indexOf(b) == s.lastIndexOf(b)) {
                        s = s.replaceFirst(b,"");
                    } else {
                        //붙어있다는것 무조건 안됨
                        if(s.indexOf(b) + b.length() == s.lastIndexOf(b)) {
                            ch = false;
                            break;
                        }

                        s = s.replaceAll( b , " ");

                    }

                }

            }
            s = s.replaceAll(" ","");
            if(s.length() == 0 && ch) {
                cnt++;
            }


        }
        return answer;
    }





}
