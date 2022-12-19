package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ10164_격자상의_경로 {
    static int N, M, K;
    static int map[][];
    static boolean[] visit;
    static long answer;
    static int[][] dydx = {
            {1, 0},
            {0, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N * M + 1];
        int location = 1;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                map[y][x] = location++;
            }
        }
        solution();
        System.out.println(answer);
    }

    static void solution() {
        visit[0] = true;
        visit[1] = true;
        dfs(0, 0, 1);
    }

    static void dfs(int y, int x, int location) {
        if (y == N-1 && x == M-1) {
            if (visit[K]) {
                answer++;
            }
            return;
        }
        if (location >= K && !visit[K]) {
            return;
        }

        for(int i=0;i<2;i++){
            int yy=y+dydx[i][0];
            int xx=x+dydx[i][1];
            if(yy>=N ||xx>=M)continue;
            int loc=map[yy][xx];
            if(visit[loc]){
                continue;
            }
            visit[loc]=true;
            dfs(yy, xx, loc);
            visit[loc]=false;
        }
    }
}
