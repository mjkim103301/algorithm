package baekjoon.gold;

import java.io.*;
import java.util.*;

public class BOJ11779_최소비용_구하기2 {
    static int N, M;
    static int[][] map;

    static class Node {
        int from, to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static List<Node> lines = new ArrayList<>();
    static Deque<Integer> path = new ArrayDeque<>();
    static long[] distance;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        init();
        distance = new long[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            lines.add(new Node(from, to, cost));
            if (map[from][to] == -1) {
                map[from][to] = cost;
            } else {
                map[from][to] = Math.min(map[from][to], cost);
            }
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        solution(from, to);
        System.out.println(sb);

    }

    static void init() {
        for (int y = 0; y <= N; y++) {
            for (int x = 0; x <= N; x++) {
                map[y][x] = -1;
            }
        }
    }

    static void solution(int from, int to) {
        dijkstra(from);
        sb.append(distance[to]).append("\n");
        path.add(from);
        bfs(from, to);
    }

    static void dijkstra(int from) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[from] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                run(lines.get(j));
            }
        }
    }

    static void run(Node now) {
        if (distance[now.from] == Integer.MAX_VALUE) {
            return;
        }
        if (distance[now.from] + now.cost < distance[now.to]) {
            distance[now.to] = distance[now.from] + now.cost;
        }
    }

    static class BFS {
        int location;
        StringBuilder sb = new StringBuilder();

        public BFS(int location) {
            this.location = location;
        }
    }

    static void bfs(int from, int to) {
        Queue<BFS> queue = new LinkedList<>();
        queue.add(new BFS(from));
        boolean[] visit = new boolean[N + 1];
        visit[1] = true;
        while (queue.isEmpty()) {
            BFS now = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (map[now.location][i] < 0 || visit[i]) {
                    continue;
                }
                visit[i] = true;
                BFS next = new BFS(i);
                next.sb.append(i).append(" ");
                queue.add(next);
                visit[i] = false;
            }
        }

    }
}
