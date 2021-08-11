package 백준특강;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ16953_AtoB_2 {
    static int answer;
    static int A, B;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        A = scan.nextInt();
        B = scan.nextInt();
        solution();
        System.out.println(answer);
    }

    static void solution() {
       while(true){
           answer++;
           if(A==B){
               break;
           }
           if(A>B){
               answer=-1;
               break;
           }
           if(B%10==1){
               B/=10;
           }else if(B%2==0){
               B/=2;
           }else{
               answer=-1;
               break;
           }
       }
    }
}
