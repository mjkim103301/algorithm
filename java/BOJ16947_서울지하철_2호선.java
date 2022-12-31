package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ16947_서울지하철_2호선 {
    static int N;
    static List<Integer>[] map;
    static Set<Integer> graph = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static boolean isLotation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int station1 = Integer.parseInt(st.nextToken());
            int station2 = Integer.parseInt(st.nextToken());
            map[station1].add(station2);
            map[station2].add(station1);
        }
        solution();
        System.out.print(sb);
    }

    static void solution() {
        setGraph();
        for (int station = 1; station <= N; station++) {
            bfs(station);
        }
    }

    static void setGraph() {
        boolean[] visit = new boolean[N + 1];
        dfs(0, 1, visit);
    }

    static void dfs(int prev, int now, boolean[] visit) {
        visit[now] = true;
        for (Integer next : map[now]) {
            if (prev == next) {
                continue;
            }
            if (!visit[next]) {
                dfs(now, next, visit);
                if (isLotation) {
                    if (graph.contains(next)) {
                        isLotation = false;
                    } else {
                        graph.add(next);
                    }
                    return;
                }
            } else {
                graph.add(next);
                isLotation = true;
                return;
            }
        }
    }

    static void bfs(int station) {
        if (graph.contains(station)) {
            sb.append("0 ");
            return;
        }

        boolean[] visit = new boolean[N + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{station, 0});
        visit[station] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (Integer next : map[now[0]]) {
                if (visit[next]) {
                    continue;
                }
                if (graph.contains(next)) {
                    sb.append(now[1] + 1).append(" ");
                    return;
                }
                visit[next] = true;
                queue.add(new int[]{next, now[1] + 1});
            }
        }

    }
}
