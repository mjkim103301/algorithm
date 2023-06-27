package baekjoon.silver;

import java.util.*;
import java.io.*;

// INTJ, INTP, INFJ, INFP, ISTJ, ISTP, ISFJ, ISFP
// ENTJ, ENTP, ENFJ, ENFP, ESTJ, ESTP, ESFJ, ESFP
public class BOJ20529_가장_가까운_세_사람의_심리적_거리 {
    static int N; // 학생 수
    static List<String> mbtiList; // 학생들의 MBTI
    static int minDistanceSum; // 학생들 중 세 학생의 최소 심리 거리 합
    static String[] candidate; // 학생들 중 3명 뽑은 것

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            N = Integer.parseInt(br.readLine());
            mbtiList = new ArrayList<>();
            minDistanceSum = Integer.MAX_VALUE;
            candidate = new String[3];
            st = new StringTokenizer(br.readLine());
            if (N > 48) { // MBTI 16개 3세트면 3명이 같은 MBTI인 학생이 무조건 있으므로 0 저장
                sb.append(0).append("\n");
            } else {
                for (int i = 0; i < N; i++) {
                    mbtiList.add(st.nextToken());
                }
                solution();
                sb.append(minDistanceSum).append("\n");
            }
        }
        System.out.println(sb);
    }

    static void solution() {
        combination(0, 0);
    }

    static void combination(int level, int next) { // 학생들 중 3명 선발해서 심리적 거리 거리 측정
        if (level == 3) {
            int distance = getDistance(candidate[0], candidate[1])
                    + getDistance(candidate[0], candidate[2])
                    + getDistance(candidate[1], candidate[2]);
            if (distance < minDistanceSum) { // 최소값 갱신
                minDistanceSum = distance;
            }
            return;
        }

        for (int i = next; i < mbtiList.size(); i++) {
            candidate[level] = mbtiList.get(i);
            combination(level + 1, i + 1);
        }
    }

    static int getDistance(String target1, String target2) { // 2명 사이의 심리적 거리 측정
        int distance = 0;
        for(int i=0;i<4;i++){
            if(target1.charAt(i) != target2.charAt(i)){
                distance++;
            }
        }
        return distance;
    }
}