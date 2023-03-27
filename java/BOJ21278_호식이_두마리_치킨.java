package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ21278_호식이_두마리_치킨 {
    static int N, X;
    static int[][] map;
    static int[] chicken, candidate;
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        chicken = new int[2];
        candidate = new int[2];
        init();
        for (int i = 0; i < X; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            map[from][to] = 1;
            map[to][from] = 1;
        }
        solution();
        System.out.println(chicken[0] + " " + chicken[1] + " " + minDistance);
    }

    static void init() {
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                if (y == x) continue;
                map[y][x] = Integer.MAX_VALUE;
            }
        }

        Arrays.fill(chicken, Integer.MAX_VALUE);
    }


    static void solution() {
        floyd();
        setChicken(0, 1);
    }

    static void floyd() {
        for (int temp = 1; temp <= N; temp++) {
            for (int from = 1; from <= N; from++) {
                if (temp == from || map[from][temp] == Integer.MAX_VALUE) continue;
                for (int to = 1; to <= N; to++) {
                    if (temp == to || from == to) continue;
                    if (map[temp][to] == Integer.MAX_VALUE) continue;
                    if (map[from][temp] + map[temp][to] < map[from][to]) {
                        map[from][to] = map[from][temp] + map[temp][to];
                        map[to][from] = map[from][to];
                    }
                }
            }
        }
    }

    static void setChicken(int level, int start) {
        if (level == 2) {
            int distance = getDistance();
            if (needToChange(distance)) {
                chicken = Arrays.copyOf(candidate, 2);
                minDistance = distance;
            }
            return;
        }
        for (int i = start; i <= N; i++) {
            candidate[level] = i;
            setChicken(level + 1, i + 1);
        }
    }

    static int getDistance() {
        int distance = 0;
        for (int i = 1; i <= N; i++) {
            int dist = Math.min(map[i][candidate[0]], map[i][candidate[1]]);
            distance += dist * 2;
        }
        return distance;
    }

    static boolean needToChange(int distance) {
        if (distance < minDistance) {
            return true;
        } else if (distance > minDistance) {
            return false;
        }
        if (chicken[0] > candidate[0]) {
            return true;
        } else if (chicken[0] == candidate[0] && chicken[1] > candidate[1]) {
            return true;
        }
        return false;
    }
}
