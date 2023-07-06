package com.brunosong.algorithm_new.프로그래머스LV1;

import java.util.Arrays;

public class 바탕화면정리 {

    public static void main(String[] args) {
        String[] arr =
//                        {".#...",
//                        "..#..",
//                        "...#."};
                //[0, 1, 3, 4]
       { "..........",
         ".....#....",
         "......##..",
         "...##.....",
         "....#....." };

        //[1, 3, 5, 8 ]


        solution(arr);
    }


    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        int x = 0;
        int y = -1;
        answer[1] = Integer.MAX_VALUE;


        //젤 위쪽을 구한다.
        for (int i = 0; i < wallpaper.length; i++) {
            x = wallpaper[i].indexOf("#");
            if( x > -1 ) {
                answer[0] = i;
                break;
            }
        }

        int down = -1;
        //젤 밑쪽을 구한다.
        for (int i = wallpaper.length - 1; i >= 0; i--) {
            down = wallpaper[i].lastIndexOf("#");
            if( down > -1 ) {
                answer[2] = i;
                break;
            }
        }
        answer[2] += 1;

        for (int i = 0; i < wallpaper.length; i++) {
            //젤 왼쪽에 있는 포지션이 시작포인트 ( , o ) 여기 위치다.
            y = wallpaper[i].indexOf("#");
            if(y > -1) {
                answer[1] = Math.min(answer[1] , y );
            }
        }

        y = -1;
        answer[3] = Integer.MIN_VALUE;
        //오른쪽 가장 큰것 () (, O ) 여기 위치다
        for (int i = 0; i < wallpaper.length; i++) {
            y = wallpaper[i].lastIndexOf("#");
            if(y > -1) {
                answer[3] = Math.max(answer[3] , y);
            }
        }
        answer[3] += 1;

        System.out.println(Arrays.toString(answer));


        return answer;
    }

}
