package baekjoon.level_gold;

import java.util.*;
import java.io.*;

public class BOJ21610_마법사상어와_비바라기 {
    static int[][]map;
    static int[][]dydx={
            {0,0},
            {0,-1},
            {-1,-1},
            {-1,0},
            {-1,1},
            {0,1},
            {1,1},
            {1,0},
            {1,-1},

    };
    static int N,M;
    static int d,s;
    static Queue<int[]> cloud=new ArrayDeque<>();
    static boolean[][]visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        map=new int[N][N];


        for(int y=0;y<N;y++){
            st=new StringTokenizer(br.readLine());
            for(int x=0;x<N;x++){
                map[y][x]=Integer.parseInt(st.nextToken());
            }
        }
        cloud.offer(new int[]{N-1,0});
        cloud.offer(new int[]{N-1,1});
        cloud.offer(new int[]{N-2,0});
        cloud.offer(new int[]{N-2,1});

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            d=Integer.parseInt(st.nextToken());
            s=Integer.parseInt(st.nextToken());
            solution();
        }

        System.out.println(getWater());
    }

    static void solution(){
        visit=new boolean[N][N];
        move();
        addWater();
        makeCloud();

    }

    static void move(){
        int size=cloud.size();
        for(int i=0;i<size;i++){
            int []now=cloud.poll();

            int y=now[0]+dydx[d][0]*(s%N);
            int x=now[1]+dydx[d][1]*(s%N);

            if(y<0){
                y+=N;
            }else if(y>=N){
                y-=N;
            }
            if(x<0){
                x+=N;
            }else if(x>=N){
                x-=N;
            }
            visit[y][x]=true;

            cloud.offer(new int[]{y,x});
        }

    }

    static void addWater(){
        while(!cloud.isEmpty()){
            int []now=cloud.poll();
            map[now[0]][now[1]]++;
        }

        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                if(!visit[y][x])continue;
                for(int i=2;i<=8;i+=2){
                    int r=y+dydx[i][0];
                    int c=x+dydx[i][1];
                    if(r<0||c<0||r>=N||c>=N)continue;
                    if(map[r][c]>0){
                        map[y][x]++;
                    }
                }

            }
        }
    }

    static void makeCloud(){
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                if(visit[y][x])continue;
                if(map[y][x]>=2){
                    cloud.offer(new int[]{y,x});
                    map[y][x]-=2;
                }
            }
        }
    }


    static int getWater(){
        int result=0;
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                result+=map[y][x];
            }
        }
        return result;
    }

}
