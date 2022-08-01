package programmers.level1;

import java.util.*;

public class PRO_같은숫자는싫어 {
    public static int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (!stack.empty() && stack.peek() == arr[i]) {
                continue;
            }
            stack.push(arr[i]);
        }
        int size = stack.size();
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            answer[size - i - 1] = stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution(new int[]{1, 1, 3, 0, 1, 1});
        System.out.println("답: " + Arrays.toString(answer));
    }
}
