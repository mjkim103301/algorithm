package baekjoon.level_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 다익스트라, 인접리스트
public class BOJ18352_특정거리의도시찾기_2 {
    static class Node {
        int index, distance;

        public Node(int index, int path) {
            this.index = index;
            this.distance = path;
        }
    }

    static int N, M, K, X;
    static ArrayList<Integer>[] map;
    static ArrayList<Integer> answer = new ArrayList<>();
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시개수
        M = Integer.parseInt(st.nextToken()); // 도로개수
        K = Integer.parseInt(st.nextToken()); // 거리정보
        X = Integer.parseInt(st.nextToken()); // 출발도시 번호

        map = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            map[n1].add(n2);

        }
        solution();
    }

    static void solution() {
        int[] path = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        Arrays.fill(path, INF);
        path[X] = 0;
        PriorityQueue<Node> minHeap = new PriorityQueue<>((o1, o2) -> (o1.distance - o2.distance));
        minHeap.offer(new Node(X, 0));

        while (!minHeap.isEmpty()) {

            Node now = minHeap.poll();
            if (visit[now.index]) continue;
            visit[now.index] = true;

            if (now.distance == K) {
                answer.add(now.index);
                continue;
            }
            //path 갱신
            Iterator<Integer> iter = map[now.index].iterator();
            while (iter.hasNext()) {
                int index = iter.next();
                if (!visit[index] && path[index] > path[now.index] + 1) {
                    path[index] = path[now.index] + 1;
                    minHeap.offer(new Node(index, path[index]));
                }
            }
        }
        Collections.sort(answer);
        for (Integer ans : answer) {
            System.out.println(ans);
        }
        if (answer.size()==0) {
            System.out.print("-1");
        }
    }
}
