package baekjoon.level_bronze;
import java.util.*;
public class BOJ11720_숫자의합 {
    static int N;
    static String input;
    static int sum;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        N=scan.nextInt();
        input=scan.next();
        solution();
        System.out.println(sum);
    }
    static void solution(){
        for(int i=0;i<N;i++){
            sum+=input.charAt(i)-'0';
        }
    }
}
