package baekjoon.silver;

import java.util.*;

public class BOJ10597_순열장난 {
    static StringBuilder sb = new StringBuilder();
    static int[] answer;
    static boolean[] used;
    static Stack<Integer> stack = new Stack<>();
    static String input;
    static boolean isFinish;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        used = new boolean[51];
        input = scan.nextLine();
        solution();
        System.out.println(sb);
    }

    static void solution() {
        dfs(0);
        answer = new int[stack.size()];
        for (int i = stack.size(); i > 0; i--) {
            answer[i - 1] = stack.pop();
        }
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }
    }

    static void dfs(int index) {
        if (index >= input.length()) {
            isFinish = isSequence();
            return;
        }
        int one = input.charAt(index) - '0';
        if (one == 0) {
            return;
        }
        if (!used[one]) {
            used[one] = true;
            stack.push(one);
            dfs(index + 1);
            if (isFinish) return;
            used[one] = false;
            stack.pop();
        }
        if (index + 1 >= input.length()) {
            return;
        }
        int ten = Integer.parseInt(input.substring(index, index + 2));
        if (ten > 50 || used[ten]) {
            return;
        }
        used[ten] = true;
        stack.push(ten);
        dfs(index + 2);
        if (isFinish) return;
        used[ten] = false;
        stack.pop();
    }

    static boolean isSequence() {
        for (int i = 1; i <= stack.size(); i++) {
            if (!used[i]) {
                return false;
            }
        }
        return true;
    }

}
