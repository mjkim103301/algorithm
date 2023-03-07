package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ1504_특정한_최단경로 {
    static int N, E;

    static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Dijkstra {
        int from;
        int to;

        public Dijkstra(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    static int v1, v2;
    static boolean[] visit;
    static List<Node>[] graph;
    static int[] distance;
    static PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new Node(to, cost));
            graph[to].add(new Node(from, cost));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
        solution();
        System.out.println(answer);
    }

    static void solution() {
        List<Dijkstra> list1 = new ArrayList<>();
        list1.add(new Dijkstra(1, v1));
        list1.add(new Dijkstra(v1, v2));
        list1.add(new Dijkstra(v2, N));

        List<Dijkstra> list2 = new ArrayList<>();
        list2.add(new Dijkstra(1, v2));
        list2.add(new Dijkstra(v2, v1));
        list2.add(new Dijkstra(v1, N));

        int list1Distance=0;
        for(Dijkstra item: list1){
            int distance = dijkstra(item.from, item.to);
            if(distance == Integer.MAX_VALUE){
                list1Distance=Integer.MAX_VALUE;
                break;
            }
            list1Distance+=distance;
        }
        int list2Distance=0;
        for(Dijkstra item: list2){
            int distance = dijkstra(item.from, item.to);
            if(distance == Integer.MAX_VALUE){
                list2Distance=Integer.MAX_VALUE;
                break;
            }
            list2Distance+=distance;
        }
        answer = Math.min(list1Distance, list2Distance);
        if(answer==Integer.MAX_VALUE){
            answer=-1;
        }
    }

    static int dijkstra(int from, int to) {
        visit = new boolean[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        pq.clear();
        doRun(from);
        return distance[to];
    }

    static void doRun(int from) {
        distance[from] = 0;
        pq.add(new Node(from, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visit[now.to]) continue;
            visit[now.to] = true;
            for (Node next : graph[now.to]) {
                if (distance[next.to] > distance[now.to] + next.cost) {
                    distance[next.to] = distance[now.to] + next.cost;
                    pq.add(new Node(next.to, distance[next.to]));
                }
            }
        }
    }
}