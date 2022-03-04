package baekjoon.silver;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ10866_덱 {
    static int N;
    static Deque<Integer> deck = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            solution(br.readLine());
        }
        System.out.println(sb);
    }

    static void solution(String input) {
        st = new StringTokenizer(input);
        switch (st.nextToken()) {
            case "push_back":
                deck.offerFirst(Integer.parseInt(st.nextToken()));
                break;
            case "push_front":
                deck.offerLast(Integer.parseInt(st.nextToken()));
                break;
            case "pop_back":
                if (deck.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deck.pollFirst()).append("\n");
                }
                break;
            case "pop_front":
                if (deck.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deck.pollLast()).append("\n");
                }
                break;
            case "size":
                sb.append(deck.size()).append("\n");
                break;
            case "empty":
                if (deck.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
                break;
            case "front":
                if (deck.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deck.peekLast()).append("\n");
                }
                break;
            case "back":
                if (deck.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(deck.peekFirst()).append("\n");
                }
                break;
            default:
                return;
        }
    }
}
