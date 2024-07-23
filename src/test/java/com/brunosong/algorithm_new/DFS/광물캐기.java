package com.brunosong.algorithm_new.DFS;

import org.junit.jupiter.api.Test;

public class 광물캐기 {

    @Test
    void test() {
        int[] picks = {6, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

//        solution(picks,minerals);
        dfs2(picks,minerals,0, 0);

    }


//    public  int solution(int[] picks, String[] minerals) {
//
//        int[][] fatigue = {
//                {1, 1, 1},     // 다이아몬드 곡괭이
//                {5, 1, 1},     // 철 곡괭이
//                {25, 5, 1}     // 돌 곡괭이
//        };
//
//        return dfs(picks,minerals,0);
//    }

    //index에 사용용도는 minerals을 어디까지 때렸는지 알기 위한 용도로 사용되고, 미네랄을 다 깼을때의 용도로도 사용된다.
//    public int dfs(int[] picks, String[] minerals, int index, int[][] fatigue) {
//
//        //DFS는 항상 끝맺음을 해줘야한다.
//        if(index == minerals.length) {
//            return
//        }
//
//        //일단 최고 좋은 곡갱이부터 사용하도록 DFS를 짜보자
//        for (int i = 0; i < picks.length; i++) {
//            //여기에서 돌게되면 0번 곡갱이를 계속 사용하게 된다
//            picks[i]--;   //곡갱이 사용 횟수를 줄여준다.
//
//            int fatigueSum = 0;
//
//            //미네랄을 캐준다.1곡괭이당 5번을 캘수 있다.
//            for (int j = 0; j < 5; j++) {
//                switch (minerals[index + j]) {
//                    case "diamond":
//                        fatigueSum += fatigue[i][0];
//                        break;
//                    case "iron":
//                        fatigueSum += fatigue[i][1];
//                        break;
//                    case "stone":
//                        fatigueSum += fatigue[i][2];
//                        break;
//                }
//            }
//
//            dfs(picks,minerals,index + 5, fatigue);
//        }
//
//        return 1;
//    }


    public void dfs2(int[] picks, String[] minerals,int index, int currentFatigue) {

        if(index >= minerals.length) {
            System.out.println("총 피로도는 : " + currentFatigue);
        } else {

            //일단 최고 좋은 곡갱이부터 사용하도록 DFS를 짜보자
            for (int i = 0; i < picks.length; i++) {
                if(picks[i] > 0) {
                    //여기에서 돌게되면 0번 곡갱이를 계속 사용하게 된다
                    picks[i]--;   //곡갱이 사용 횟수를 줄여준다.

                    int fatigueSum = 0;

                    for (int j = 0; j < 5; j++) {
                        if(minerals.length <= index + j) break;
                        switch (minerals[index + j]) {
                            case "diamond":
                                fatigueSum += 1;
                                break;
                            case "iron":
                                fatigueSum += 2;
                                break;
                            case "stone":
                                fatigueSum += 3;
                                break;
                        }
                    }

                    System.out.println("picks 사용 : " + i );
                    System.out.println("피로도 : " + fatigueSum);
                    dfs2(picks,minerals,index + 5, currentFatigue + fatigueSum);
                }
            }

        }
    }



}
