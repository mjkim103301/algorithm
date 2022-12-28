package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ1991_트리순회 {
    static class Node {
        char ch;
        Node left, right;

        public Node(char ch) {
            this.ch = ch;
        }
    }

    static Node[] tree;
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new Node[26];
        for (int i = 0; i < 26; i++) {
            tree[i] = new Node('.');
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            addTree(ch, left, right);
        }
        solution();
        System.out.println(sb);
    }

    static void addTree(char ch, char left, char right) {
        int index = ch - 'A';
        tree[index].ch = ch;
        if (left != '.') {
            tree[index].left = tree[left - 'A'];
        }
        if (right != '.') {
            tree[index].right = tree[right - 'A'];
        }
    }

    static void solution() {
        preorder(tree[0]);
        sb.append("\n");
        inorder(tree[0]);
        sb.append("\n");
        postorder(tree[0]);

    }

    static void preorder(Node parent) {
        sb.append(parent.ch);
        if (parent.left != null) {
            preorder(parent.left);
        }
        if (parent.right == null) {
            return;
        }
        preorder(parent.right);
    }

    static void inorder(Node parent) {
        if (parent.left != null) {
            inorder(parent.left);
        }
        sb.append(parent.ch);
        if (parent.right == null) {
            return;
        }
        inorder(parent.right);
    }

    static void postorder(Node parent) {
        if (parent.left != null) {
            postorder(parent.left);
        }
        if (parent.right == null) {
            sb.append(parent.ch);
            return;
        }
        postorder(parent.right);
        sb.append(parent.ch);
    }
}
