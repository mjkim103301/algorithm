package baekjoon.level_gold;

import java.util.*;
import java.io.*;
public class BOJ1477_휴게소세우기 {
    static int N,M,L;
    static int[] rest;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        L=Integer.parseInt(st.nextToken());

        rest=new int[N+2];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            rest[i]=Integer.parseInt(st.nextToken());
        }
        solution();
    }

    static void solution(){
        rest[N]=0;
        rest[N+1]=L;
        Arrays.sort(rest);
        int left=0;
        int right=L;
        while(left<=right){
            int mid=(left+right)/2;
            int count=0;
            for(int i=0;i<N+1;i++){
                count+=(rest[i+1]-rest[i]-1)/mid;
            }
            if(count>M){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        System.out.println(left);
    }
}
