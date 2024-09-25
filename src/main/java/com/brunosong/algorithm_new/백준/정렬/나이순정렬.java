package com.brunosong.algorithm_new.백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<User> users = new PriorityQueue<>((u1,u2) -> {
            if (u1.age == u2.age) {
                return u1.num - u2.num;
            }
            return u1.age - u2.age;
        });

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            String[] user = str.split(" ");

            users.add(new User(Integer.parseInt(user[0]),user[1],i));
        }

        while (!users.isEmpty()) {
            User poll = users.poll();
            System.out.println(poll.age + " " + poll.name);
        }
    }

    public static class User {
        int age;
        String name;
        int num;

        public User(int age, String name, int num) {
            this.age = age;
            this.name = name;
            this.num = num;
        }
    }
}
