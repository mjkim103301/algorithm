package swea;

import java.util.*;
import java.io.*;

public class SWEA1953_탈주범검거 {
    static int[][] map;
    static boolean[][] visited;
    static int N, M, R, C;
    static int L;
    static int[][] dydx = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1},
    };

    static String[][] structure = new String[8][4];

    static class Node {
        int y, x;
        int structure;
        int time;
        public Node(int y, int x, int structure, int time) {
            this.y = y;
            this.x = x;
            this.structure = structure;
            this.time=time;
        }
    }
    static Node[] queue;
    static int head,tail;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        init();

        int T=Integer.parseInt(br.readLine());
        for(int test=1;test<=T;test++){
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            R=Integer.parseInt(st.nextToken());
            C=Integer.parseInt(st.nextToken());
            L=Integer.parseInt(st.nextToken());

            queue=new Node[N*N];
            head=0;
            tail=0;

            map=new int[N][M];
            visited=new boolean[N][M];

            for(int y=0;y<N;y++){
                st=new StringTokenizer(br.readLine());
                for(int x=0;x<M;x++){
                    map[y][x]=Integer.parseInt(st.nextToken());
                }
            }

            solution();
            sb.append("#"+test+" "+tail+"\n");
        }
        System.out.print(sb);
    }

    static void init() {
        structure[1] = new String[]{
                "1,2,5,6",
                "1,3,6,7",
                "1,2,4,7",
                "1,3,4,5"
        };
        structure[2] = new String[]{
                "1,2,5,6",
                "",
                "1,2,4,7",
                ""
        };
        structure[3] = new String[]{
                "",
                "1,3,6,7",
                "",
                "1,3,4,5"
        };
        structure[4] = new String[]{
                "1,2,5,6",
                "1,3,6,7",
                "",
                ""
        };
        structure[5] = new String[]{
                "",
                "1,3,6,7",
                "1,2,4,7",
                ""
        };
        structure[6] = new String[]{
                "",
                "",
                "1,2,4,7",
                "1,3,4,5"
        };
        structure[7] = new String[]{
                "1,2,5,6",
                "",
                "",
                "1,3,4,5"
        };
    }

    static void solution(){
        bfs();
    }

    static void bfs(){
        queue[tail++]=new Node(R, C, map[R][C], 1);
        visited[R][C]=true;

        while(head!=tail){
            Node now=queue[head++];

            if(now.time==L) continue;
            
            for(int i=0;i<4;i++){
                int y=now.y+dydx[i][0];
                int x=now.x+dydx[i][1];

                if(y<0 || x<0|| y>=N || x>=M) continue;
                if(map[y][x]==0 || visited[y][x]) continue;

                if(structure[now.structure][i].contains(map[y][x]+"")){
                    visited[y][x]=true;
                    queue[tail++]=new Node(y, x, map[y][x], now.time+1);
                }
            }
        }
    }
}
