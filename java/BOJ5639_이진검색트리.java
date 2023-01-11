package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ5639_이진검색트리 {
    static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    static Node root;
    static StringBuilder sb = new StringBuilder();
    static final int MAX = 10_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        if ((input = br.readLine()) != null && !input.equals("")) {
            root = new Node(Integer.parseInt(input));
        }
        while ((input = br.readLine()) != null && !input.equals("")) {
            setNode(Integer.parseInt(input), root);
        }
        postOrder(root);
        System.out.print(sb);

    }

    static void setNode(int value, Node now) {
        if (now.value > value) {
            if (now.left == null) {
                now.left = new Node(value);
            } else {
                setNode(value, now.left);
            }
        } else if (now.value < value) {
            if (now.right == null) {
                now.right = new Node(value);
            } else {
                setNode(value, now.right);
            }
        }
    }

    static void postOrder(Node now) {
        if (now == null) {
            return;
        }
        postOrder(now.left);
        postOrder(now.right);
        sb.append(now.value).append("\n");
    }
}
