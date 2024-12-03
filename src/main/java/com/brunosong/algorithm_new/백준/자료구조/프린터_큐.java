package com.brunosong.algorithm_new.백준.자료구조;

import java.util.*;

public class 프린터_큐 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String[] po = sc.nextLine().split(" ");
            String[] nums = sc.nextLine().split(" ");

            int targetPosition = Integer.parseInt(po[1]);

            Queue<int[]> queue = new LinkedList<>();

            for (int j = 0; j < nums.length; j++) {
                int score = Integer.parseInt(nums[j]);
                queue.add(new int[]{j, score});
            }

            int printOrder = 0;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();

                boolean hasHigherPriority = false;
                for (int[] doc : queue) {
                    if (doc[1] > cur[1]) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                if (hasHigherPriority) {
                    queue.add(cur);
                } else {
                    printOrder++;
                    if (cur[0] == targetPosition) {
                        System.out.println(printOrder);
                        break;
                    }

                }
            }

        }

    }
}
