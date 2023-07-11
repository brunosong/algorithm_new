package com.brunosong.algorithm_new.프로그래머스LV1;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사 {

    public static void main(String[] args) {

//                survey	choices	result
//                ["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA"
//                ["TR", "RT", "TR"]	[7, 1, 3]	"RCJA"

//        지표 번호	성격 유형
//        1번 지표	라이언형(R), 튜브형(T)
//        2번 지표	콘형(C), 프로도형(F)
//        3번 지표	제이지형(J), 무지형(M)
//        4번 지표	어피치형(A), 네오형(N)


//        매우 비동의	어피치형 3점
//        비동의	어피치형 2점
//        약간 비동의	어피치형 1점
//        모르겠음	어떤 성격 유형도 점수를 얻지 않습니다
//        약간 동의	네오형 1점
//        동의	네오형 2점
//        매우 동의	네오형 3점

        String[] survey =  {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        solution(survey,choices);

    }


    public static String solution(String[] survey, int[] choices) {
        String answer = "";

        String[][] graph = {
                {"R", "T"},      // 라이언형(R), 튜브형(T)
                {"C", "F"},       //2번 지표	콘형(C), 프로도형(F)
                {"J", "M"},       //3번 지표	제이지형(J), 무지형(M)
                {"A", "N"}        //4번 지표	어피치형(A), 네오형(N)}
        };

        Map<String,Integer> typeMap = new HashMap<>();

        for (String[] s : graph) {
            typeMap.put(s[0],0);
            typeMap.put(s[1],0);
        }

        int[] score = {3,2,1,0,1,2,3};

        for (int i = 0; i < survey.length; i++) {

            String s = survey[i];
            int point = 0;
            int choice = choices[i];
            if( choice != 4 ) {
                if( choice <= 3 ) typeMap.put( s.substring(0,1) ,typeMap.get(s.substring(0,1)) + score[choice - 1]);
                if( choice >= 5 ) typeMap.put( s.substring(1,2) ,typeMap.get(s.substring(1,2)) + score[choice - 1]);
            }


        }

        StringBuilder sb = new StringBuilder();

        for (String[] s : graph) {

            if(typeMap.get(s[0]) > typeMap.get(s[1])){
                sb.append(s[0]);
            } else if(typeMap.get(s[0]) < typeMap.get(s[1])) {
                sb.append(s[1]);
            } else {
                if(s[0].compareTo(s[1]) < 0){
                    sb.append(s[0]);
                }else {
                    sb.append(s[1]);
                }
            }
        }

        System.out.println(sb.toString());

        return answer;
    }



}
