package baekjoon.level_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20057_마법사_상어와_토네이도_2 {
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
    static int[][][] tornado= {
            {
                    {-1,1},
                    {1,1},
                    {-1,0},
                    {1,0},
                    {-2,0},
                    {2,0},
                    {-1,-1},
                    {1,-1},
                    {0,-2},
                    {0,-1}
            },
            {
                    {-1,-1},
                    {-1,1},
                    {0,-1},
                    {0,1},
                    {0,-2},
                    {0,2},
                    {1,-1},
                    {1,1},
                    {2,0},
                    {1,0}
            },
            {
                    {-1,-1},
                    {1,-1},
                    {-1,0},
                    {1,0},
                    {-2,0},
                    {2,0},
                    {-1,1},
                    {1,1},
                    {0,2},
                    {0,1}
            },
            {
                    {1,-1},
                    {1,1},
                    {0,-1},
                    {0,1},
                    {0,-2},
                    {0,2},
                    {-1,-1},
                    {-1,1},
                    {-2,0},
                    {-1,0}
            }
    };

    static int[]ratio= {1,1,7,7,2,2,10,10,5,55};

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
        int yy=0,xx=0, add=0;
        for(int i=0;i<9;i++){
            yy=y+tornado[direct][i][0];
            xx=x+tornado[direct][i][1];
            add=(int)(sand*(ratio[i]/100.0)); // double계산 후 int로 바꿔주는 부분
            if(yy<0||xx<0||yy>=N||xx>=N){
                answer+=add;
            }else{
                map[yy][xx]+=add;
            }
            around+=add;
        }
        yy=y+tornado[direct][9][0];
        xx=x+tornado[direct][9][1];
        add=sand-around;
        if(yy<0||xx<0||yy>=N||xx>=N){
            answer+=add;
        }else{
            map[yy][xx]+=add;
        }
    }
}

