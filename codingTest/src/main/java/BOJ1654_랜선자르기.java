package baekjoon.level_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654_랜선자르기 {
    static int K,N;
    static int [] lan;
    static long max,answer;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        K=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());

        lan=new int[K];
        for(int i=0;i<K;i++){
            lan[i]=Integer.parseInt(br.readLine());
            if(max<lan[i]){
                max=lan[i];
            }
        }
        solution();
        System.out.println(answer);
    }

    static void solution(){
        long left=1,right=max;
        while(left<=right){
            long mid=(left+right)/2;
            long cnt=0;
            for(int i=0;i<K;i++){
                cnt+=(lan[i]/mid);
            }

            if(cnt>=N){
                left=mid+1;
                answer=mid;
            }else{
                right=mid-1;
            }
        }
    }

}
