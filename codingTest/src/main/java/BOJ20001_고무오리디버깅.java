package baekjoon.level_bronze;

import java.io.*;
import java.util.*;
public class BOJ20001_고무오리디버깅 {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack=new Stack<>();
        String input= br.readLine();
        while(!input.equals("고무오리 디버깅 끝")){
            if(input.equals("문제")){
                stack.push(1);
            }else if(input.equals("고무오리")){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    stack.push(1);
                    stack.push(1);
                }
            }
            input=br.readLine();

        }
        if(stack.isEmpty()) {
            System.out.println("고무오리야 사랑해");
        }else{
            System.out.println("힝구");
        }

    }
}
