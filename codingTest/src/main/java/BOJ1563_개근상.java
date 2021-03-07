package baekjoon.level_gold;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ1563_개근상 {
    static int N;
    static int[][][] attendance=new int[1001][3][4];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();

        solution();
        System.out.println(attendance[0][0][0]);
    }

    static void solution(){
        for(int i=0;i<1001;i++){
            for(int j=0;j<3;j++){
                Arrays.fill(attendance[i][j], -1);

            }
        }
        dp(0,0,0);
    }
    static int dp(int day, int late, int absence){
        if(late>=2 || absence>=3) return 0;
        if(day==N){
           return 1;
        }

        if(attendance[day][late][absence]>-1){
            return attendance[day][late][absence];
        }else{
            return attendance[day][late][absence]=(dp(day+1,late,0)+dp(day+1,late+1,0)+dp(day+1,late,absence+1))%1000000;
        }

    }
}
