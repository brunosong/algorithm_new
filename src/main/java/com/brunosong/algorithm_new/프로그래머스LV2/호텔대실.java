package com.brunosong.algorithm_new.프로그래머스LV2;

import lombok.ToString;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 호텔대실 {

    /* 그리디로 풀어보자 */

    /*  시각은 HH:MM 형태로 24시간 표기법을 따르며, "00:00" 부터 "23:59" 까지로 주어집니다.
예약 시각이 자정을 넘어가는 경우는 없습니다.
시작 시각은 항상 종료 시각보다 빠릅니다.

    그리디로 풀어서 100점 맞음!!!!

    그래도 조금씩 실력이 늘고 있다.!!!
*/

    public static void main(String[] args) {
//        String[][] book_time = {
//                          {"15:00", "17:00"}
//                        , {"16:40", "18:20"}
//                        , {"14:20", "15:20"}
//                        , {"14:10", "19:20"}
//                        , {"18:20", "21:20"} };
        String[][] book_time = {
                {"08:00", "08:30"}, {"08:00", "13:00"}, {"12:30", "13:30"}
        };

        solution(book_time);

    }

    public static int solution(String[][] book_time) {

        int answer = 0;

        List<BookingTime> list = new ArrayList<>();

        for( String[] book : book_time ) {

            String[] in = book[0].split(":"); // 입실 시간
            LocalTime inTime = LocalTime.of(Integer.parseInt(in[0]),Integer.parseInt(in[1]));

            String[] out = book[1].split(":"); // 퇴실 시간
            LocalTime outTime = LocalTime.of(Integer.parseInt(out[0]),Integer.parseInt(out[1]));

            if( outTime.getHour() == 23 && outTime.getMinute() >= 50){

            } else {
                outTime = outTime.plusMinutes(10);
            }

            list.add(new BookingTime('s',inTime));
            list.add(new BookingTime('e',outTime));

        }

        Collections.sort(list);

        list.forEach(System.out::println);

        int cnt = 0;

        for (BookingTime b : list) {

            if(b.state == 's') {
                cnt++;
                answer = Math.max(answer, cnt);
            } else {
                cnt--;
            }
        }

        System.out.println(answer);


        return answer;

    }

    @ToString
    static class BookingTime implements Comparable<BookingTime>{

        char state;
        LocalTime time;

        public BookingTime(char state, LocalTime time) {
            this.state = state;
            this.time = time;
        }

        @Override
        public int compareTo(BookingTime time) {
            //시간이 갖다면
            if(this.time.compareTo(time.time) == 0) {
                return this.state - time.state;
            }
            return this.time.compareTo(time.time);
        }
    }




}
