package baekjoon.silver;

import java.util.Scanner;

public class BOJ1436_영화감독_숌 {
    static int N;
    static long answer;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        N=scan.nextInt();
        answer=666;
        while(N>0){
            if(isTitle()){
                N--;
                if(N==0){
                    break;
                }
            }
            answer++;
        }
        System.out.println(answer);
    }

    static boolean isTitle(){
        String target=answer+"";
        if(target.contains("666")){
            return true;
        }
        return false;
    }
}
