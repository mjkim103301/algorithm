package baekjoon.silver;

import java.util.Scanner;

public class BOJ11726_2_multiply_n_타일링 {
    static long []map;
    static int N;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        N=scan.nextInt();
        map=new long[1001];
        map[1]=1;
        map[2]=2;
        for(int i=3;i<=N;i++){
            map[i]=(map[i-1]+map[i-2])%10007;
        }
        System.out.println(map[N]%10007);
    }
}
