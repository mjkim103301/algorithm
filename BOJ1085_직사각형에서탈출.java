package baekjoon.bronze;

import java.util.Scanner;

public class BOJ1085_직사각형에서탈출 {
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Node[] points;
    static Node now;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        now = new Node(scan.nextInt(), scan.nextInt());
        points = new Node[2];
        points[0] = new Node(0, 0);
        points[1] = new Node(scan.nextInt(), scan.nextInt());

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 2; i++) {
            int diffY = Math.abs(points[i].y - now.y);
            int diffX = Math.abs(points[i].x - now.x);
            if (diffY < min) {
                min = diffY;
            }
            if (diffX < min) {
                min = diffX;
            }
        }
        System.out.println(min);
    }
}
