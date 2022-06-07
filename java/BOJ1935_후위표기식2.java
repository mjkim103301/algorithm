package bundang.algo.study.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1935_후위표기식2 {
    static int N;
    static Stack<Double> stack = new Stack<>();
    static String input;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = br.readLine();
        map = new int[N];
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(br.readLine());
        }
        solution();
        System.out.println(String.format("%.2f", stack.peek()));
    }

    static void solution() {
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char target = input.charAt(i);
            if (target >= 'A' && target <= 'Z') {
                stack.push((double) map[target - 'A']);
            } else {
                calulate(target);
            }
        }
    }

    static void calulate(char target) {
        double secondNum = stack.peek();
        stack.pop();
        double firstNum = stack.peek();
        stack.pop();
        double answer = 0;
        switch (target) {
            case '+': {
                answer = firstNum + secondNum;
                break;
            }
            case '-': {
                answer = firstNum - secondNum;
                break;
            }
            case '*': {
                answer = firstNum * secondNum;
                break;
            }
            case '/': {
                answer = firstNum / secondNum;
                break;
            }
            default:
                break;
        }
        stack.push(answer);

    }
}