package baekjoon.level_silver;

import java.util.Scanner;

public class BOJ15650_N과M2 {
    static int N,M;
    static int[]arr;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        N=scan.nextInt();
        M=scan.nextInt();
        arr=new int[M];
        permutation(0,0, 1);
    }

    static void permutation(int level, int bits, int start){
        if(level==M){
            for(int i=0;i<M;i++){
                    System.out.print(arr[i]+" ");

            }
            System.out.println();
            return;
        }

        for(int i=start;i<=N;i++){
            if((bits & (1<<i))!=0) continue;
            arr[level]=i;
            permutation(level+1, bits|(1<<i), i);
        }
    }
}
