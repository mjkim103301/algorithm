package baekjoon.silver;

import java.util.Scanner;

public class BOJ9095_1_2_3_더하기 {
    static int cnt;
    static int N;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int T=scan.nextInt();
        for(int i=1;i<=T;i++){
            N=scan.nextInt();
            solution();
        }
        System.out.println(sb);
    }

    static void solution(){
        cnt=0;
        runAdd(0);
        sb.append(cnt+"\n");
    }

    static void runAdd(int sum){
        if(sum==N){
            cnt++;
            return;
        }
        if(sum>N){
            return;
        }
        for(int i=1;i<=3;i++){
            runAdd(sum+i);
        }
    }
}
