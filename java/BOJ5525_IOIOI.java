package baekjoon.silver;

import java.util.Scanner;

public class BOJ5525_IOIOI {
    static int N,M;
    static String S, pattern;
    static int answer;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        N=scan.nextInt();
        M=scan.nextInt();
        S=scan.next();
        solution();
        System.out.println(answer);
    }

    static void solution(){
        setPattern();
        int startIndex=findPattern(0);
        while(startIndex<M){
            startIndex=findPattern(startIndex);
            if(startIndex<0){
                return;
            }
        }
    }

    static void setPattern(){
        StringBuilder sb=new StringBuilder();
        sb.append("I");
        for(int i=0;i<N;i++){
            sb.append("OI");
        }
        pattern=sb.toString();
    }

    static int findPattern(int start){
        int index=S.indexOf(pattern, start);
        if(index>0){
            answer++;
        }else{
            return index;
        }
        index+=pattern.length();
        while(index+2<=M){
            if(S.startsWith("OI", index)){
                answer++;
                index+=2;
            }else{
                break;
            }
        }
        return index;
    }
}
