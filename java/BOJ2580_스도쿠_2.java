package baekjoon.gold;

import java.util.*;
import java.io.*;

// 시간절약, 공간절약, 코드 길이 줄임
public class BOJ2580_스도쿠_2 {
    static int[][] map;

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static List<Node> holes = new ArrayList<>();
    static boolean finish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        map = new int[9][9];
        for (int y = 0; y < 9; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < 9; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 0) {
                    holes.add(new Node(y, x));
                }
            }
        }
        solution(0);
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                sb.append(map[y][x]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void solution(int level) {
        if (level == holes.size()) {
            finish = true;
            return;
        }
        Node now = holes.get(level);

        for (int i = 1; i < 10; i++) {
            if (row(i, now) && column(i, now) && square(i, now)) {
                map[now.y][now.x] = i;
                solution(level + 1);

                if (finish) {
                    return;
                }
                map[now.y][now.x] = 0;
            }
        }
    }

    static boolean row(int candidate, Node now) {
        for (int i = 0; i < 9; i++) {
            if (map[now.y][i] == 0) continue;
            if (map[now.y][i]==candidate) {
                return false;
            }
        }
        return true;
    }

    static boolean column(int candidate, Node now) {
        for (int i = 0; i < 9; i++) {
            if (map[i][now.x] == 0) continue;
            if (map[i][now.x]==candidate) {
                return false;
            }
        }
        return true;
    }

    static boolean square(int candidate, Node now) {
        int minY = now.y / 3 * 3;
        int minX = now.x / 3 * 3;

        for (int y = minY; y < minY + 3; y++) {
            for (int x = minX; x < minX + 3; x++) {
                if (map[y][x] == 0) continue;
                if (map[y][x]==candidate) {
                    return false;
                }
            }
        }
        return true;
    }
}