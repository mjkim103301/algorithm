package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ1916_최소비용_구하기 {
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
    static long distance[];

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
        solution(from);
        System.out.println(distance[to]);

    }

    static void solution(int from) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[from] = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                dijkstra(lines.get(j));
            }
        }
    }

    static void dijkstra(Node now) {
        if (distance[now.from] == Integer.MAX_VALUE) {
            return;
        }
        if (distance[now.from] + now.cost < distance[now.to]) {
            distance[now.to] = distance[now.from] + now.cost;
        }
    }
}
