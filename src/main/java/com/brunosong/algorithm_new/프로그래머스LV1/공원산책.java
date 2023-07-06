package com.brunosong.algorithm_new.프로그래머스LV1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 공원산책 {
    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/172928

    지나다니는 길을 O 장애물을 X 라고 하는 직사각형 격자 모양의 공원에서 로봇강아지가 산책을 하려고 합니다.
    산책은 로봇강아지가 미리 입력된 명령에 따 진행하며 , 명령은 다음과 같은 형식으로 진행됩니다.

    ["방향 거리", "방향 거리" … ]

    예를 들어 E 5 는 현제 위치에서 동쪽으로 5칸 이동했다는 의미 입니다.
    로봇강아지는 이동하기 전에 두가지의 확인을 실시합니다.
    - 주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
    - 주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
    두가지중 하나라도 해당되면 로봇강아지는 해당 명령을 무시하고 다음 명령을 수행합니다.

    공원의 가로 길이가 W, 세로 길이가 H라고 할 때, 공원의 좌측 상단의 좌표는 (0, 0), 우측 하단의 좌표는 (H - 1, W - 1) 입니다.

    입출력 예

    park	routes	result
    ["SOO","OOO","OOO"]	["E 2","S 2","W 1"]	[2,1]
    ["SOO","OXX","OOO"]	["E 2","S 2","W 1"]	[0,1]
    ["OSO","OOO","OXO","OOO"]	["E 2","S 3","W 1"]	[0,0]

    입출력 예 #1
    입력된 명령대로 동쪽으로 2칸, 남쪽으로 2칸, 서쪽으로 1칸 이동하면 [0,0] -> [0,2] -> [2,2] -> [2,1]이 됩니다.

    입출력 예 #2
    입력된 명령대로라면 동쪽으로 2칸, 남쪽으로 2칸, 서쪽으로 1칸 이동해야하지만 남쪽으로 2칸 이동할 때 장애물이 있는 칸을 지나기 때문에 해당 명령을 제외한 명령들만 따릅니다.
    결과적으로는 [0,0] -> [0,2] -> [0,1]이 됩니다.


     */

    public static void main(String[] args) {

        //String[] park = {"OOO", "OSO", "OOO", "OOO"};
        String[] park = {"OXO", "XSX", "OXO"};

        //String[] routes = {"E 5", "N 2", "S 2"}; //[3,1]
        String[] routes = { "S 1", "E 1", "W 1", "N 1"}; //[3,1]



        //System.out.println(Arrays.toString(solution(park,routes)));

        공원산책 aa = new 공원산책();
        System.out.println(Arrays.toString(aa.solution(park,routes)));

    }

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = {};

        int[] curPo = new int[2];

        //일단 현재위치부터 파악한다. (장애물 위치도 추가 파악)
        for (int i = 0; i < park.length; i++) {

            int s = park[i].indexOf("S");
            if(s > -1){
                curPo[0] = i;
                curPo[1] = s;
            }

        }

        //장애물 위치를 파악한다.
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < park.length; i++) {

            char[] chars = park[i].toCharArray();

            for (int j = 0; j < chars.length; j++) {
                if(chars[j] == 'X'){
                    int[] xPo = new int[2];
                    xPo[0] = i;
                    xPo[1] = j;
                    list.add(xPo);
                }
            }
        }


        //위치 이동
        for (int i = 0; i < routes.length; i++) {
            String route = routes[i];
            //가야할 방향을 구한다.
            String[] s = route.split(" ");

            String x = s[0]; //가야할 방향
            int mCnt = Integer.parseInt(s[1]); //가야할 숫자

            //현재위치에서 시작한다.
            if(x.equals("E")) { //오른쪽으로
//if (h + dh < 0 || park.length <= h + dh || w + dw < 0 || park[0].length() <= w + dw) return;
                if((curPo[1] + mCnt) < park[0].length() && !check(list,curPo,"E",mCnt)){
                    curPo[1] += mCnt;
                }

            } else if (x.equals("S")) {   //아래로
               // 이동 방향이 s일때 for문의 조건 범위의 끝이 저러면 이동하고 나서의 도착지점은 확인을 안하기 때문에 틀리게 되는거 같습니다. 간단하게 생각하면
               // y좌표 0인지점에서 s로 3칸을 이동하면 이동하고 난 후의 위치의 y좌표는 3이지만 확인하는 건 b<3이기 때문에 틀리게 됩니다.
                if((curPo[0] + mCnt) < park.length && !check(list,curPo,"S",mCnt)){
                    curPo[0] += mCnt;
                }

            } else if (x.equals("W")) {   //왼쪽으로

                if((curPo[1] - mCnt) >= 0 && !check(list,curPo,"W",mCnt) ){
                    curPo[1] -= mCnt;
                }

            } else if (x.equals("N")) {   //위로

                if((curPo[0] - mCnt) >= 0 && !check(list,curPo,"N",mCnt)){
                    curPo[0] -= mCnt;
                }

            }

        }
        //S: 현재위치
        return curPo;
    }


    public static boolean check(List<int[]> list , int[] curPo , String po, int moveCnt ) {

        // 지나 가는 위치에 있으면 true , 없으면 false
        for (int i = 0; i < list.size(); i++) {
            int[] xPo = list.get(i);

            int x = curPo[0];
            int y = curPo[1];

            int Xx = xPo[0];
            int Xy = xPo[1];

            if(po.equals("E")){
                if(x == Xx) {
                    //X는 일단 무조건 큰곳에 있어야 하고
                    //y에 도착지점이 X의 y지점보다 크거나 같으면 지나갈수 없기때문에 true
                    if(y < Xy && (y + moveCnt) >= Xy ){
                        return true;
                    }
                }
            } else if(po.equals("S")){
                if(y == Xy) { //y 지점이 같은곳에 존재하면
                    //x는 현재위치 보다 무조건 큰곳에 있어야 하고
                    //x포인트의 도착지점이 X의 지점보다 크거나 같으면 지나갈수 없어서 true
                    if(x < Xx && (x + moveCnt) >= Xx ){
                        return true;
                    }
                }
            } else if(po.equals("W")){
                if(x == Xx) {
                    //y 보다 X의 위치는 작아야 하고
                    //y포인트의 도착지점이 X의 지점보다 작거나 같으면 지나갈수 없어서 true
                    if(y > Xy && Xy >= (y - moveCnt)){
                        return true;
                    }
                }
            } else if(po.equals("N")){
                if(y == Xy) {
                    //이동할 x 좌표에 값이 있는지 확인한다. 값이 같거나 크면 걸린다는 얘기 ( 값이 작으면 가도 된다. )
                    if(x > Xx && Xx >= (x - moveCnt)){
                        return true;
                    }
                }
            }
        }
        return false;
    }


    private int[] curPos = new int[2];   // 현재 위치

    public int[] solution2(String[] park, String[] routes) {
        findStartingPoint(park);   // 출발점 찾기

        for (int i = 0; i < routes.length; i++) {
            char op = routes[i].charAt(0);   // 이동 방향
            int n = Character.getNumericValue(routes[i].charAt(2));   // 이동할 칸의 수

            int[] dh = {0, 0, 1, -1};   // 세로 변위
            int[] dw = {1, -1, 0, 0};   // 가로 변위

            // 방향에 따른 변위 설정
            int idx = 0;
            switch (op) {
                case 'E' : idx = 0;   // 동
                    break;
                case 'W' : idx = 1;   // 서
                    break;
                case 'S' : idx = 2;   // 남
                    break;
                case 'N' : idx = 3;   // 북
            }

            // 경로를 따라서 이동
            move(park, n, dh[idx], dw[idx]);
        }

        return curPos;
    }

    // 출발점 찾기
    private void findStartingPoint(String[] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    curPos[0] = i;   // 세로 좌표
                    curPos[1] = j;   // 가로 좌표
                    return;
                }
            }
        }
    }

    // 경로를 따라서 이동
    private void move(String[] park, int n, int dh, int dw) {
        int h = curPos[0], w = curPos[1];   // 현재 위치 (세로, 가로)
        // 경로 탐색
        for (int i = 1; i <= n; i++) {
            // 공원을 벗어나는 경우
            if (h + dh < 0 || park.length <= h + dh || w + dw < 0 || park[0].length() <= w + dw) return;
            // 장애물에 가로막히는 경우
            if (park[h + dh].charAt(w + dw) == 'X') return;

            h += dh;
            w += dw;
        }
        // 현재 위치 갱신
        curPos[0] = h;
        curPos[1] = w;
    }

}



