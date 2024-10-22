package com.brunosong.algorithm_new.백준.스텍큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Editor editor = new Editor(str);

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]) {
                case "P" :
                    editor.P(command[1]);
                    break;
                case "L" :
                    editor.L();
                    break;
                case "D" :
                    editor.D();
                    break;
                case "B" :
                    editor.B();
                    break;
            }
        }
        br.close();

        editor.print();
    }

    public static class Editor {

        private int cursor = 0;
        private StringBuilder sb;

        public Editor(String str) {
            sb = new StringBuilder(str);
            cursor = str.length();
        }

        public void L() {
            if (cursor <= 0) return;
            cursor--;
        }

        public void P(String val) {
            if (sb.length() <= 600_000) {
                sb.insert(cursor, val);
                cursor += 1;
            }
        }

        public void D() {
            if (sb.length() <= cursor) return;
            cursor++;
        }

        public void B() {
            if (cursor <= 0) return;
            sb.delete(cursor-1,cursor);
            cursor--;
        }

        public void print() {
            System.out.println(sb);
        }
    }
}
