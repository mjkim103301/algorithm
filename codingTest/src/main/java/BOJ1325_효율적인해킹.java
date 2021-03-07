package ssafy.algo.study.week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1325_효율적인해킹 {

    static int N, M;
    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static int[]memo;
    static int max;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            map[i]= new ArrayList<>();
        }
        visited = new boolean[N + 1];
        memo=new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x =Integer.parseInt(st.nextToken());
            map[y].add(x);
        }
        solution();
        print();
    }

    static void print() {

       for(int y=1;y<=N;y++){
           if(max==memo[y]){
               System.out.print(y+" ");
           }
       }
    }

    static void solution() {

        for (int y = 1; y <= N; y++) {
            visited=new boolean[N+1];
            dfs(y);
        }
    }

    static void dfs(int y) {
        visited[y] = true;

        for(int next:map[y]) {
            if (visited[next]) continue;
            memo[next]++;
            max = Math.max(max, memo[next]);
            dfs(next);
        }

    }
}
