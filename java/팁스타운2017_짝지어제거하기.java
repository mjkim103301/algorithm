package level2;
import java.util.*;
public class 팁스타운2017_짝지어제거하기 {
    public static void main(String[] args) {
        Solution_짝지어제거 sol=new Solution_짝지어제거();
        String s="cdcd";
        //s="baabaa";
        s="abccaabaa";
        int answer=sol.solution(s);
        System.out.println(answer);
    }
}

class Solution_짝지어제거
{
    public boolean isRemove(StringBuffer sb){
        Stack<Character> stack=new Stack<>();
        int size=sb.length();
        if(size<2){
            return false;
        }
        int i;
        for(i=0;i<size-1;i++){
            char ch=sb.charAt(i);
            if(ch!=sb.charAt(i+1)){
                if(stack.size()>0 && stack.peek()==ch){
                    stack.pop();
                }else{
                    stack.push(ch);
                }

            }else{
                i++;
            }

        }

        if(i==size-1){//stack이랑 비교해서 다르면 넣어야함
            char chLast=sb.charAt(i);
            if(stack.size()>0){
                if( stack.peek()==chLast){
                    stack.pop();
                }else{
                    stack.push(chLast);
                }
            }else{
                stack.push(chLast);
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
    public int solution(String s)
    {
        int answer = 0;
        StringBuffer sb =new StringBuffer();
        sb.append(s);
        if(isRemove(sb)){
            answer=1;
        }

        System.out.println("Hello Java");

        return answer;
    }
}