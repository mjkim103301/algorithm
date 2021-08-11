package ssafy.algo.study.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ16637_괄호추가하기 {
    static int N;
    static String equation;
    static int max=Integer.MIN_VALUE;
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        equation=br.readLine();
        solution();
        System.out.println(max);
    }

    static void solution(){
        int result=equation.charAt(0)-'0';
        recursion(0, result);
    }

    static void recursion(int index, int result){
        if(index==N-1){
            max=Math.max(max, result);
            return;
        }

        int tempResult;
        if(index+4<N){//괄호계산
            tempResult=calc(equation.charAt(index+2)-'0', equation.charAt(index+3), equation.charAt(index+4)-'0');
            tempResult=calc(result, equation.charAt(index+1), tempResult);
            recursion(index+4, tempResult);
        }
        if(index+2<N){
            tempResult=calc(result, equation.charAt(index+1), equation.charAt(index+2)-'0');
            recursion(index+2, tempResult);
        }
    }

    static int calc(int num1, char operator, int num2){
        switch(operator){
            case '+':
                return num1+num2;

            case '-':
                return num1-num2;

            case '*':
                return num1*num2;

            case '/':
                return num1/num2;

        }
        return 0;
    }
}



