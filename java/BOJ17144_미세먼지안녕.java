package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ17144_미세먼지안녕 {
    static int R, C, T;
    static int[][] map, spreadMap;
    static int sum;

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static List<Node> robot = new ArrayList<>();
    static int[][] dydx = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        spreadMap = new int[R][C];

        for (int y = 0; y < R; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < C; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == -1) {
                    robot.add(new Node(y, x));
                }
            }
        }
        solution();
        System.out.println(sum);
    }

    static void solution() {
        for (int time = 1; time <= T; time++) {
            spread();
            clean();
            copy();
        }
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (map[y][x] == -1) continue;
                sum += map[y][x];
            }
        }
    }

    static void spread() {
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (map[y][x] < 5) {
                    spreadMap[y][x] += map[y][x];
                    continue;
                }
                int dust = map[y][x] / 5;
                int cnt = 0;
                for (int i = 0; i < 4; i++) {
                    int ny = y + dydx[i][0];
                    int nx = x + dydx[i][1];

                    if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == -1) continue;
                    cnt++;
                    spreadMap[ny][nx] += dust;
                }
                spreadMap[y][x] += map[y][x] - (dust * cnt);
            }
        }
    }

    static void clean() {
        Node robot1 = robot.get(0);

        for (int y = robot1.y - 1; y > 0; y--) {
            spreadMap[y][0] = spreadMap[y - 1][0];
        }
        for (int x = 0; x < C - 1; x++) {
            spreadMap[0][x] = spreadMap[0][x + 1];
        }
        for (int y = 0; y < robot1.y; y++) {
            spreadMap[y][C - 1] = spreadMap[y + 1][C - 1];
        }
        for (int x = C - 1; x > 1; x--) {
            spreadMap[robot1.y][x] = spreadMap[robot1.y][x - 1];
        }
        spreadMap[robot1.y][robot1.x + 1] = 0;

        Node robot2 = robot.get(1);
        for (int y = robot2.y + 1; y < R - 1; y++) {
            spreadMap[y][0] = spreadMap[y + 1][0];
        }
        for (int x = 0; x < C - 1; x++) {
            spreadMap[R - 1][x] = spreadMap[R - 1][x + 1];
        }
        for (int y = R - 1; y > robot2.y; y--) {
            spreadMap[y][C - 1] = spreadMap[y - 1][C - 1];
        }
        for (int x = C - 1; x > 1; x--) {
            spreadMap[robot2.y][x] = spreadMap[robot2.y][x - 1];
        }
        spreadMap[robot2.y][robot2.x + 1] = 0;
    }

    static void copy() {
        for (int y = 0; y < R; y++) {
            map[y] = Arrays.copyOf(spreadMap[y], C);
            Arrays.fill(spreadMap[y], 0);
        }
    }
}




