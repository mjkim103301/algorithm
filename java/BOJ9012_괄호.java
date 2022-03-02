package baekjoon.level_silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ9012_괄호 {
    static int T;
    static Stack<Character> stack=new Stack<>();
    static String input;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            input=br.readLine();
            if(solution(input)){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);

    }

    static boolean solution(String input){
        int len=input.length();
        stack.clear();
        for(int i=0;i<len;i++){
            switch (input.charAt(i)){
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if(stack.isEmpty()){
                        return false;
                    }
                    while(!stack.isEmpty()){
                        char item=stack.pop();
                        if(item==')'){
                            return false;
                        }else if(item=='('){
                            break;
                        }
                    }
                    break;
                default:
                    return false;
            }
        }

        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

}
