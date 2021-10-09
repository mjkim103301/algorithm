package baekjoon.level_gold;

import java.util.*;
import java.io.*;
public class BOJ1937_욕심쟁이판다 {
    static int N;
    static int[][]map, memo;
    static int moveMax;
    static int [][]dydx={
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };
    static int startY, startX;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        memo=new int[N][N];
        for(int y=0;y<N;y++){
            st=new StringTokenizer(br.readLine());
            for(int x=0;x<N;x++){
                map[y][x]=Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(moveMax);
    }

    static void solution(){
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
               moveMax=Math.max(moveMax, eatTrees(y,x));
            }
        }
        //printMemo();
    }


    static int eatTrees(int y, int x){
        if(memo[y][x]>0){
            return memo[y][x];
        }
        memo[y][x]=1;

        for(int i=0;i<4;i++){
            int yy=y+dydx[i][0];
            int xx=x+dydx[i][1];
            if(yy<0||xx<0||yy>=N||xx>=N) continue;

            //저번에 먹었던것보다 대나무 수가 많으면
            if(map[yy][xx]>map[y][x]){
                memo[y][x]=Math.max(memo[y][x], eatTrees(yy,xx)+1);
            }
        }
        return memo[y][x];
    }

    static void printMemo(){
        System.out.println("==========memo======");
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                System.out.print(memo[y][x]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
