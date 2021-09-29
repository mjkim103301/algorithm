package baekjoon.level_silver;

import java.util.*;
import java.io.*;

public class BOJ15656_N과M7 {
    static int N,M;
    static int[]arr,pick;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        arr=new int[N];
        pick=new int[M];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        solution();
        System.out.println(sb);
    }

    static void solution(){
        Arrays.sort(arr);
        permutation(0);
    }

    static void permutation(int level){
        if(level==M){
            for(int i=0;i<M;i++){
                sb.append(pick[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0;i<N;i++){
            pick[level]=arr[i];
            permutation(level+1);
        }
    }
}
