package baekjoon.bronze;

import java.util.Scanner;

public class BOJ11050_이항계수1 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int N=scan.nextInt();
        int K=scan.nextInt();

        System.out.println(solution(N, K));
    }

    static int solution(int N, int K){
        return factorial(N)/(factorial(K) * factorial(N-K));
    }

    static int factorial(int num){
        int answer=1;
        for(int i=num;i>1;i--){
            answer*=i;
        }
        return answer;
    }
}
