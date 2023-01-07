package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ20437_문자열게임2 {
    static String W;
    static int K;
    static StringBuilder sb = new StringBuilder();
    static int[] alphabet;
    static int minLength, maxLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            W = br.readLine();
            K = Integer.parseInt(br.readLine());
            minLength = Integer.MAX_VALUE;
            maxLength = 0;
            solution();
            if (minLength == Integer.MAX_VALUE) {
                sb.append("-1").append("\n");
            } else {
                sb.append(minLength).append(" ").append(maxLength).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void solution() {
        for (int startIndex = 0; startIndex < W.length(); startIndex++) {
            alphabet = new int[26];
            for (int endIndex = startIndex; endIndex < W.length(); endIndex++) {
                int charIndex = W.charAt(endIndex) - 'a';
                int length = endIndex - startIndex + 1;
                alphabet[charIndex]++;
                if (alphabet[charIndex] == K) {
                    minLength = Math.min(minLength, length);
                    if (W.charAt(startIndex) == W.charAt(endIndex)) {
                        maxLength = Math.max(maxLength, length);
                        break;
                    }
                }
            }
        }
    }
}
