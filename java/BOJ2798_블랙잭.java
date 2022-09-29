package baekjoon.bronze;

import java.util.*;
import java.io.*;
public class BOJ2798_블랙잭 {
    static int N,M;
    static int[] map;
    static int maxSum;
    static boolean[] used;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N];
        used=new boolean[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            map[i]=Integer.parseInt(st.nextToken());
        }
        solution();
        System.out.println(maxSum);
    }

    static void solution(){
        combination(0,0);
    }

    static void combination(int level, int next){
        if(level==3){
            int sum=0;
            for(int i=0;i<N;i++){
                if(used[i]){
                    sum+=map[i];
                }
            }

            if(sum<=M){
                maxSum=Math.max(sum, maxSum);
            }
            return;
        }

        for(int i=next;i<N;i++){
            used[i]=true;
            combination(level+1, i+1);
            used[i]=false;
        }
    }
}
