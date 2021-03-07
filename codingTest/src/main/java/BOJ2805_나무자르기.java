package baekjoon.level_silver;

import java.util.*;
import java.io.*;


public class BOJ2805_나무자르기 {
    static int N,M;
    static int[] trees;
    static int ans;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        trees=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            trees[i]=Integer.parseInt(st.nextToken());
        }
        solution();
        System.out.println(ans);
    }

    static void solution(){
        Arrays.sort(trees);
        int left=0;
        int right=trees[N-1];
        while(left<=right){
            int mid=(left+right)/2;
            long cut=0;
            for(int i=0;i<N;i++){
                if(trees[i]>mid){
                    cut+=trees[i]-mid;

                }

                if(cut>=M){
                    break;
                }
            }

            if(cut>=M){
                left=mid+1;
                ans=mid;
            }else{
                right=mid-1;
            }
        }
    }
}
