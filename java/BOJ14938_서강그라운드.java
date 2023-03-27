package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ14938_서강그라운드 {
    static int N, R;
    static int[] items;
    static int[][] map;
    static int max;
    static int distanceLimit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        distanceLimit = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        items = new int[N + 1];
        map = new int[N + 1][N + 1];
        init();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            map[from][to] = distance;
            map[to][from] = distance;
        }
        solution();
        System.out.println(max);

    }

    static void init() {
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                if (y == x) continue;
                map[y][x] = Integer.MAX_VALUE;
            }
        }
    }

    static void solution() {
        floyd();
        for (int i = 1; i <= N; i++) {
            int itemCnt = getItem(i);
            max = Math.max(max, itemCnt);
        }
    }

    static void floyd() {
        for (int temp = 1; temp <= N; temp++) {
            for (int from = 1; from <= N; from++) {
                if (temp == from || map[from][temp] == Integer.MAX_VALUE) continue;
                for (int to = 1; to <= N; to++) {
                    if (temp == to || from == to || map[temp][to] == Integer.MAX_VALUE) continue;
                    if (map[from][to] > map[from][temp] + map[temp][to]) {
                        map[from][to] = map[from][temp] + map[temp][to];
                        map[to][from] = map[from][to];
                    }
                }
            }
        }
    }

    static int getItem(int start) {
        int item = 0;
        for (int i = 1; i <= N; i++) {
            if (map[start][i] <= distanceLimit) {
                item += items[i];
            }
        }
        return item;
    }

}
