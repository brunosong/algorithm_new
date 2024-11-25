package com.brunosong.algorithm_new.백준.정렬;

import java.util.*;

public class 신입사원 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 테스트 케이스 개수
        sc.nextLine();

        List<List<Applicant>> applicants = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Applicant> list = new ArrayList<>();
            int p = sc.nextInt(); // 지원자 수
            sc.nextLine();

            for (int j = 0; j < p; j++) {
                String[] s = sc.nextLine().split(" ");
                int schoolRecord = Integer.parseInt(s[0]);
                int interviewScore = Integer.parseInt(s[1]);
                list.add(new Applicant(schoolRecord, interviewScore));
            }

            // 지원자를 schoolRecord 기준으로 오름차순 정렬
            Collections.sort(list);
            applicants.add(list);
        }

        for (List<Applicant> list : applicants) {
            int cnt = 0; // 채용 가능한 인원 수
            int minInterviewScore = Integer.MAX_VALUE; // 면접 점수의 최소값을 추적

            for (Applicant applicant : list) {
                // 면접 점수가 더 낮아야 합격 가능
                if (applicant.interviewScore < minInterviewScore) {
                    cnt++;
                    minInterviewScore = applicant.interviewScore;
                }
            }
            System.out.println(cnt);
        }
    }

    public static class Applicant implements Comparable<Applicant> {

        public int schoolRecord;    // 학력 점수
        public int interviewScore; // 면접 점수

        public Applicant(int schoolRecord, int interviewScore) {
            this.schoolRecord = schoolRecord;
            this.interviewScore = interviewScore;
        }

        @Override
        public int compareTo(Applicant o) {
            return this.schoolRecord - o.schoolRecord; // 학력 점수 오름차순 정렬
        }
    }

}
