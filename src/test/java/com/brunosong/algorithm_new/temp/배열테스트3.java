package com.brunosong.algorithm_new.temp;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class 배열테스트3 {


    @Test
    void test() {
        int[] arr = {0, 1, 2, 3, 4, 5};
        int[] query = {4, 1, 2};

        solution(arr,query);

        solution(10,3);

        solution("ProgrammerS123",11);

        solution("Progra21Sremm3",6,12);

        int[] arr2 = {0, 0, 0, 1};
        solution(arr2,1);

        String str = "cvsgiorszzzmrpaqpe";
        int[] index_list = {16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7};

        solution(str,index_list);
    }


    public int[] solution(int[] arr, int[] query) {
        int[] answer = {};

        for (int i = 0 ; i < query.length; i++) {
            int index = query[i];

            if(i % 2 == 0) {
                arr = Arrays.copyOf(arr, index + 1);
                System.out.println(Arrays.toString(arr));
            } else {
                arr = Arrays.copyOfRange(arr , index, arr.length);
                System.out.println(Arrays.toString(arr));
            }

        }

        return answer;
    }

    public int[] solution(int start, int end) {
        int[] answer = {};

        int[] ints = IntStream.rangeClosed(end, start).map(i -> end - i + start).toArray();

        System.out.println(Arrays.toString(ints));
        return answer;
    }

    public String solution(String my_string, int n) {
        // .. 아 총 길이에서 11을 빼니 5정도 되니깐 이게 최고다!!!
        return my_string.substring(my_string.length() - n);
    }


    public String solution(String my_string, int s, int e) {
        String answer = "";

        String substring = my_string.substring(s, e + 1);

        String prefix = my_string.substring(0,s);
        String postFix = my_string.substring(e + 1);

        System.out.println(prefix);
        System.out.println(postFix);

        System.out.println(prefix + new StringBuilder(substring).reverse() + postFix);

        return answer;
    }


    public int solution(int[] arr, int idx) {
        int answer = 0;

        for(int i = 0 ; i < arr.length; i++){
            if(idx <= i && arr[i] == 1) {
                return i;
            }
        }
        return -1;
    }


    public String solution(String my_string, int[] index_list) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < index_list.length; i++) {
            int i1 = index_list[i];

            String substring = my_string.substring(i1, i1 + 1);
            sb.append(substring);
        }


        return sb.toString();
    }

}
