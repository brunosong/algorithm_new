package com.brunosong.algorithm_new.백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 주사위세개 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");

        Map<String,Integer> map = new HashMap<>();
        int result = 0;

        int max = -1;
        for (String n :nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            max = Math.max(max, Integer.parseInt(n));
        }

        if (map.size() == 3) {
            result = max * 100;
        } else if (map.size() == 2) {
            for (String key : map.keySet()) {
                if (map.get(key) == 2) {
                    result = 1000 + Integer.parseInt(key) * 100;
                }
            }
        } else  if (map.size() == 1) {
            for (String key : map.keySet()) {
                result = 10000 + Integer.parseInt(key) * 1000;
            }
        }

        System.out.println(result);
    }
}
