package baekjoon.silver;

import java.io.*;
import java.util.*;

public class BOJ10773_제로 {
    static int K;
    static Stack<Integer> stack=new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        K=Integer.parseInt(br.readLine());

        for(int i=0;i<K;i++){
            int num=Integer.parseInt(br.readLine());
            if(num==0){
                stack.pop();
            }else{
                stack.push(num);
            }
        }
        System.out.println(solution());
    }

    static int solution(){
        int sum=0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}
