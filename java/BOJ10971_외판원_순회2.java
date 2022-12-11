package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ10971_외판원_순회2 {
    static int N;
    static int[][] map;
    static boolean[] visit;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visit = new boolean[N];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(answer);
    }

    static void solution() {
        visit[0] = true;
        dfs(1, 0, 0);

    }

    static void dfs(int level, int location, int cost) {
        if (cost > answer) {
            return;
        }
        if (level == N) {
            if (map[location][0] > 0) {
                answer = Math.min(answer, cost + map[location][0]);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visit[i] || map[location][i] == 0) {
                continue;
            }
            visit[i] = true;
            dfs(level + 1, i, cost + map[location][i]);
            visit[i] = false;
        }
    }
}
