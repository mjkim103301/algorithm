package baekjoon.level_gold;

import java.io.*;
import java.util.*;

public class BOJ20056_마법사상어와파이어볼 {
    static class Node{
        int m,s,d;
        int time;
        Node(int m, int s, int d, int time){
            this.m=m;
            this.s=s;
            this.d=d;
            this.time=time;
        }
    }
    static LinkedList<Node>[][]map;
    static int N,M,K;
    static int answer;
    static int[][]dydx={
            {-1,0},
            {-1,1},
            {0,1},
            {1,1},
            {1,0},
            {1,-1},
            {0,-1},
            {-1,-1}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        map=new LinkedList[N][N];
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                map[y][x]=new LinkedList<>();
            }
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            int s=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            map[r-1][c-1].add(new Node(m, s, d, 0));
        }

        solution();
        System.out.println(answer);
    }
    static void solution(){
        for(int t=1;t<=K;t++){
            for(int y=0;y<N;y++){
                for(int x=0;x<N;x++){
                    if(map[y][x].size()>0){
                        moveBall(y, x, t);
                    }
                }
            }

            divideBall(t);
        }
        getRemainM();
    }

    static void moveBall(int y, int x, int time){
        while(!map[y][x].isEmpty() && map[y][x].peek().time<time) {
            Node now = map[y][x].poll();

            int move = now.s % N;
            int yy = y + dydx[now.d][0] * move;
            int xx = x + dydx[now.d][1] * move;
            if (yy < 0) {
                yy += N;
            } else if (yy >= N) {
                yy -= N;
            }
            if (xx < 0) {
                xx += N;
            } else if (xx >= N) {
                xx -= N;
            }

            map[yy][xx].add(new Node(now.m, now.s, now.d, time));
        }
    }

    static void divideBall(int time) {

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if(map[y][x].size()>1){
                    int size=map[y][x].size();
                    int oddCnt=0;
                    int m=0;
                    int s=0;
                    int []direct= {1,3,5,7};
                    while(!map[y][x].isEmpty()){
                        Node now=map[y][x].poll();
                        m+=now.m;
                        s+=now.s;
                        if(now.d%2!=0){
                            oddCnt++;
                        }
                    }

                    m/=5;
                    s/=size;
                    if(m==0){
                        continue;
                    }
                    if(oddCnt==0 || oddCnt==size){//모두 홀수이거나 짝수일때
                        for(int i=0;i<4;i++){
                            direct[i]--;
                        }
                    }
                    for(int i=0;i<4;i++){
                        map[y][x].add(new Node(m, s, direct[i], time));
                    }
                }
            }
        }
    }

    static void getRemainM(){
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                for(int i=0, end=map[y][x].size();i<end;i++){
                    while(!map[y][x].isEmpty()){
                        answer+=map[y][x].poll().m;
                    }
                }
            }
        }
    }

}
