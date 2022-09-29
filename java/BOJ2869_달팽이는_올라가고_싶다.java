package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ2869_달팽이는_올라가고_싶다 {
    static int A, B, V;
    static int day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        day = (V - B) / (A - B);
        if ((V - B) % (A - B) != 0) {
            day++;
        }
        System.out.println(day);
    }
}
