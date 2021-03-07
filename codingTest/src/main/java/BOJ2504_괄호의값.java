package ssafy.algo.study.week01;
import java.util.*;
import java.io.*;
public class BOJ2504_괄호의값 {
    static Stack<String> stack;
    static boolean calc(String num, String target){
        int temp=0;
        while(!stack.isEmpty()&&!stack.peek().equals(target)){
            String peek=stack.peek();
            if(peek.equals("(")||peek.equals(")")||peek.equals("[")||peek.equals("]")){
                return false;

            }else{
                temp+=Integer.parseInt(peek);
                stack.pop();
            }
        }
        if(stack.isEmpty())return false;
        stack.pop();
        if(temp==0){
            stack.push(num);
        }else{
            temp=temp*Integer.parseInt(num);
            stack.push(temp+"");
        }
        return true;
    }
    static int solution(String input){
        boolean isValid=true;
        stack=new Stack<>();
        int size=input.length();
        for(int i=0;i<size;i++){
            char ch=input.charAt(i);
            switch(ch){
                case')':
                    isValid=calc("2", "(");
                    break;
                case ']':
                    isValid=calc("3", "[");
                    break;
                default:
                    stack.push(ch+"");
                    break;
            }
            if(!isValid){
                return 0;
            }
        }
        int answer=0;
        while(!stack.isEmpty()){
            String peek=stack.peek();
            if(peek.equals("(")||peek.equals(")")||peek.equals("[")||peek.equals("]")){
                return 0;
            }else{
                answer+=Integer.parseInt(peek);
                stack.pop();
            }

        }
        return answer;
    }
    public static void main(String[]args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String input=br.readLine();
        int answer=solution(input);
        System.out.println(answer);
    }
}
