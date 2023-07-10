package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ20950_미술가_미미 {
    static int N; // 입력값 색의 개수

    static class Node {// 색깔
        int R, G, B;

        public Node(int R, int G, int B) {
            this.R = R;
            this.G = G;
            this.B = B;
        }
    }

    static Node gom, mun; // 곰두리색, 문두리색
    static Node[] candidate, colorList; // 조합 후보들, 전체 색깔 목록
    static int minDiff = Integer.MAX_VALUE; // 곰두리색, 문두리색 차이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        colorList = new Node[N];
        for (int i = 0; i < N; i++) { // 전체 색깔 목록 채우기
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            colorList[i] = new Node(R, G, B);
        }
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        gom = new Node(R, G, B); // 곰두리색 초기화
        solution();
        System.out.println(minDiff);
    }

    static void solution() {
        for (int i = 2; i <= 7; i++) { // 조합 2개부터 7개 구하기
            if (i > N) { // 조합으로 구할 개수가 전체 색깔 수(N)를 넘으면 종료하기
                return;
            }
            candidate = new Node[i]; // 조합 색 후보 배열 개수 초기화
            combination(i, 0, 0);
        }

    }

    static void combination(int max, int start, int level) {
        if (level == max) {
            setMun(); // 문두리색 후보 구하기
            int diff = getDiff(); // 곰두리색, 문두리색 후보의 차이 구하기
            if (diff < minDiff) { // 차이가 작으면 최소값 갱신
                minDiff = diff;
            }
            return;
        }
        for (int i = start; i < N; i++) { // 후보 색 목록에 전체 색 목록중 1개를 골라서 카피하기
            Node copy = colorList[i];
            candidate[level] = new Node(copy.R, copy.G, copy.B);
            combination(max, i+1, level+1);
        }
    }

    static void setMun() { // 문두리색 후보 설정하기: 색깔별로 다 더해서 개수로 나누기
        int R = 0, G = 0, B = 0;
        for (int i = 0; i < candidate.length; i++) {
            R += candidate[i].R;
            G += candidate[i].G;
            B += candidate[i].B;
        }

        R /= candidate.length;
        G /= candidate.length;
        B /= candidate.length;

        mun = new Node(R, G, B);
    }

    static int getDiff() { // 곰두리색, 문두리색 후보의 차이 구하기
        return Math.abs(gom.R - mun.R) + Math.abs(gom.G - mun.G) + Math.abs(gom.B - mun.B);
    }
}
