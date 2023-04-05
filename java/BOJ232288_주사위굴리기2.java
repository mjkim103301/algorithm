package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ232288_주사위굴리기2 {
    static int N, M, K;

    static class Dice {
        int y, x;
        int direct;
        int[][] item = {
                {0, 2, 0},
                {4, 1, 3},
                {0, 5, 0},
                {0, 6, 0},
        };

        public Dice() {
        }
    }

    static Dice dice;

    static int[][] map;
    static int score;

    static class Node {
        int y, x, level;

        public Node(int y, int x, int level) {
            this.y = y;
            this.x = x;
            this.level = level;
        }
    }

    static Queue<Node> queue = new LinkedList<>();
    static boolean[][] visit;
    static int[][] dydx = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        dice = new Dice();
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(score);
    }

    static void solution() {
        for (int i = 0; i < K; i++) {
            rollingDice();
            getScore();
            setDirection();
        }
    }

    static void rollingDice() {
        int y = dice.y + dydx[dice.direct][0];
        int x = dice.x + dydx[dice.direct][1];
        if (y < 0 || x < 0 || y >= N || x >= M) {
            dice.direct += 2;
            dice.direct %= 4;
            y = dice.y + dydx[dice.direct][0];
            x = dice.x + dydx[dice.direct][1];
        }
        dice.y=y;
        dice.x=x;
        int[][] item = new int[4][3];
        switch (dice.direct) {
            case 0: {
                item[0][1] = dice.item[0][1];
                item[1][0] = dice.item[3][1];
                item[1][1] = dice.item[1][0];
                item[1][2] = dice.item[1][1];
                item[2][1] = dice.item[2][1];
                item[3][1] = dice.item[1][2];
                break;
            }
            case 1: {
                item[0][1] = dice.item[3][1];
                item[1][0] = dice.item[1][0];
                item[1][1] = dice.item[0][1];
                item[1][2] = dice.item[1][2];
                item[2][1] = dice.item[1][1];
                item[3][1] = dice.item[2][1];
                break;
            }
            case 2: {
                item[0][1] = dice.item[0][1];
                item[1][0] = dice.item[1][1];
                item[1][1] = dice.item[1][2];
                item[1][2] = dice.item[3][1];
                item[2][1] = dice.item[2][1];
                item[3][1] = dice.item[1][0];
                break;
            }
            case 3: {
                item[0][1] = dice.item[1][1];
                item[1][0] = dice.item[1][0];
                item[1][1] = dice.item[2][1];
                item[1][2] = dice.item[1][2];
                item[2][1] = dice.item[3][1];
                item[3][1] = dice.item[0][1];
                break;
            }
            default:
                break;
        }
        dice.item = item;
    }

    static void getScore() {
        queue.clear();
        for (int y = 0; y < N; y++) {
            Arrays.fill(visit[y], false);
        }
        int value = map[dice.y][dice.x];
        visit[dice.y][dice.x] = true;
        int cnt = 1;
        queue.add(new Node(dice.y, dice.x, 1));
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int y = now.y + dydx[i][0];
                int x = now.x + dydx[i][1];
                if (y < 0 || x < 0 || y >= N || x >= M) continue;
                if (map[y][x] != value || visit[y][x]) continue;
                visit[y][x] = true;
                cnt ++;
                queue.add(new Node(y, x, now.level + 1));
            }
        }
        score += value * cnt;
    }

    static void setDirection() {
        int bottom = dice.item[3][1];
        int value = map[dice.y][dice.x];
        if (bottom > value) {
            dice.direct++;
            dice.direct %= 4;
        } else if (bottom < value) {
            dice.direct--;
            if (dice.direct < 0) {
                dice.direct = 3;
            }
        }
    }

}
