package baekjoon.gold;

import java.util.*;

public class BOJ9663_N_Queen {
    static int N;
    static int count;
    static int[]arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        arr=new int[N];
        solution();
        System.out.println(count);
    }

    static void solution() {
        bruteForce(0);
    }

    static void bruteForce(int level) {
        if (level == N) {
            count++;
            return;
        }
        for(int i=0;i<N;i++){
            arr[level]=i;
            if(isPossible(level)){
                bruteForce(level+1);
            }
        }
    }

    static boolean isPossible(int level){

        for(int i=0;i<level;i++){
            if(arr[i]==arr[level]){
                return false;
            }
            if(Math.abs(level-i)==Math.abs(arr[level]-arr[i])){
                return false;
            }
        }
        return true;
    }
}
