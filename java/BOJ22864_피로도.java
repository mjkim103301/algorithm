package baekjoon.level_bronze;

import java.util.*;
public class BOJ22864_피로도 {
    static int A,B,C,M;
    static int max;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        A=scan.nextInt();
        B=scan.nextInt();
        C=scan.nextInt();
        M=scan.nextInt();
        solution();
        System.out.println(max);
    }

    static void solution(){
        int day=24;
        int tired=0;
        while(day>0){
            day--;
            if(tired+A<=M){//일해
                tired+=A;
                max+=B;
            }else{
                tired-=C;
                if(tired<0){
                    tired=0;
                }
            }
        }
    }
}
