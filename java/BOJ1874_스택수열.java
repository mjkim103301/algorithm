package baekjoon.silver;

import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ1874_스택수열 {
    static int N;
    static Queue<Integer> queue=new ArrayDeque<>();
    static Stack<Integer> stack=new Stack<>();
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        for(int i=0;i<N;i++){
            queue.offer(sc.nextInt());
        }
        if(!solution()){
            System.out.println("NO");
        }else{
            System.out.println(sb);
        }
    }
    static boolean solution(){
        for(int i=1;i<=N;i++){
            stack.push(i);
            sb.append("+\n");
            while(!stack.isEmpty() && stack.peek().equals(queue.peek())){
                stack.pop();
                queue.poll();
                sb.append("-\n");
            }
        }
        if(stack.isEmpty() && queue.isEmpty()){
            return true;
        }
        return false;
    }
}
