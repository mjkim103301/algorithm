package bundang.algo.study.week3;

import java.io.IOException;
import java.util.*;


public class BOJ2800_괄호제거 {
    static class Node {
        char ch;
        int no;

        public Node(char ch, int no) {
            this.ch = ch;
            this.no = no;
        }
    }


    static String input;
    static int size, bracketCnt;
    static List<Node> inputList = new ArrayList<>();
    static Set<String> answerList = new HashSet<>();
    static List<String> answerSortedList = new ArrayList<>();
    static Stack<Integer> bracketNum = new Stack<>();

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();

        size = input.length();
        solution();
        for (int i = 1; i < answerSortedList.size(); i++) {
            System.out.println(answerSortedList.get(i));
        }
    }

    static void solution() {
        setInputList();
        powerset();
        answerSortedList = new ArrayList<>(answerList);
        Collections.sort(answerSortedList);
    }

    static void setInputList() {
        for (int i = 0; i < size; i++) {
            if (input.charAt(i) == '(') {
                inputList.add(new Node(input.charAt(i), bracketCnt));
                bracketNum.push(bracketCnt++);
            } else if (input.charAt(i) == ')') {
                inputList.add(new Node(input.charAt(i), bracketNum.pop()));
            } else {
                inputList.add(new Node(input.charAt(i), -1));
            }
        }
    }

    static void powerset() {
        boolean[] used = new boolean[bracketCnt + 1];
        Arrays.fill(used, false);
        run(0, bracketCnt, used);
    }

    static void run(int level, int N, boolean[] used) {
        if (level == N) {
            answerList.add(getAnswer(used));
            return;
        }
        used[level] = true;
        run(level + 1, N, used);

        used[level] = false;
        run(level + 1, N, used);
    }

    static String getAnswer(boolean[] used) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (inputList.get(i).no >= 0 && !used[inputList.get(i).no]) {
                continue;
            }
            sb.append(inputList.get(i).ch);
        }
        return sb.toString();
    }
}
