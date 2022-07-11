package bundang.algo.study.week05;

import java.util.*;


public class BOJ2156_포도주시식 {
    static int N;
    static int[][]dp;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        N=scan.nextInt();
        dp=new int[N+2][2];
        for(int i=0;i<N;i++){
            dp[i][0]=scan.nextInt();
        }
        run();
        System.out.println(dp[0][1]);
    }
    static void run(){
        dp[N-1][1]=dp[N-1][0];
        for(int i=N-2;i>=0;i--){
            dp[i][1]=Math.max(dp[i][0]+dp[i+1][0]+dp[i+3][1], dp[i][0]+dp[i+2][1]);
            dp[i][1]=Math.max(dp[i][1], dp[i+1][1]);
        }

    }
}
