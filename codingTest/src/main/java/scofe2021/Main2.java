package scofe2021;

import java.io.*;
class Main2 {
    static int N;
    static int[] path;
    static Long[]dp;
    static Long answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        path=new int[N];
        dp=new Long[N];
        String input=br.readLine();
        for(int i=0;i<N;i++){
            path[i]=input.charAt(i)-'0';
        }
        solution();
        System.out.println(answer);
    }
    static void solution(){
        dp[0]= Long.valueOf(1);
        if(path[1]==1){
            dp[1]= Long.valueOf(1);
        }else{
            dp[1]= Long.valueOf(0);
        }
        for(int i=2;i<N;i++){
            if(path[i]==0){
                dp[i]= Long.valueOf(0);
            }else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        answer=dp[N-1];
    }
}
