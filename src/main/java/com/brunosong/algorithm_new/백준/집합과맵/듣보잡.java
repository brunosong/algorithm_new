package com.brunosong.algorithm_new.백준.집합과맵;

import java.util.*;

public class 듣보잡 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String nm = sc.nextLine();

        String[] tmp = nm.split(" ");
        int N = Integer.parseInt(tmp[0]);
        long M = Long.parseLong(tmp[1]);

        TreeSet<String> set = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            String noListener = sc.nextLine();
            set.add(noListener);
        }

        String empty = sc.nextLine();

        Set<String> noSet = new HashSet<>();
        for (int i = 0; i < M; i++) {
            String noLooker = sc.nextLine();
            noSet.add(noLooker);
        }
        
        // 얘 때문에 런타임 발생가능성 높음
        set.retainAll(noSet);

        System.out.println(set.size());
        for (String name : set) {
            System.out.println(name);
        }
    }

    public static void solution1(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 듣도 못한 사람과 보도 못한 사람의 수 입력
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 듣도 못한 사람들을 저장할 Set
        Set<String> unheard = new HashSet<>();

        // 듣도 못한 사람들 입력
        for (int i = 0; i < N; i++) {
            unheard.add(sc.next());
        }

        // 듣보잡을 저장할 List
        List<String> unheardAndUnseen = new ArrayList<>();

        // 보도 못한 사람들을 입력하며 교집합 찾기
        for (int i = 0; i < M; i++) {
            String name = sc.next();
            // 보도 못한 사람 중 듣도 못한 사람과 중복되는 경우
            if (unheard.contains(name)) {
                unheardAndUnseen.add(name);
            }
        }

        // 사전순으로 정렬
        Collections.sort(unheardAndUnseen);

        // 듣보잡 수 출력
        System.out.println(unheardAndUnseen.size());

        // 듣보잡 명단 출력
        for (String name : unheardAndUnseen) {
            System.out.println(name);
        }
    }
}
