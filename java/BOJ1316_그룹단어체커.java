package baekjoon.level_silver;
import java.util.*;
public class BOJ1316_그룹단어체커 {
    static int N;
    static boolean[]alphabet;
    static int answer;

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        N=scan.nextInt();
        for(int i=0;i<N;i++){
            String input=scan.next();
            solution(input);
        }
        System.out.println(answer);
    }

    static void solution(String input){
        if(isGroupWord(input)){
            answer++;
        }
    }

    static boolean isGroupWord(String input){
        alphabet=new boolean[100];
        char before=input.charAt(0);
        alphabet[before-60]=true;
        int length=input.length();
        for(int i=1;i<length;i++){
            char now=input.charAt(i);
            if(before==now) continue;
            if(alphabet[now-60]){
                return false;
            }else{
                alphabet[now-60]=true;
            }
            before=now;
        }
        return true;
    }

}
