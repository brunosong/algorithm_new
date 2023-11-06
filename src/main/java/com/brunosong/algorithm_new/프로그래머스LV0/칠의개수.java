package com.brunosong.algorithm_new.프로그래머스LV0;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 칠의개수 {

    @Test
    void 칠의개수(){

        int[] array = {7, 77, 17};

        System.out.println(
            solution(array)
        );

    }

    public int solution(int[] array) {
        return (int)Arrays.stream(
                        Arrays.stream(array)
                                .mapToObj(String::valueOf)
                                .collect(Collectors.joining())
                                .split("")
                ).filter( s -> s.equals("7"))
                .count();
    }
}
