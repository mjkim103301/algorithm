package baekjoon.level_gold;

import java.io.*;
import java.util.*;

public class BOJ17779_게리맨더링2 {
    static int N;
    static int[] sumPeople;
    static int[][] people, area;
    static int maxDLength;
    static int minDiff = Integer.MAX_VALUE, min = Integer.MAX_VALUE, max = 0;
    static ArrayList<int[]> five = new ArrayList<>();
    static ArrayList<int[]> D = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        people = new int[N + 1][N + 1];
        area = new int[N + 1][N + 1];
        sumPeople=new int[6];
        maxDLength = N - 2;
        for (int y = 1; y <= N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= N; x++) {
                people[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(minDiff);
    }

    static void solution() {
        for (int d1 = 1; d1 <=maxDLength; d1++) {
            for (int d2 = 1; d2 <= maxDLength; d2++) {
               //System.out.println(d1+ " "+d2);
                D.add(new int[]{0, d1, d2});
            }
        }

        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                divide(y, x);
            }
        }

    }

    static void divide(int y, int x) {
        for (int[] d : D) {
            if (y + d[1] + d[2]>N || x - d[1] <1 || x + d[2]> N) continue;
            int r = y;
            int c = x;
            //구역 5 저장
            for (int i = 0; i <= d[1]; i++) {
                area[r][c] = 5;
                r++;
                c--;
            }
            r = y;
            c = x;
            for (int i = 0; i <= d[2]; i++) {
                area[r][c] = 5;
                r++;
                c++;
            }
            r = y + d[1];
            c = x - d[1];
            for (int i = 0; i <= d[2]; i++) {
                area[r][c] = 5;
                r++;
                c++;
            }
            r = y + d[2];
            c = x + d[2];
            for (int i = 0; i <= d[1]; i++) {
                area[r][c] = 5;
                r++;
                c--;
            }
            //다른 구역 저장
            fillOdd(1, y +d[1]-1, 1, x, 1);
            fillOdd(y + d[1], N, 1, x-d[1]+d[2]-1, 3);
            fillEven(1, y+d[2], x+1 , N, 2);
            fillEven(y+d[2]+1, N, x-d[1]+d[2], N, 4);

            getSumPeople();
            for (int i = 1; i <= 5; i++) {
                if (sumPeople[i] > max) {
                    max = sumPeople[i];
                }
                if (sumPeople[i] < min) {
                    min = sumPeople[i];
                }
            }
            minDiff = Math.min(minDiff, max - min);
            clear();

        }
    }
    static void clear(){
        Arrays.fill(sumPeople, 0);
        for(int y=1;y<=N;y++){
            Arrays.fill(area[y], 0);
        }
        max=0;
        min=Integer.MAX_VALUE;
    }
    static void fillOdd(int y1, int y2, int x1, int x2, int num) {
        for (int y = y1; y <= y2; y++) {
            for (int x = x1; x <= x2; x++) {
                if (area[y][x] == 0) {
                    area[y][x] = num;
                } else {
                    break;
                }
            }
        }
    }

    static void fillEven(int y1, int y2, int x1, int x2, int num) {
        for (int y = y1; y <= y2; y++) {
            for (int x = x2; x >= x1; x--) {
                if (area[y][x] == 0) {
                    area[y][x] = num;
                } else {
                    break;
                }
            }
        }
    }

    static void getSumPeople() {
        for (int y = 1; y <= N; y++) {
            for (int x = 1; x <= N; x++) {
                int num = area[y][x];
                if (num == 0 || num == 5) {
                    sumPeople[5] += people[y][x];
                } else {
                    sumPeople[num] += people[y][x];
                }
            }
        }
    }
}
