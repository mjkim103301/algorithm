package swea;

import java.io.*;
import java.util.*;

public class SWEA1949_등산로조성 {
    static int N, K;
    static int[][] map;
    static int answer;
    static int max;
    static boolean check;
    static int[][] dydx = {
            {0, 1},//우
            {0, -1},//좌
            {1, 0},//하
            {-1, 0},//상
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            N = Integer.parseInt(st.nextToken().trim());
            K = Integer.parseInt(st.nextToken().trim());
            map = new int[N][N];
            max = 0;
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int x = 0; x < N; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                    if (map[y][x] > max) {
                        max = map[y][x];
                    }
                }
            }
            answer = 0;
            solution();
            sb.append("#" + test + " " + answer + "\n");
        }
        System.out.print(sb);
    }

    static void solution() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (map[y][x] == max) {
                    int[][] mapcopy = new int[N][N];
                    boolean[][] visit = new boolean[N][N];
                    visit[y][x] = true;
                    copy(mapcopy);
                    check=false;
                    dfs(1, K, mapcopy, visit, y, x);
                }
            }
        }
    }

    static void dfs(int level, int dig, int[][] mapcopy, boolean[][] visit, int y, int x) {
        if (level < 1) return;
        if (dig < 0 || mapcopy[y][x] < 0) return;
        if (level > answer) {
            answer = level;
        }

        for (int i = 0; i < 4; i++) {
            int yy = y + dydx[i][0];
            int xx = x + dydx[i][1];
            if (yy < 0 || xx < 0 || yy >= N || xx >= N) continue;
            if (visit[yy][xx]) continue;

            int diff = mapcopy[y][x] - mapcopy[yy][xx];
            if (diff > 0) {
                visit[yy][xx] = true;
                dfs(level + 1, dig, mapcopy, visit, y + dydx[i][0], x + dydx[i][1]);
                visit[yy][xx] = false;
            } else if(!check){
                diff = Math.abs(diff) + 1;

                visit[yy][xx] = true;
                mapcopy[yy][xx] -= diff;
                check=true;
                dfs(level + 1, dig - diff, mapcopy, visit, y + dydx[i][0], x + dydx[i][1]);
                visit[yy][xx] = false;
                mapcopy[yy][xx] += diff;
                check=false;
            }
        }

    }

    static void copy(int copy[][]) {
        for (int y = 0; y < N; y++) {
            copy[y] = Arrays.copyOf(map[y], N);
        }
    }
}
