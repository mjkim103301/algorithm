import java.util.*;
public class kakaoInternship_수식최대화 {
    static  Vector<String> weight=new Vector<>();
    static  Queue<String> post=new LinkedList<>();
    static  Stack<String> operS=new Stack<>();
    static Stack<Long> cal=new Stack<>();
    static  int[] visited=new int[3];
    static char[] oper={'+', '-', '*'};
    static  int len;
    static String temp="";
    static void run(int level, int[]visited){
        if(level>2){
            weight.add(temp);

            return;
        }
        for(int i=0;i<3;i++){
            if(visited[i]==1)continue;
            visited[i]=1;
            temp+=oper[i];
            run(level+1, visited);
            visited[i]=0;
            temp=temp.substring(0,level);
        }

    }
    public static long Calc(String oper, String expression, int index){
        String num="";
        for(int i=0;i<len;i++){
            if(expression.charAt(i)>='0' && expression.charAt(i)<='9'){
                num+=expression.charAt(i);
            }else{
                post.add(num);

                num="";
                if(operS.isEmpty()){
                    operS.add(""+expression.charAt(i));

                }else{
                    if(weight.elementAt(index).indexOf(operS.peek())<weight.elementAt(index).indexOf(expression.charAt(i))){
                        operS.add(""+expression.charAt(i));

                    }else{
                        while(!operS.isEmpty() && weight.elementAt(index).indexOf(operS.peek())>=weight.elementAt(index).indexOf(expression.charAt(i))){

                            post.add(operS.peek());
                            operS.pop();
                        }
                        operS.add(""+expression.charAt(i));
                    }
                }
            }
        }
        post.add(num);
        while(!operS.isEmpty()){

            post.add(operS.peek());
            operS.pop();
        }

        while(!post.isEmpty()){
            if(post.peek().equals("*")||post.peek().equals("+")||post.peek().equals("-")){
                long num2=cal.peek();
                cal.pop();
                long num1=cal.peek();
                cal.pop();
                long temp;
                if(post.peek().equals("*")){
                    temp=num1*num2;
                }else if(post.peek().equals("+")){
                    temp=num1+num2;
                }else{
                    temp=num1-num2;
                }
                cal.push(temp);
            }
            else{
                cal.push(Long.parseLong(post.peek()));
            }
            post.remove();
        }
        return Math.abs(cal.peek());

    }
    public static long solution(String expression) {
        long answer = 0;
        len=expression.length();
        run(0, visited);

         for(int i=0;i<weight.size();i++){
             long temp=Calc(weight.elementAt(i), expression, i);
            if(answer<temp){
               answer=temp;
            }
         }

        return answer;
    }


    public static void main(String []args){
       // long answer=solution("100-200*300-500+20");
       // long answer=solution("2-990-5+2");
        long answer=solution("2-990-5+2+3*2");
        System.out.println(answer);
    }
}
