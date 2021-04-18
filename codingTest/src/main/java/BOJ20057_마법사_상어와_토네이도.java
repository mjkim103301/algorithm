package baekjoon.level_gold;

import java.io.*;
import java.util.*;

public class BOJ20057_마법사_상어와_토네이도 {
    static int N;
    static int[][]map;
    static int answer;
    static int[][]dydx={
            {0,-1}, //좌
            {1,0}, //하
            {0,1},//우
            {-1,0}//상
    };
    static class Node{
        int dy, dx;
        int percent;
        Node(int dy, int dx, int percent){
            this.dy=dy;
            this.dx=dx;
            this.percent=percent;
        }
    }
    static boolean stop;
    static Node[][]tornado=new Node[4][10];
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        map=new int[N][N];

        for(int y=0;y<N;y++){
            st=new StringTokenizer(br.readLine());
            for(int x=0;x<N;x++){
                map[y][x]=Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(answer);
    }

    static void solution(){
        init();
        start(1, 1,N/2, N/2, 0);
    }
    static void start(int level,int go,int y, int x, int direct){

        int yy=0,xx=0;
        while(yy!=0 || xx!=-1){
            for(int i=0;i<go;i++){
                yy=y+dydx[direct][0];
                xx=x+dydx[direct][1];
                if(yy==0 && xx==-1){
                    stop=true;
                    return;
                }
                int sand=map[yy][xx];
                map[yy][xx]=0;
                spread(sand, yy, xx, direct);
                y=yy;
                x=xx;
            }
            if(level%2==0){
                go++;
            }
            level++;
            direct=(direct+1)%4;
        }
    }
    static void spread(int sand, int y, int x, int direct){
        int around=0;
       // int divide=sand/100;
        int yy=0,xx=0, add=0;
        for(int i=0;i<9;i++){
            yy=y+tornado[direct][i].dy;
            xx=x+tornado[direct][i].dx;
            add=(int)(sand*(tornado[direct][i].percent/100.0));
            if(yy<0||xx<0||yy>=N||xx>=N){
                answer+=add;
            }else{
                map[yy][xx]+=add;
            }
            around+=add;
        }
        yy=y+tornado[direct][9].dy;
        xx=x+tornado[direct][9].dx;
        add=sand-around;
        if(yy<0||xx<0||yy>=N||xx>=N){
            answer+=add;
        }else{
            map[yy][xx]+=add;
        }
    }
    static void init(){
        tornado[0][0]=new Node(-1, +1, 1);
        tornado[0][1]=new Node(+1, +1, 1);

        tornado[0][2]=new Node(-1, 0, 7);
        tornado[0][3]=new Node(1, 0, 7);

        tornado[0][4]=new Node(-2, 0, 2);
        tornado[0][5]=new Node(+2, 0, 2);

        tornado[0][6]=new Node(-1, -1, 10);
        tornado[0][7]=new Node(+1, -1, 10);

        tornado[0][8]=new Node(0, -2, 5);
        tornado[0][9]=new Node(0, -1, 55);

        tornado[1][0]=new Node(-1, -1, 1);
        tornado[1][1]=new Node(-1, +1, 1);

        tornado[1][2]=new Node(0, -1, 7);
        tornado[1][3]=new Node(0, 1, 7);

        tornado[1][4]=new Node(0, -2, 2);
        tornado[1][5]=new Node(0, 2, 2);

        tornado[1][6]=new Node(1, -1, 10);
        tornado[1][7]=new Node(+1, 1, 10);

        tornado[1][8]=new Node(2, 0, 5);
        tornado[1][9]=new Node(1, 0, 55);

        tornado[2][0]=new Node(-1, -1, 1);
        tornado[2][1]=new Node(+1, -1, 1);

        tornado[2][2]=new Node(-1, 0, 7);
        tornado[2][3]=new Node(1, 0, 7);

        tornado[2][4]=new Node(-2, 0, 2);
        tornado[2][5]=new Node(+2, 0, 2);

        tornado[2][6]=new Node(-1, 1, 10);
        tornado[2][7]=new Node(+1, 1, 10);

        tornado[2][8]=new Node(0, 2, 5);
        tornado[2][9]=new Node(0, 1, 55);

        tornado[3][0]=new Node(1, -1, 1);
        tornado[3][1]=new Node(1, +1, 1);

        tornado[3][2]=new Node(0, -1, 7);
        tornado[3][3]=new Node(0, 1, 7);

        tornado[3][4]=new Node(0, -2, 2);
        tornado[3][5]=new Node(0, 2, 2);

        tornado[3][6]=new Node(-1, -1, 10);
        tornado[3][7]=new Node(-1, 1, 10);

        tornado[3][8]=new Node(-2, 0, 5);
        tornado[3][9]=new Node(-1, 0, 55);
    }
}

