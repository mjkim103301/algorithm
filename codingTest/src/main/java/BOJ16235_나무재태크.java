package baekjoon.level_gold;

import java.util.*;
import java.io.*;

public class BOJ16235_나무재태크 {
    static int N, M, K;
    static int[][] map;
    static int[][] A;
    static int answer;

    static class Node implements Comparable<Node> {
        int age;
        boolean alive;

        Node(int age, boolean alive) {
            this.age = age;
            this.alive = alive;
        }

        @Override
        public int compareTo(Node o) {
            return this.age - o.age;
        }
    }

    static ArrayList<Node>[][] tree;
    static int[][] dydx = {
            {0, 1},
            {1, 1},
            {1, 0},
            {1, -1},
            {0, -1},
            {-1, -1},
            {-1, 0},
            {-1, 1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parse(st.nextToken());
        M = parse(st.nextToken());
        K = parse(st.nextToken());
        map = new int[N][N];
        A = new int[N][N];
        tree = new ArrayList[N][N];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                map[y][x] = 5;
                tree[y][x] = new ArrayList<>();
            }
        }

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                A[y][x] = parse(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = parse(st.nextToken()) - 1;
            int x = parse(st.nextToken()) - 1;
            int age = parse(st.nextToken());
            tree[y][x].add(new Node(age, true));
        }
        solution();
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                answer += tree[y][x].size();
            }
        }
        System.out.println(answer);
    }

    static int parse(String s) {
        return Integer.parseInt(s);
    }

    static void solution() {
        for (int i = 0; i < K; i++) {
            spring();
            summer();
            fall();
            winter();
        }
    }

    static void spring() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                for (int i = 0, end = tree[y][x].size(); i < end; i++) {
                    if (map[y][x] - tree[y][x].get(i).age >= 0) {
                        map[y][x] -= tree[y][x].get(i).age;
                        tree[y][x].get(i).age++;
                    } else {
                        tree[y][x].get(i).alive = false;
                    }
                }
            }
        }
    }

    static void summer() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                for (int i = 0, end = tree[y][x].size(); i < end; i++) {
                    if(!tree[y][x].get(i).alive){
                        int add=tree[y][x].get(i).age/2;
                        map[y][x]+=add;
                    }
                }
                tree[y][x].removeIf(o->(o.alive==false));
            }
        }
    }

    static void fall() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                for (int i = 0, end = tree[y][x].size(); i < end; i++) {
                    if(tree[y][x].get(i).age%5==0){
                        addChild(y,x);
                    }
                }
            }
        }
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                Collections.sort(tree[y][x]);
            }
        }
    }

    static void addChild(int y, int x){
        for(int i=0;i<8;i++){
            int r=y+dydx[i][0];
            int c=x+dydx[i][1];
            if(r<0||c<0||r>=N||c>=N)continue;
            tree[r][c].add(new Node(1,true));
        }
    }
    static void winter() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                map[y][x]+=A[y][x];
            }
        }
    }
}
