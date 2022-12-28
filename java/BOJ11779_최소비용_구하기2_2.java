package baekjoon.gold;

import java.io.*;
import java.util.*;


//pq로 풀기
public class BOJ11779_최소비용_구하기2_2 {
    static int N, M;

    static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static List<Node>[] graph;
    static List<Integer> path = new ArrayList<>();
    static Map<Integer, Integer> linkedMap = new HashMap<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
    static int[] distance;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        distance = new int[N + 1];
        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, cost));
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
        pq.add(new Node(from, 0));

        while(!pq.isEmpty()){
            Node now=pq.poll();
            if(visit[now.to]){
                continue;
            }
            visit[now.to]=true;

            for(Node next: graph[now.to]){
                if(distance[now.to]+next.cost<distance[next.to]){
                    distance[next.to]=distance[now.to]+next.cost;
                    pq.add(new Node(next.to, distance[next.to]));
                    addMap(now.to, next.to);
                }
            }
        }
    }

    static void addMap(int from, int to) {
        linkedMap.put(to, from);
    }
}