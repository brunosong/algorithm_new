package com.brunosong.algorithm_new.프로그래머스LV1;


import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 개인정보수집유효기간 {

    public static void main(String[] args) {

//        today	terms	privacies	result
//        "2022.05.19"	["A 6", "B 12", "C 3"]	["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]	[1, 3]
//        "2020.01.01"	["Z 3", "D 5"]	["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]	[1, 4, 5]

        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies =  {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        solution2(today,terms,privacies);

    }


    public static int[] solution2(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        Map<String,Integer> termsMap = new HashMap<>();

        for (String t : terms) {
            termsMap.put( t.split(" ")[0], Integer.parseInt(t.split(" ")[1]));
        }

        for (String dateType : privacies) {

            String type = dateType.substring(dateType.length() - 1);
            String date = dateType.replaceAll("\\D", "");

            Integer nextMonth = termsMap.get(type);

            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(4, 6));
            int day = Integer.parseInt(date.substring(6, 8));

            int oneMonthDay = 28;
            int nextDay = nextMonth * oneMonthDay;

            //총 날짜를 데이로 구하자
            int nowDateCnt = (year * 12 * oneMonthDay) + (month * oneMonthDay) + day;

            int afterDateCnt = nowDateCnt + nextDay - 1;

            year = afterDateCnt / 12 / oneMonthDay;
            month = (afterDateCnt - (year * oneMonthDay * 12)) / oneMonthDay;
            day = (afterDateCnt - ((year) * oneMonthDay * 12)) % oneMonthDay;

            System.out.print(year + " ");
            System.out.print(month + " ");
            System.out.print(day + " ");
            System.out.println("  ");

        }
        return answer;
    }


    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        String date = "2021.05.02";
        String[] dateArr = date.split("\\.");

        //6개월 후 구하기
        LocalDate startDate = LocalDate.of(Integer.parseInt(dateArr[0]),
                                     Integer.parseInt(dateArr[1]),
                                     Integer.parseInt(dateArr[2])
        );

        LocalDate sixAfterMonth = startDate.plusMonths(6);





        return answer;
    }



//    int afterMonth = Integer.parseInt(dateArr[1]) + month;
//
//    //6개월 후 구하기
//        if ( afterMonth <= 12 ) {
//        dateArr[1] = String.valueOf(afterMonth);
//
//    } else if(afterMonth >= 13) {
//        String year = dateArr[0];
//        dateArr[0] = String.valueOf(Integer.parseInt(year) + (afterMonth / 12));
//        dateArr[1] = String.valueOf(afterMonth % 12);
//    }


}
