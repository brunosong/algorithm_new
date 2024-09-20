package com.brunosong.algorithm_new.백준.자료구조;

import java.util.*;

/*6
        6 4 2 1 3 5*/

public class 도키도키_간식드리미 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();

        String numStr = sc.nextLine();
        Integer[] array = Arrays.stream(numStr.split(" "))
                .map(Integer::parseInt).toArray(Integer[]::new);

        int nCnt = 1;
        for (int a : array) {
            queue.add(a);
        }

        String answer = "Nice";

        while (!queue.isEmpty()) {

            Integer current = queue.poll();

            if (current == nCnt) {
                nCnt++;
            } else if (current > nCnt) {
                stack.push(current);
            }

            while (!stack.isEmpty() && stack.peek() == nCnt) {
                nCnt++;
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            if (pop == nCnt) nCnt++;
            else {
                answer = "Sad";
                break;
            }
        }

        System.out.println(answer);
    }
}
