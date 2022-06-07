package bundang.algo.study.week2;

import java.io.*;
import java.util.*;

public class BOJ2876_그래픽스퀴즈 {
    static int N;
    static int[][] map;
    static int minGrade, maxStudents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        solution();
        System.out.println(maxStudents + " " + minGrade);
    }

    static void solution() {
        for (int grade = 1; grade <= 5; grade++) {
            int student = 0;
            for (int y = 0; y < N; y++) {
                boolean sameGrade = false;
                for (int x = 0; x < 2; x++) {
                    if (map[y][x] == grade) {
                        sameGrade = true;
                        student++;
                        break;
                    }
                }
                if (student > 0 && !sameGrade) {
                    updateAnswer(student, grade);
                    student = 0;
                }
            }
            if (student > 0) {
                updateAnswer(student, grade);
            }

        }
    }

    static void updateAnswer(int student, int grade) {
        if (student > maxStudents) {
            maxStudents = student;
            minGrade = grade;
        } else if (student == maxStudents && grade < minGrade) {
            minGrade = grade;
        }
    }
}
