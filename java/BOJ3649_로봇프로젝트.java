package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ3649_로봇프로젝트 {
    static long hole;
    static int N;
    static long[] answer;
    static List<Long> legoList;
    static long[] candidate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                legoList = new ArrayList<>();
                answer = new long[2];
                candidate = new long[2];
                hole = Long.parseLong(br.readLine());
                hole *= 10_000_000;
                N = Integer.parseInt(br.readLine());
                for (int i = 0; i < N; i++) {
                    long lego = Long.parseLong(br.readLine());
                    legoList.add(lego);
                }
                solution();
                if (answer[0] == 0 || answer[1] == 0) {
                    System.out.println("danger");
                } else {
                    System.out.println("yes " + answer[0] + " " + answer[1]);
                }

            }
        } catch (NumberFormatException e) {
        }

    }

    static void solution() {
        Collections.sort(legoList);
        for (int i = 0; i < legoList.size(); i++) {
            twoPointer(i);
        }
    }

    static void twoPointer(int standard) {
        int left = standard + 1;
        int right = legoList.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = legoList.get(standard) + legoList.get(mid);

            if (sum == hole) {
                changeAnswer(legoList.get(standard), legoList.get(mid));
                left = mid + 1;
            } else if (sum < hole) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    private static void changeAnswer(long standardValue, long midValue) {
        if (Math.abs(standardValue - midValue) >= Math.abs(answer[0] - answer[1])) {
            answer[0] = standardValue;
            answer[1] = midValue;
        }
    }
}