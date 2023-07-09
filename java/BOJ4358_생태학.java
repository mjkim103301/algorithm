package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ4358_생태학 {
    static int count; // 입력 나무 총 개수
    static Map<String, Integer> map = new HashMap<>(); // 나무의 종과 개수를 저장할 맵
    static StringBuilder sb = new StringBuilder(); // 출력값
    static List<String> treeList = new ArrayList<>(); // 입력되는 나무 종류(나중에 정렬할 때 사용)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String tree = br.readLine();
            if (tree == null || tree.length() == 0) { // 입력값이 널이거나 길이가 0이면 종료 (인텔리제이에서는 ctrl + d 를 눌러서 eof 발생)
                break;
            }

            count++; // 입력되는 나무 수 세기
            putTree(tree); // 나무를 맵에 넣기
        }
        solution(); // 나무의 퍼센테이지 정해서 출력값에 넣기
        System.out.println(sb);
    }

    static void putTree(String tree) {
        if (map.containsKey(tree)) { // 맵에 키가 있으면 개수 1 증가
            map.put(tree, map.get(tree) + 1);
        } else { // 없으면 새로 추가, 나무 목록에 새로운 나무 넣기
            map.put(tree, 1);
            treeList.add(tree);
        }
    }

    static void solution() {
        Collections.sort(treeList); // 나무 목록 정렬
        for (int i = 0; i < treeList.size(); i++) {
            String key = treeList.get(i);
            int num = map.get(key);
            String percentage = String.format("%.4f", (double) num / count * 100); // 퍼센트 소수점 4째자리까지 나오게 함.

            sb.append(key + " " + percentage).append("\n");
        }
    }
}
