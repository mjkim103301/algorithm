package baekjoon.level_gold;

import java.util.*;
import java.io.*;

public class BOJ19237_어른상어 {
    static int N,M,K;
    static class Node{
        int num;
        int scent;
        boolean isIn;
        public Node(){}
        public Node(int num, int scent, boolean isIn){
            this.num=num;
            this.scent=scent;
            this.isIn=isIn;
        }
        public void print(){
            System.out.print(" { " +num+" "+scent+ " "+isIn+" } ");
        }
    }
    static Node[][]map, temp;
    static int[]shark;
    static int[][][] direct;
    static int alive, answer, time;
    static int[][]move= {
            {},
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1},
    };
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        map=new Node[N][N];
        temp=new Node[N][N];
        shark=new int[M+1];
        direct=new int[M+1][5][4];
        alive=M;

        init();
        for(int y=0;y<N;y++){
            st=new StringTokenizer(br.readLine());
            for(int x=0;x<N;x++){
                int num=Integer.parseInt(st.nextToken());
                if(num>0){
                    map[y][x]=new Node(num, K, true);
                }
            }
        }

        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=M;i++){
            shark[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=M;i++){
            for(int j=1;j<=4;j++){
                st=new StringTokenizer(br.readLine());
                for(int k=0;k<4;k++){
                    direct[i][j][k]=Integer.parseInt(st.nextToken());
                }
            }
        }

        solution();
        System.out.println(answer);
    }

    static void init(){
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                map[y][x]=new Node();
                temp[y][x]=new Node();
            }
        }
    }
    static void solution(){
        while(time<1000){
            time++;
            run();
            if(alive<=1){
                answer=time;
                return;
            }
        }
        answer=-1;
    }

    static void run(){
        moveShark();
        tempToMap();
        decrease();
    }
    static void moveShark(){
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                Node now=map[y][x];
                if(now.isIn){
                    boolean check=false;
                    //아무 냄새도 없는 칸인지
                   for(int i=0;i<4;i++){
                       int d=direct[now.num][shark[now.num]][i];
                       int yy=y+move[d][0];
                       int xx=x+move[d][1];
                       if(yy<0 ||yy>=N ||xx<0 || xx>=N) continue;
                       if(map[yy][xx].scent==0){
                           if(temp[yy][xx].isIn && temp[yy][xx].num!=now.num){
                               alive--;
                           }
                           if(!temp[yy][xx].isIn || temp[yy][xx].num>now.num){
                               temp[yy][xx]=new Node(now.num, now.scent, true);
                               shark[now.num]=d;
                               map[y][x].isIn=false;
                           }

                           map[y][x].isIn=false;
                           check=true;
                           break;
                       }
                   }

                   if(!check) {
                       // 내 냄새가 있는 칸인지
                       for (int i = 0; i < 4; i++) {
                           int d = direct[now.num][shark[now.num]][i];
                           int yy = y + move[d][0];
                           int xx = x + move[d][1];
                           if (yy < 0 || yy >= N || xx < 0 || xx >= N) continue;
                           if (map[yy][xx].num == now.num) {
                               temp[yy][xx] = new Node(now.num, now.scent, true);
                               shark[now.num] = d;
                               map[y][x].isIn=false;
                               break;
                           }
                       }
                   }

                }
            }
        }
    }
    static void tempToMap(){
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                Node now=temp[y][x];
                if(now.isIn){
                    map[y][x]=new Node(now.num, now.scent, now.isIn);
                    temp[y][x]=new Node();
                }
            }
        }
    }
    static void decrease(){
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
               if(!map[y][x].isIn && map[y][x].scent>0){
                   map[y][x].scent--;
                   if(map[y][x].scent==0){
                       map[y][x]=new Node();
                   }
               }
            }
        }
    }

}
