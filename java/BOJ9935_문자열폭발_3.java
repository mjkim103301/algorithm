package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9935_문자열폭발_3 {
    static String input, boom;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        boom = br.readLine();
        solution();
        if (answer.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(answer);
        }

    }

    static void solution() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            answer.append(ch);
            if (answer.length() >= boom.length()) {
                int start = answer.length() - boom.length();
                if (isContainsBoom(start)) {
                    answer.delete(start, start + boom.length());
                }
            }
        }
    }

    private static boolean isContainsBoom(int start) {
        for (int i = 0; i < boom.length(); i++) {
            if (answer.charAt(start + i) != boom.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
