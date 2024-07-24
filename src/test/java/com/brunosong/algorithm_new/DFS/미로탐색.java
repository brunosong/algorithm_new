package com.brunosong.algorithm_new.DFS;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class 미로탐색 {
    /*
     7*7 격자판 미로를 탈출하는 경로의 가지수를 출력하는 프로그램을 작성하세요. 출발점은 격자의 (1, 1) 좌표이고,
     탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 통로이다. 격자판의 움직임은 상하좌우로만 움직인다.
    */

    // 시작 포지션
    int[] startPo = {0,0};

    // 도착 포지션
    int[] exitPo = {6,6};

    int answer = 0;

    @Test
    void test() {

        int[][] maze = {
            {0 ,0 ,0 ,0 ,0 ,0 ,0},
            {0 ,1 ,1 ,1 ,1 ,1 ,0},
            {0 ,0 ,0 ,1 ,0 ,0 ,0},
            {1 ,1 ,0 ,1 ,0 ,1 ,1},
            {1 ,1 ,0 ,0 ,0 ,0 ,1},
            {1 ,1 ,0 ,1 ,1 ,0 ,0},
            {1 ,0 ,0 ,0 ,0 ,0 ,0}
        };

        DFS(maze.length,0,0, maze);

        Assertions.assertThat(answer).isEqualTo(8);
    }


    void DFS(int mazeSize, int x, int y, int[][] maze) {

        //종료 시점 설정
        if(x == exitPo[0] && y == exitPo[1]) {
            answer++;
        } else {

            //방향설정 ( 0 : 위(행(x)이 하나가빠짐 , 1 : 오른쪽(열(컬럼)이 하나 증가) , 2 : 아래 (행이 증가), 3 : 왼쪽 )
            //여기서 중요한건 DFS를 어떻게 사용할 것이냐이다. 여기서는 방향을 계속해서 늘려나간다.
            int[] dx = {-1, 0,1, 0};
            int[] dy = { 0, 1,0,-1};

            for (int i = 0; i < 4; i++) {
                // 4방향중에 0인 곳부터 간다. 나는 0,1,2,3방향으로 진행한다.
                int nx = x + dx[i];  //다음 이동 포지션을 확인한다.
                int ny = y + dy[i];  //다음 이동 포지션을 확인한다.

                //다음 이동 포지션 벽인지와 1이 있는지 여부를 확인한다.
                if(nx >= mazeSize || nx < 0 || ny >= mazeSize || ny < 0 || maze[nx][ny] == 1 ) continue;

                //왔던 길로 되돌아가면 안되기 때문에 이전 포지션을 1로 바꿔준다.
                maze[x][y] = 1;

                //다음포지션으로 가기에 문제가 없는것을 확인했으니 다음 포지션으로 이동한다.
                DFS(mazeSize,nx,ny,maze);

                //마무리가 되었다면 스텍에 담겨있는 자신의 값을이용해서 1을 풀어준다.
                maze[x][y] = 0;

            }

        }

    }





}
