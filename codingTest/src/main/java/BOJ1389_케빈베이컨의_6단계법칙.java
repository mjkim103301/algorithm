package baekjoon.level_silver;
import java.util.*;
import java.io.*;

public class BOJ1389_케빈베이컨의_6단계법칙 {
    static int N,M;
    static int[][]map;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][N];
        for(int y=0;y<N;y++){
            Arrays.fill(map[y], 101);
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int n1=Integer.parseInt(st.nextToken())-1;
            int n2=Integer.parseInt(st.nextToken())-1;
            map[n1][n2]=1;
            map[n2][n1]=1;
        }

        solution();
        System.out.println(answer);

    }
    static void solution(){
        for(int k=0;k<N;k++){
            for(int y=0;y<N;y++){
                for(int x=0;x<N;x++){
                    if(y==x)continue;
                    if(map[y][x]>map[y][k]+map[k][x]){
                        map[y][x]=map[y][k]+map[k][x];
                    }
                }
            }
        }
        int max=Integer.MAX_VALUE;
        for(int y=0;y<N;y++){
            int cnt=0;
            for(int x=0;x<N;x++){
                if(map[y][x]<101){
                    cnt+=map[y][x];
                }
            }
            if(cnt<max){
                max=cnt;
                answer=y+1;
            }
        }
    }
}
