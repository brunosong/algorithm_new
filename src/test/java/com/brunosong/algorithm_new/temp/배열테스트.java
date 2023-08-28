package com.brunosong.algorithm_new.temp;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class 배열테스트 {

    @Test
    void test(){
        int l = 5;
        int r = 555;
        //System.out.println(Arrays.toString(solution(l,r)));

        solution3(10);

        solution("hello",3);
    }

    public int[] solution(int l, int r) {
        int[] answer = {};

        String v1 = String.valueOf(l);
        String v2 = "0";

        Pattern pattern = Pattern.compile("^[05]+$");

        List<Integer> list = new ArrayList<>();

        boolean check = false;

        for (int i = l; i <= r; i++) {

            String s = String.valueOf(i);
            Matcher matcher = pattern.matcher(s);

            if (matcher.find()) {
                check = true;
                list.add(Integer.parseInt(s));
            }
        }

        if(!check) return new int[]{-1};

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }


    public int[] solution2(int start, int end) {
        int[] answer = {};

        int[] ints = IntStream.rangeClosed(start, end)
                .toArray();


        return answer;
    }

    /* 콜라츠 수열 */
    public int[] solution3(int n) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();
        list.add(n);

        while ( n != 1 ){
            //짝수는 나누고
            if( n % 2 == 0 ) {
                n = n / 2;
            } else {
                //홀수는 3 * x + 1
                n = 3 * n + 1;
            }
            list.add(n);
        }

        System.out.println(list);

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }



    public int[] solution4(int n, int k) {
        int[] answer = {};

        List<Integer> list = new ArrayList<>();

        for (int i = 1 ; i <= n ; i++) {

            if( n % k == 0 ) {
                list.add(n);
            }

        }

        return list.stream().mapToInt(Integer::valueOf).toArray();
    }


    public String solution(String my_string, int n) {
        String answer = "";

        char[] chars = my_string.toCharArray();

        StringBuilder sb = new StringBuilder();

        for(char c : chars) {
            for (int i = 0; i < n; i++) {
                sb.append(c);
            }
        }

        return answer;
    }
}
