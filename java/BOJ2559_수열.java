package baekjoon.level_silver;

import java.io.*;
import java.util.*;

public class BOJ2559_수열 {
    static int N,K;
    static int[] temperature;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        temperature=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            temperature[i]=Integer.parseInt(st.nextToken());
            if(i<K){
                max+=temperature[i];
            }
        }

        solution();
        System.out.println(max);
    }

    static void solution(){
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=temperature[i];
            if(i>=K){
                sum-=temperature[i-K];
                if(sum>max){
                    max=sum;
                }
            }

        }
    }
}
