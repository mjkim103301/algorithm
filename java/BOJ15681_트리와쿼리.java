package bundang.algo.study.week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15681_트리와쿼리 {
    static int N, R, Q;
    static List<Integer>[] tree;
    static int[] dp;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        tree = new List[N + 1];
        dp = new int[N + 1];
        visit = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            tree[parent].add(child);
            tree[child].add(parent);
        }

        solution();
        for (int i = 0; i < Q; i++) {
            sb.append(dp[Integer.parseInt(br.readLine())] + "\n");
        }
        System.out.println(sb);

    }

    static void solution() {
        Arrays.fill(dp, 1);
        visit[R] = true;
        dfs(R);
    }

    static void dfs(int parent) {
        for (int i = 0; i < tree[parent].size(); i++) {
            int child = tree[parent].get(i);
            if (visit[child]) continue;
            visit[child] = true;
            dfs(child);
            dp[parent] += dp[child];
        }
    }
}
