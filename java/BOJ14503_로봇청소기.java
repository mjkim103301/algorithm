package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ14503_로봇청소기 {
    static class Node {
        int y, x;
        int direction;

        public Node(int y, int x, int direction) {
            this.y = y;
            this.x = x;
            this.direction = direction;
        }
    }

    static int N, M, answer;
    static Node robot;
    static int[][] map;
    static int[][] dydx = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        robot = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
        System.out.println(answer);
    }

    static void solution() {
        while (true) {
            if (map[robot.y][robot.x] == 0) {
                map[robot.y][robot.x] = 2;
                answer++;
            }
            boolean canGo = false;
            for (int i = 0; i < 4; i++) {
                robot.direction--;
                if (robot.direction < 0) {
                    robot.direction = 3;
                }
                int y = robot.y + dydx[robot.direction][0];
                int x = robot.x + dydx[robot.direction][1];
                if (map[y][x] != 0) {
                    continue;
                }
                canGo = true;
                robot.y = y;
                robot.x = x;
                break;
            }
            if (!canGo) {
                int y = robot.y - dydx[robot.direction][0];
                int x = robot.x - dydx[robot.direction][1];
                if (map[y][x] == 1) {
                    return;
                }
                robot.y = y;
                robot.x = x;
            }
        }
    }
}
