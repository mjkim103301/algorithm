package baekjoon.level_bronze;

import java.util.Scanner;

public class BOJ2475_검증수 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int sum=0;
        for(int i=0;i<5;i++){
            sum+=Math.pow(scan.nextInt(), 2);
        }
        System.out.println(sum%10);
    }
}
