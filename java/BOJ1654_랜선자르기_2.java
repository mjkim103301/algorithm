package baekjoon.level_silver;

import java.util.*;
import java.io.*;

public class BOJ1654_랜선자르기_2 {
    static int K, N;
    static int[] lines;
    static int maxLine, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        K=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());

        lines=new int[K];

        for(int i=0;i<K;i++){
            lines[i]=Integer.parseInt(br.readLine());
            if(maxLine<lines[i]){
                maxLine=lines[i];
            }
        }
        solution();
        System.out.println(answer);


    }

    static void solution(){
        long left=1;
        long right=maxLine;

        while(left<=right){
            long mid=(left+right)/2;
            int count=canMake(mid);

            if(count>=N){
                answer=(int)mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
    }

    static int canMake(long mid){
        int count=0;
        for(int i=0;i<K;i++){
            count+=lines[i]/mid;
        }
        return count;
    }
}
