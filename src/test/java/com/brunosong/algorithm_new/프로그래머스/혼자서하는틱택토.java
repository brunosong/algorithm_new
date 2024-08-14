package com.brunosong.algorithm_new.프로그래머스;

import org.junit.jupiter.api.Test;

public class 혼자서하는틱택토 {

    @Test
    void test() {

        String[] board1 = {"O.X", ".O.", "..X"};//	1
        String[] board2 = {"OOO", "...", "XXX"};//	0
        String[] board3 = {"...", ".X.", "..."};//	0
        String[] board4 = {"...", "...", "..."};//	1

        solution(board1);

    }

    public int solution(String[] board) {
        int answer = -1;

        if(!findOx(board)) return 0;





        return answer;
    }


    boolean findOx(String[] board) {
        int o = -1;
        int x = -1;

        for (int i = 0; i < board.length; i++) {
            if(board[i].indexOf("O") > -1){
                o = board[i].indexOf("O");
            } else if(board[i].indexOf("X") > -1){
                x = board[i].indexOf("X");
            }
        }

        if(o > -1) {
            return true;
        } else if (o == -1 && x > -1) {
            return false;
        }

        return false;

    }


}
