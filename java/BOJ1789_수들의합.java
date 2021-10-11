package baekjoon.level_silver;

import java.util.*;
public class BOJ1789_수들의합 {
    static long N;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        N=scan.nextLong();
        solution();
    }

    static void solution(){
        long left=1;
        long right=N;
        while(left<=right){
            long mid=(left+right)/2;
            long sum=(mid*(mid+1))/2;
            if(N-sum>mid){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        System.out.println(left);
    }
}
