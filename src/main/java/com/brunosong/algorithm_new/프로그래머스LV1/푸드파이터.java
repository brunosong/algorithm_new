package com.brunosong.algorithm_new.프로그래머스LV1;

public class 푸드파이터 {

    public static void main(String[] args) {

//        food에는 칼로리가 적은 순서대로 음식의 양이 담겨 있습니다.
//        food[i]는 i번 음식의 수입니다.
//        food[0]은 수웅이가 준비한 물의 양이며, 항상 1입니다.

        // [1, 3, 4, 6]	 "1223330333221"
        // [1, 7, 1, 2]	 "111303111"

//        예를 들어, 3가지의 음식이 준비되어 있으며, 칼로리가 적은 순서대로 1번 음식을 3개, 2번 음식을 4개, 3번 음식을 6개 준비했으며, 물을 편의상 0번 음식이라고 칭한다면,
//        두 선수는 1번 음식 1개, 2번 음식 2개, 3번 음식 3개씩을 먹게 되므로 음식의 배치는 "1223330333221"이 됩니다. 따라서 1번 음식 1개는 대회에 사용하지 못합니다.

        int[] food = {1, 3, 4, 6};
        System.out.println(solution(food));


    }

    public static String solution(int[] food) {
        String answer = "";

        int zero = food[0];

        StringBuffer sb = new StringBuffer();

        for (int i = 1; i < food.length; i++) {

            int n = food[i] / 2;

            //if( food[i] % 2 == 0 ) {
            for (int j = 1; j <= n; j++) {
                sb.append(i);
            }
//            } else {
//
//            }
        }

        String s1 = sb.toString() + "0";
        String s2 = sb.reverse().toString();
        System.out.println(s1 + s2);

        return answer;
    }

}
