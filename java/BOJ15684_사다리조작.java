package baekjoon.level_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15684_사다리조작 {
    static int N,M,H;
    static int[][]map;
    static boolean[][]cannotInstall;
    static int answer=4;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        H=Integer.parseInt(st.nextToken());

        map=new int[H][N];
        cannotInstall=new boolean[H][N];

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int y=Integer.parseInt(st.nextToken())-1;
            int x=Integer.parseInt(st.nextToken())-1;
            map[y][x]=1;
            cannotInstall[y][x]=true;
            if(x-1>=0){
                cannotInstall[y][x-1]=true;
            }
            if(x+1<N){
                cannotInstall[y][x+1]=true;
            }
        }

        solution();
        if(answer>3){
            answer=-1;
        }
        System.out.println(answer);
    }

    static void solution(){
        dfs(0);
    }
    static void dfs(int level){
        if(play()){
            if(level<answer){
                answer=level;
            }
            return;
        }
        if(level==3){
            return;
        }

        for(int y=0;y<H;y++){
            for(int x=0;x<N-1;x++){
                if(cannotInstall[y][x] || map[y][x]>0){
                    continue;
                }
                if(x-1>=0 && map[y][x-1]>0)continue;
                if(x+1<N&& map[y][x+1]>0)continue;
                map[y][x]=2;
                dfs(level+1);
                map[y][x]=0;
            }
        }
    }

    static boolean play(){
        for(int line=0;line<N;line++){
            int x=line;
            for(int y=0;y<H;y++){
                if(x-1>=0 && map[y][x-1]>0){
                    x=x-1;
                }else if(map[y][x]>0){
                    x=x+1;
                }
            }
            if(x!=line){
                return false;
            }
        }
      return true;
    }
}
