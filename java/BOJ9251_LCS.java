package baekjoon.gold;

import java.util.Scanner;

public class BOJ9251_LCS {
    static int[][] map;
    static String input1, input2;
    static int answer;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        input1 = scan.next();
        input2 = scan.next();
        solution();
        System.out.println(answer);
    }

    static void solution() {
        int length1 = input1.length();
        int length2 = input2.length();
        map = new int[length1 + 1][length2 + 1];
        for (int y = 1; y < length1 + 1; y++) {
            for (int x = 1; x < length2 + 1; x++) {
                if (input1.charAt(y - 1) == input2.charAt(x - 1)) {
                    map[y][x] = map[y - 1][x - 1] + 1;
                } else {
                    map[y][x] = Math.max(map[y][x - 1], map[y - 1][x]);
                }
            }
        }
        answer = map[length1][length2];
    }
}
