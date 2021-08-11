package ssafy.algo.study.week06;

import java.util.*;
public class BOJ2631_줄세우기 {
    static int N;
    static int[] arr, dp;
    static int answer;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        N=scan.nextInt();

        arr=new int[N];
        dp=new int[N];

        for(int i=0;i<N;i++){
            arr[i]=scan.nextInt();
        }

        solution();
        System.out.println(answer);
    }

    static void solution(){
        dp[0]=1;
        int max=0;
        for(int i=1;i<N;i++){
            dp[i]=1; //모든 수는 최장수열의 첫번째 후보임
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j] && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    if(max<dp[i]){
                        max=dp[i];
                    }
                }
            }
        }

       answer=N-max;
    }
}
