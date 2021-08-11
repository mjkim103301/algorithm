package ssafy.algo.study.week01;

import java.util.*;
import java.io.*;
public class BOJ17135_캐슬디펜스 {
    static int N,M,D;
    static int[][]map;
    static int[][]copy;
    static int archer=3;
    static int max;

    static void moveEnomy(){
        for(int y=N-1;y>0;y--){
            copy[y]=Arrays.copyOf(copy[y-1], M);
        }
        Arrays.fill(copy[0],0);
    }
    static int game(){
        int kill=0;
        int [][]enomy=new int[M][2];
        for(int i=0;i<N+1;i++){
            copy[i]=Arrays.copyOf(map[i], M);
        }
        for(int cnt=0;cnt<N;cnt++){

            for(int k=0;k<M;k++){
                Arrays.fill(enomy[k], -1);
            }

            for(int j=0;j<M;j++){

                if(copy[N][j]==0) continue;
                //궁수가 있으면
                int minDistance=D+1;
                int enomyY=-1;
                int enomyX=-1;
                for(int x=0;x<M;x++){
                for(int y=N-1;y>=N-D;y--){
                        if(y<0)continue;
                        if(copy[y][x]==0) continue;
                        //적이 있으면
                        int distance=Math.abs(y-N)+Math.abs(x-j);
                        if(distance<=D && distance<minDistance){
                            enomyY=y;
                            enomyX=x;
                            minDistance=distance;
                            //break;
                        }
                    }
                }

                if(enomyY>=0 && enomyX>=0){
                    enomy[j][0]=enomyY;
                    enomy[j][1]=enomyX;
                    //copy[enomyY][enomyX]=0;
                    //kill++;
                }
            }

            for(int i=0;i<M;i++){
                int y=enomy[i][0];
                int x=enomy[i][1];
                if(y>=0 && x>=0 && copy[y][x]==1){
                    kill++;
                    copy[y][x]=0;
                }
            }

            moveEnomy();
        }


        return kill;
    }
    static void defense(int now, int index){
        if(now==archer){
            int kill=game();

            max=Math.max(max,kill);
            return;
        }

        for(int i=index; i<M;i++){
            map[N][i]=1;
            defense(now+1,i+1);
            map[N][i]=0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());
        map=new int[N+1][M];
        copy=new int[N+1][M];
        for(int y=0;y<N;y++){
            st=new StringTokenizer(br.readLine());
            for(int x=0;x<M;x++){
                map[y][x]=Integer.parseInt(st.nextToken());
            }
        }
        defense(0,0);
        System.out.println(max);
    }
}
