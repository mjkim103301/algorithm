package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ21609_상어중학교 {
    static int N, M;
    static int[][] map;

    static class Node {
        int y, x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static boolean[][] visitBasic, visitQueue;
    static int score;
    static List<Node> blockGroup = new ArrayList<>();
    static int black = -1;
    static int rainbow = 0;
    static int blockGroupRainbow, queueRainbow;
    static Queue<Node> queue = new LinkedList<>();
    static int[][] dydx = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visitBasic = new boolean[N][N];
        visitQueue = new boolean[N][N];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(score);
    }

    static void solution() {
        while (true) {
            findBlockGroup();
            if (blockGroup.size() == 0) {
                return;
            }
            deleteBlockGroupAndGetScore();
            gravity();
            rotation();
            gravity();

            for (int y = 0; y < N; y++) {
                Arrays.fill(visitBasic[y], false);
            }
        }
    }

    static void findBlockGroup() {

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] <= 0 || visitBasic[y][x]) continue;
                int cnt = bfs(y, x);
                if (cnt > blockGroup.size() && isBlockGroup(cnt)) {
                    changeBlockGroup();
                } else if (cnt == blockGroup.size() && blockGroupRainbow < queueRainbow && isBlockGroup(cnt)) {
                    changeBlockGroup();
                }
            }
        }
    }

    static int bfs(int startY, int startX) {
        queue.clear();
        for (int y = 0; y < N; y++) {
            Arrays.fill(visitQueue[y], false);
        }
        int cnt = 0;
        queueRainbow = 0;
        visitBasic[startY][startX] = true;
        visitQueue[startY][startX] = true;
        int target = map[startY][startX];

        queue.add(new Node(startY, startX));
        cnt++;
        queueRainbow++;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int y = now.y + dydx[i][0];
                int x = now.x + dydx[i][1];
                if (y < 0 || x < 0 || y >= N || x >= N) continue;
                if (visitQueue[y][x] || map[y][x] == -2 || map[y][x] == black) continue;
                if (map[y][x] != rainbow && map[y][x] != target) continue;
                visitQueue[y][x] = true;
                if (map[y][x] > 0) {
                    visitBasic[y][x] = true;
                }
                if (map[y][x] == rainbow) {
                    queueRainbow++;
                }
                cnt++;
                queue.add(new Node(y, x));
            }

        }
        return cnt;
    }

    static void changeBlockGroup() {
        blockGroup.clear();
        blockGroupRainbow=0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (visitQueue[y][x]) {
                    blockGroup.add(new Node(y, x));
                    if(map[y][x]==0) blockGroupRainbow++;
                }
            }
        }
    }

    static boolean isBlockGroup(int cnt) {
        if (cnt >= 2) {
            return true;
        }
        return false;
    }

    static void deleteBlockGroupAndGetScore() {
        score += Math.pow(blockGroup.size(), 2);
        for (Node node : blockGroup) {
            map[node.y][node.x] = -2;
        }
        blockGroup.clear();
    }

    static void gravity() {
        for (int x = 0; x < N; x++) {
            int jump = 0;
            for (int y = N-1; y >=0; y--) {
                if (map[y][x] == -2) {
                    jump++;
                } else if (map[y][x] == black) {
                    jump = 0;
                } else if(jump >0) {
                    map[y + jump][x] = map[y][x];
                    map[y][x] = -2;
                }
            }
        }
    }

    static void rotation() {
        int[][] newMap = new int[N][N];
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                newMap[y][x] = map[x][N - 1 - y];
            }
        }

        for (int y = 0; y < N; y++) {
            map[y] = Arrays.copyOf(newMap[y], N);
        }
    }
}
