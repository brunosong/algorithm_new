package com.brunosong.algorithm_new.프로그래머스LV1;

public class 대충만든자판 {
    public static void main(String[] args) {

        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};

        //["ABCD","AABB"]	[9, 4]
        solution(keymap,targets);
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < targets.length; i++) {

            int cnt = 0;

            String target = targets[i];
            char[] chars = target.toCharArray();
            boolean check = true;

            for (int j = 0; j < chars.length; j++) {


                int min = Integer.MAX_VALUE;
                for (int k = 0; k < keymap.length; k++) {
                    int findNum = keymap[k].indexOf(chars[j]);
                    if(findNum > -1){
                        min = Math.min(min,findNum);
                    }
                }

                if(min == Integer.MAX_VALUE) {
                    cnt = -1;
                    check = false;
                } else {
                    cnt += (min + 1);
                }
            }
            if(check) {
                answer[i] = cnt;
            } else {
                answer[i] = -1;
            }


        }

        return answer;

    }
}
