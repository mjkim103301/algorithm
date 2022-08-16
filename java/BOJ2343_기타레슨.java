package baekjoon.level_silver;

import java.util.*;
import java.io.*;

public class BOJ2343_기타레슨 {
    static int N, M;
    static int[] lecture;
    static int minSize, maxLecture;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lecture = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());
            if (lecture[i] > maxLecture) {
                maxLecture = lecture[i];
            }
        }
        solution();
        System.out.println(minSize);
    }

    static void solution() {
        binarySearch(maxLecture, 1_000_000_000);
    }

    static void binarySearch(int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 1;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += lecture[i];
                if (sum > mid) {
                    count++;
                    sum = lecture[i];
                }
                if (count > M) {
                    left = mid + 1;
                    break;
                }
            }

            if (count <= M) {
                minSize = mid;
                right = mid - 1;
            }
        }
    }
}
