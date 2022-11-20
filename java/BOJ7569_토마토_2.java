package baekjoon.gold;

import java.util.*;
import java.io.*;
public class BOJ7569_토마토_2 {
    static int H,N,M;
    static int answer, unripenCnt;
    static int[][]dydx={
            {0,-1,0},
            {0,1,0},
            {0,0,1},
            {0,0,-1},
            {1,0,0},
            {-1,0,0}
    };
    static int[][][]map;
    static class Node{
        int h, y, x;
        int day;
        public Node(int h, int y, int x, int day){
            this.h=h;
            this.y=y;
            this.x=x;
            this.day=day;
        }
    }
    static Queue<Node> ripenList=new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());

        map=new int[H][N][M];
        for(int h=0;h<H;h++){
            for(int y=0;y<N;y++){
                st=new StringTokenizer(br.readLine());
                for(int x=0;x<M;x++){
                    map[h][y][x]=Integer.parseInt(st.nextToken());
                    if(map[h][y][x]==1){
                        ripenList.add(new Node(h, y, x, 0));
                    }else if( map[h][y][x]==0){
                        unripenCnt++;
                    }
                }
            }
        }
        solution();
        System.out.println(answer);
    }

    static void solution(){
        bfs();
        if(unripenCnt>0){
            answer=-1;
        }
    }

    static void bfs(){
        Node now;
        while(!ripenList.isEmpty()){
            now=ripenList.poll();
            for(int i=0;i<6;i++){
                int h=now.h+dydx[i][0];
                int y=now.y+dydx[i][1];
                int x=now.x+dydx[i][2];
                if(!canRipen(h, y, x)){
                    continue;
                }
                map[h][y][x]=1;
                ripenList.add(new Node(h, y, x, now.day+1));
                unripenCnt--;
                if(unripenCnt==0){
                    answer=now.day+1;
                    return;
                }
            }
        }
    }

    static boolean canRipen(int h, int y, int x){
        if(h<0||h>=H||y<0||y>=N||x<0||x>=M){
            return false;
        }
        if(map[h][y][x]!=0){
            return false;
        }
        return true;
    }
}
