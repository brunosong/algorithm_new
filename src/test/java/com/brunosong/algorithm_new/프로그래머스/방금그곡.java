package com.brunosong.algorithm_new.프로그래머스;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.print.Pageable;
import java.util.Map;

public class 방금그곡 {

    @Test
    void test() {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        //Assertions.assertThat(solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"})).isEqualTo("WORLD");

        Assertions.assertThat(solution("CDCDCD", new String[]{"12:00,12:10,NAME,CDCDCDE", "12:30,12:50,NA,CD"})).isEqualTo("NA");
        Assertions.assertThat(solution( "CDCDF", new String[]{"13:50,14:02,WORLD,CDCDCDF"})).isEqualTo("WORLD");

    }

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        int max = -1;

        m = replaceSharp(m);

        for (String mi : musicinfos) {
            String[] infos = mi.split(",");
            int playTime = findPlayTime(infos);

            String title = infos[2];

            String musicSheet = replaceSharp(infos[3]);
            musicSheet = createMusicSheet(musicSheet, playTime);

            if (musicSheet.contains(m)) {
                if (playTime > max) {
                    max = playTime;
                    answer = title;
                }
            }
        }

        return answer;
    }

    public String replaceSharp(String text) {
        return text.replace("C#", "c")
                .replace("D#", "d")
                .replace("F#", "f")
                .replace("G#", "g")
                .replace("A#", "a")
                .replace("B#", "b");
    }

    public int findPlayTime(String[] infos) {
        int startTime = Integer.parseInt(infos[0].split(":")[0]) * 60 + Integer.parseInt(infos[0].split(":")[1]);
        int endTime = Integer.parseInt(infos[1].split(":")[0]) * 60 + Integer.parseInt(infos[1].split(":")[1]);
        return endTime - startTime;
    }

    public String createMusicSheet(String musicSheet, int playTime) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < playTime; i++) {
            result.append(musicSheet.charAt(i % musicSheet.length()));
        }

        return result.toString();
    }

}
