package com.brunosong.algorithm_new.temp;

import org.junit.jupiter.api.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.*;

public class test2 {

//    정수 배열 numLog가 주어집니다. 처음에 numLog[0]에서 부터 시작해 "w", "a", "s", "d"로 이루어진 문자열을 입력으로 받아 순서대로 다음과 같은 조작을 했다고 합시다.
//
//"w" : 수에 1을 더한다.
//            "s" : 수에 1을 뺀다.
//            "d" : 수에 10을 더한다.
//            "a" : 수에 10을 뺀다.
//    그리고 매번 조작을 할 때마다 결괏값을 기록한 정수 배열이 numLog입니다. 즉, numLog[i]는 numLog[0]로부터 총 i번의 조작을 가한 결과가 저장되어 있습니다.
//
//    주어진 정수 배열 numLog에 대해 조작을 위해 입력받은 문자열을 return 하는 solution 함수를 완성해 주세요.

    @Test
    void test(){

        int[] numLog = {0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1};

        int s = numLog[0];

        StringBuffer sb = new StringBuffer();

        for (int i = 1; i < numLog.length; i++) {

            int i1 = numLog[i];
            if(i1 - s == 1)  sb.append("w");
            if(i1 - s == -1)  sb.append("s");
            if(i1 - s == 10)  sb.append("d");
            if(i1 - s == -10)  sb.append("a");

            s = numLog[i];
        }

        System.out.println(sb.toString());

        //"wsdawsdassw"

          int[] arr = {0, 1, 2, 4, 3};
          int[][] queries =  {{0, 4, 1},{0, 3, 2},{0, 3, 3}};

        System.out.println("출력 : " + Arrays.toString(solution3(arr,queries)));

    }

    public String solution(int[] numLog) {
        String answer = "";
        return answer;
    }


    public int[] solution2(int[] arr, int[][] queries) {

        int[] answer = new int[queries.length];

        for (int i = 0 ; i < queries.length ; i++) {

            int n = -1;

            int sRange = queries[i][0];
            int eRange = queries[i][1];
            int target = queries[i][2];

            List<Integer> temp = new ArrayList<>();

            for(int j = sRange; j <= eRange ; j++) {
                temp.add(arr[j]);
            }

            Collections.sort(temp);

            for(int ch : temp) {
                if(target < ch) {
                    n = ch;
                    break;
                }
            }

            answer[i] = n;

        }




        return answer;
    }


    public int[] solution3(int[] arr, int[][] queries) {

        int[] answer = Arrays.copyOf(arr,arr.length);

        for (int i = 0 ; i < queries.length ; i++) {

            int s = queries[i][0];
            int e = queries[i][1];
            int k = queries[i][2];

            for(int j = s; j <= e ; j++) {

                    if(j % k == 0) {
                        answer[j]++;
                    }

            }
        }

        System.out.println(Arrays.toString(arr));


        return answer;
    }



}
