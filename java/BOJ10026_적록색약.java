package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ10026_적록색약 {
    static char[][] map;
    static int N;
    static boolean[][] visit;
    static int[] answer;
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] dydx = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        answer = new int[2];
        for (int y = 0; y < N; y++) {
            map[y] = br.readLine().toCharArray();
        }
        solution();
        for (int i = 0; i < 2; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    static void solution() {
        visit = new boolean[N][N];
        answer[0] = getAreaCnt(false);

        visit = new boolean[N][N];
        answer[1] = getAreaCnt(true);
    }

    static int getAreaCnt(boolean isColorWeakness) {
        int cnt = 0;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!visit[y][x]) {
                    char color = map[y][x];
                    bfs(color, isColorWeakness, y, x);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void bfs(char color, boolean isColorWeakness, int y, int x) {
        queue.add(new int[]{y, x});
        visit[y][x] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int yy = now[0] + dydx[i][0];
                int xx = now[1] + dydx[i][1];
                if (yy < 0 || yy >= N || xx < 0 || xx >= N || visit[yy][xx]) {
                    continue;
                }
                if (isColorWeakness) {
                    if ((color == 'R' || color == 'G') && map[yy][xx] == 'B') {
                        continue;
                    }
                    if (color == 'B' && color != map[yy][xx]) {
                        continue;
                    }
                }
                if (!isColorWeakness && color != map[yy][xx]) {
                    continue;
                }
                visit[yy][xx] = true;
                queue.add(new int[]{yy, xx});
            }
        }
    }
}
