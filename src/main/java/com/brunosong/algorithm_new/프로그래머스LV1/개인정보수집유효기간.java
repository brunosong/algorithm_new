package com.brunosong.algorithm_new.프로그래머스LV1;


import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;
import java.util.*;

public class 개인정보수집유효기간 {

    public static void main(String[] args) {

//        today	terms	privacies	result
//        "2022.05.19"	["A 6", "B 12", "C 3"]	["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]	[1, 3]
//        "2020.01.01"	["Z 3", "D 5"]	["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]	[1, 4, 5]

        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies =  {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        System.out.println(Arrays.toString(solution2(today,terms,privacies)));

    }


    public static int ONE_YEAR_MONTH_CNT = 12;
    public static int ONE_MONTH_DAY_CNT = 28;

    public static int[] solution2(String today, String[] terms, String[] privacies) {

        Map<String,Integer> termsMap = new HashMap<>();

        for (String t : terms) {
            termsMap.put( t.split(" ")[0], Integer.parseInt(t.split(" ")[1]));
        }

        List<Integer> answer = new ArrayList<>();

        //오늘 날짜를 카운트로 구하자
        int todayCnt = getDays(today);

        for (int i = 0; i < privacies.length; i++) {

            String[] dateType = privacies[i].split(" ");
            String date = dateType[0];
            String type = dateType[1];

            //시작 날짜를 구하자
            int startCnt = getDays(date);

            //시작날짜와 유효기간 날짜를 더해준다.
            Integer nextMonth = termsMap.get(type);
            //보관 가능한 최종일자
            int totalDate = startCnt + (nextMonth * ONE_MONTH_DAY_CNT) - 1;

            //오늘 날짜의 카운트랑 보관가능한 최종일자의 카운트를 비교해서 최종일자의 카운트가 오늘날짜보다 적으면 파기다
            if(todayCnt > totalDate) {  //유효기간이 남은거
                answer.add(i+1);
            }

        }

        return answer.stream().mapToInt(value -> value).toArray();
    }


    public static int getDays ( String date ){


        String[] temp = date.split("\\.");

        int year = Integer.parseInt(temp[0]);
        int month = Integer.parseInt(temp[1]);
        int day = Integer.parseInt(temp[2]);

        //총 날짜를 데이로 구하자
        int dateCnt = (year * ONE_YEAR_MONTH_CNT * ONE_MONTH_DAY_CNT) + (month * ONE_MONTH_DAY_CNT) + day;

        return dateCnt;
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


    //todo. 나중에 이거 꼭한번 구해보기  ( 데이로 만들었던 날짜를 2022.xx.xx로 만들기 )
    //   year = afterDateCnt / 12 / oneMonthDay;
    //   month = (afterDateCnt - (year * oneMonthDay * 12)) / oneMonthDay;
    //   day = (afterDateCnt - ((year) * oneMonthDay * 12)) - 1 % oneMonthDay;  마지막 한자리가 문제임...




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
