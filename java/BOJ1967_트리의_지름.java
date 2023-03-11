package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ1967_트리의_지름 {
    static int N;

    static class Node {
        int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static List<Node>[] tree;
    static boolean[] visit;
    static int max, maxNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            tree[from].add(new Node(to, cost));
            tree[to].add(new Node(from, cost));
        }
        solution();
        System.out.println(max);
    }

    static void solution() {
        visit = new boolean[N + 1];
        dfs(1, 0);
        max = 0;
        Arrays.fill(visit, false);
        dfs(maxNode, 0);
    }

    static void dfs(int from, int cost) {
        visit[from] = true;
        if (cost > max) {
            max = cost;
            maxNode = from;
        }
        for (Node next : tree[from]) {
            if (visit[next.to]) continue;
            dfs(next.to, cost + next.cost);
        }
    }
}
