package com.brunosong.algorithm_new.배열;

import java.util.ArrayList;
import java.util.List;

public class 최대길이연속부분수열 {

    /*
        최대 길이 연속부분수열
        0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다.
        여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.
        만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2 라면
        1 1 0 0 1 1 0 1 1 0 1 1 0 1
        여러분이 만들 수 있는 1이 연속된 연속부분수열은 1 1 0 0 1 1 1 1 1 1 1 1 0 1 이며 그 길이는 8입니다.

        ▣ 입력설명
        첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.
        두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.

        ▣ 출력설명
        첫 줄에 최대 길이를 출력하세요.

        ▣ 입력예제 1
        14 2
        1 1 0 0 1 1 0 1 1 0 1 1 0 1

        ▣ 출력예제 1
        8
    */


    public static void main(String[] args) {

        int[] arr = {1 ,1 ,0 ,0 ,1 ,1 ,0 ,1 ,1 ,0 ,1 ,1 ,0 ,1};
        int K = 2;

        solution2(arr,K);
    }

    public static int solution(int[] arr, int K) {

        int answer = 0;
        List<Integer> oneIndex = new ArrayList<>();

        //슬라이딩 윈도우로 풀면 될것 같다
        int lt = 0;
        int rt = 0;

        int max = 0;


        int cnt = 0;
        for ( ; rt < arr.length; rt++) {

            int num = arr[rt];

            if(num == 0) {

                if(cnt == K) {
                    //숫자를 센다???
                    System.out.println("rt" + rt);
                    System.out.println("숫자를 센다");
                    int checkCnt = 0;

                    for (int i = lt; i < rt; i++) {
                        if(arr[i] == 1) checkCnt++;
                        max  = Math.max(checkCnt,max);
                    }
                    lt++;

                    for (int idx : oneIndex) {
                        arr[idx] = 0;
                    }

                    oneIndex.clear();
                    cnt = 0;
                } else {
                    arr[rt] = 1;
                    cnt++;
                    oneIndex.add(rt); //인덱스를 넣어준다. 다시 돌려야 하기때문에
                }

            } else if(num == 1) {
                rt++;
            }




        }
        return answer;

    }


    public static int solution2(int[] arr, int K) {

        int answer = 0;
        int lt = 0;
        int cnt = 0;
        int max = 0;

        for (int rt = 0; rt < arr.length; rt++) {

            if(arr[rt] == 0) cnt++;

            while (cnt > K) {
                if(arr[lt] == 0) cnt--;
                lt++;
            }

            max = Math.max(max, (rt - lt) + 1);

        }

        System.out.println(max);

        return answer;

    }


}
