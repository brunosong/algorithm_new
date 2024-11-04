package com.brunosong.algorithm_new.프로그래머스;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 동영상재생기 {

    @Test
    void test() {
//        Assertions.assertEquals(
//            solution("34:33","13:00","00:55","02:55",new String[]{"next", "prev"})
//        ,"13:00");

//        Assertions.assertEquals(
//                solution("10:55","00:05","00:15","06:55",new String[]{"prev", "next", "next"})
//                ,"06:55");

        Assertions.assertEquals(
                solution("07:22","04:05","00:15","04:07",new String[]{"next"})
                ,"04:17");

    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";

        int posTime = convertTime(pos);
        int opStartTime = convertTime(op_start);
        int opEndTIme = convertTime(op_end);
        int videoTime = convertTime(video_len);

        if ((opStartTime <= posTime) && (posTime <= opEndTIme)) {
            posTime = opEndTIme;
        }

        for (String c : commands) {
            if (c.equals("prev")) {
                if (posTime - 10 <= 0) posTime = 0;
                else posTime = posTime - 10;
            } else if (c.equals("next")){
                if (posTime + 10 > videoTime) posTime = videoTime;
                else posTime = posTime + 10;
            }

            if ((opStartTime <= posTime) && (posTime <= opEndTIme)) {
                posTime = opEndTIme;
            }
        }

        return convertStringTime(posTime);
    }

    public int convertTime(String time) {
        String[] hourMin = time.split(":");
        return Integer.parseInt(hourMin[0]) * 60 + Integer.parseInt(hourMin[1]);
    }

    public String convertStringTime(int time) {
        int hour = time / 60;
        int minute = time % 60;

        return String.format("%02d:%02d", hour, minute);
    }
}
