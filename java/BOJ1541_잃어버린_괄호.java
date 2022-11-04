package baekjoon.silver;

import java.util.*;

public class BOJ1541_잃어버린_괄호 {
    static Queue<String> queue = new LinkedList<>();
    static Stack<Character> stack = new Stack<>();
    static String input;
    static int answer;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        solution();
        System.out.println(answer);
    }

    static void solution() {
        makePostfix();
        //System.out.println(queue);
        calculate();
    }

    static void makePostfix() {
        String number = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '+': {
                    queue.add(number);
                    number = "";
                    while (!stack.isEmpty()) {
                        char target = stack.peek();
                        if (target == '-') {
                            break;
                        }
                        queue.add(String.valueOf(stack.pop()));
                    }
                    stack.push(ch);
                    break;
                }
                case '-': {
                    queue.add(number);
                    number = "";
                    while (!stack.isEmpty()) {
                        queue.add(String.valueOf(stack.pop()));
                    }
                    stack.push(ch);
                    break;
                }
                default: {
                    number += ch;
                    break;
                }
            }
        }

        queue.add(number);
        while (!stack.isEmpty()) {
            queue.add(String.valueOf(stack.pop()));
        }
    }

    static void calculate() {
        Stack<Integer> result = new Stack<>();
        while (!queue.isEmpty()) {
            String target = queue.poll();
            switch (target) {
                case "+": {
                    int num2 = result.pop();
                    int num1 = result.pop();
                    result.push(num1 + num2);
                    break;
                }
                case "-": {
                    int num2 = result.pop();
                    int num1 = result.pop();
                    result.push(num1 - num2);
                    break;
                }
                default: {
                    result.push(Integer.parseInt(target));
                    break;
                }
            }
        }
        answer = result.pop();
    }
}
