package baekjoon.silver;

import java.util.Scanner;

public class BOJ17626_Four_Squares {
    static int N;
    static int[] dp;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        solution();
        System.out.println(dp[N]);
    }

    static void solution() {
        dp=new int[N+1];
        dp[1]=1;
        for(int i=2;i<=N;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i], dp[i-(int)Math.pow(j,2)]+1);
            }
        }

    }
}
