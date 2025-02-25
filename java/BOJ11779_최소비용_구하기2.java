package baekjoon.gold;

import java.io.*;
import java.util.*;

public class BOJ11779_최소비용_구하기2 {
    static int N, M;

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
    static List<Integer> path = new ArrayList<>();
    static Map<Integer, Integer> linkedMap = new HashMap<>();
    static long[] distance;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        distance = new long[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            lines.add(new Node(from, to, cost));
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        solution(from, to);
        System.out.println(sb);

    }


    static void solution(int from, int to) {
        linkedMap.put(from, 0);
        dijkstra(from);

        path.add(to);
        int next = linkedMap.get(to);
        while (next != 0) {
            path.add(next);
            next = linkedMap.get(next);
        }

        sb.append(distance[to]).append("\n");
        sb.append(path.size()).append("\n");
        for (int i = path.size() - 1; i >= 0; i--) {
            sb.append(path.get(i)).append(" ");
        }
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
            addMap(now.from, now.to);
        }
    }

    static void addMap(int from, int to) {
        linkedMap.put(to, from);
    }
}