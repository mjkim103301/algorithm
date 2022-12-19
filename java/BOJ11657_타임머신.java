package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ11657_타임머신 {
    static int N, M;

    static class Node {
        int from, to, cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static List<Node> list = new ArrayList<>();
    static long[] distance;
    static boolean isInfinite, isRepeat;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        distance = new long[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Node(from, to, cost));
        }
        solution();
        StringBuilder sb = new StringBuilder();
        if (isInfinite) {
            sb.append("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    sb.append("-1");
                } else {
                    sb.append(distance[i]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static void solution() {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        for (int i = 1; i <= N; i++) {
            for (Node now : list) {
                bellmanFord(now);
            }
        }
        isRepeat = true;
        for (int i = 1; i <= N; i++) {
            for (Node now : list) {
                if (!bellmanFord(now)) {
                    isInfinite = true;
                    break;
                }
            }
        }


    }

    static boolean bellmanFord(Node now) {
        if (distance[now.from] == Integer.MAX_VALUE) {
            return true;
        }
        if (distance[now.from] + now.cost < distance[now.to]) {
            if (isRepeat) {
                return false;
            }
            distance[now.to] = distance[now.from] + now.cost;
        }
        return true;
    }
}
