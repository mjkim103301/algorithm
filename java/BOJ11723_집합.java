package baekjoon.silver;

import java.util.*;
import java.io.*;


public class BOJ11723_집합 {
    static int M;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "add": {
                    list.add(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "remove": {
                    int target = Integer.parseInt(st.nextToken());
                    while (list.contains(target)) {
                        list.remove((Object) target);
                    }
                    break;
                }
                case "check": {
                    if (list.contains(Integer.parseInt(st.nextToken()))) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                    break;
                }
                case "toggle": {
                    int target = Integer.parseInt(st.nextToken());
                    if (list.contains(target)) {
                        list.remove((Object) target);
                    } else {
                        list.add(target);
                    }
                    break;
                }
                case "all": {
                    list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17,
                            18, 19, 20));
                    break;
                }
                case "empty": {
                    list = new ArrayList<>();
                    break;
                }
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}
