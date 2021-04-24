package baekjoon.level_gold;

import java.util.*;
import java.io.*;

public class BOJ19238_스타트택시 {
    static int N, M, oil;

    static class Node implements Comparable<Node> {
        int id;
        int startY, startX;
        int endY, endX;

        public Node(int id, int startY, int startX, int endY, int endX) {
            this.id = id;
            this.startY = startY;
            this.startX = startX;
            this.endY = endY;
            this.endX = endX;
        }

        @Override
        public int compareTo(Node o) {
            int diff = this.startY - o.startY;
            if (diff != 0) {
                return diff;
            }
            return this.startX - o.startX;
        }
    }

    static int[][] dydx = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
    };
    static Node[] passenger;
    static ArrayList<Node> possible=new ArrayList<>();
    static int taxiY, taxiX, distance;
    static int[][] map;
    static boolean[][] visit;
    static Queue<int[]> queue = new ArrayDeque<>();
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        oil = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visit = new boolean[N][N];
        passenger = new Node[M + 1]; // 배열 길이 실수함

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 1) {//벽은 -1로 바꾸기
                    map[y][x] = -1;
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        taxiY = Integer.parseInt(st.nextToken()) - 1;
        taxiX = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken()) - 1;
            int sx = Integer.parseInt(st.nextToken()) - 1;
            int ey = Integer.parseInt(st.nextToken()) - 1;
            int ex = Integer.parseInt(st.nextToken()) - 1;
            if(sy<0||sx<0||ey>=N||ex>=N)continue;
            passenger[i] = new Node(i, sy, sx, ey, ex);
            map[sy][sx] = i;
            cnt++;
        }
        System.out.println(solution() ? oil : -1);

    }

    static boolean solution() {
        if(cnt!=M){
            return false;
        }
        for (int i = 0; i < M; i++) {
            //가까운 손님찾기, 연료감소
            possible.clear();
            findPassenger();
            if(oil-distance<=0){
                return false;
            }else{
                oil-=distance;
            }
            //정렬
            if (possible.size() == 0) {
                return false;
            }
            Collections.sort(possible);

            //도착지 가기, 연료증가
            if (!goEnd(possible.get(0))) {
                return false;
            }

        }
        return true;
    }

    static void findPassenger() {
       distance = 0;

        if (map[taxiY][taxiX] > 0) {
            int id = map[taxiY][taxiX];
            possible.add(passenger[id]);
            return;
        }
        queue.clear();
        queue.offer(new int[]{taxiY, taxiX});
        visit = new boolean[N][N];
        visit[taxiY][taxiX]=true;
        while (!queue.isEmpty()) {
            if (possible.size() > 0) { // 종료조건 위치 실수함
                return;
            }
            int size = queue.size();
            distance++;

            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int y = now[0] + dydx[j][0];
                    int x = now[1] + dydx[j][1];
                    if (y < 0 || x < 0 || y >= N || x >= N) continue;
                    if (visit[y][x] || map[y][x] < 0) continue;
                    visit[y][x] = true;
                    if (map[y][x] > 0) {
                        int id = map[y][x];
                        possible.add(passenger[id]);
                    }
                    queue.offer(new int[]{y,x});
                }
            }
        }

    }

    static boolean goEnd(Node p) {
        distance = 0;
        queue.clear();
        queue.offer(new int[]{p.startY, p.startX});
        visit = new boolean[N][N];
        map[p.startY][p.startX]=0; // 초기화 실수함
        visit[p.startY][p.startX]=true; // 처음애들 방문처리 실수함
        while (!queue.isEmpty()) {
            int size=queue.size();
            distance++;
            if(distance>oil){
                return false;
            }
            for(int i=0;i<size;i++){
                int[] now = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int y = now[0] + dydx[j][0];
                    int x = now[1] + dydx[j][1];
                    if (y < 0 || x < 0 || y >= N || x >= N) continue;
                    if (visit[y][x] || map[y][x] < 0) continue;
                    visit[y][x] = true;
                    if (y==p.endY && x==p.endX) {
                        oil+=distance;
                        taxiY=y;
                        taxiX=x;
                        return true;
                    }
                    queue.offer(new int[]{y,x});
                }
            }
        }
        return false;
    }
}
