package baekjoon.gold;

import java.util.*;
import java.io.*;

public class BOJ1043_거짓말 {
    static int N, M;
    static Set<Integer> truthSet = new HashSet<>();
    static int max;
    static List<Integer>[] party;
    static boolean[] truthParty; // 진실만을 말해야하는 파티

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        party = new ArrayList[M];
        truthParty = new boolean[M];
        max = M;
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        for (int i = 0; i < num; i++) {
            int people = Integer.parseInt(st.nextToken());
            truthSet.add(people);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int partyNum = Integer.parseInt(st.nextToken());
            boolean truthPeople = false;
            for (int j = 0; j < partyNum; j++) {
                int people = Integer.parseInt(st.nextToken());
                party[i].add(people);
                if (truthSet.contains(people)) {
                    truthPeople = true;
                }
            }

            if (truthPeople) {
                max--;
                truthParty[i] = true;
                truthSet.addAll(party[i]);
            }
        }

        solution();
        System.out.print(max);
    }

    static void solution() {
        int setSize = truthSet.size();
        do {
            setSize = truthSet.size();

            for (int y = 0; y < M; y++) {
                if (truthParty[y]) continue;
                boolean truthPeople = false;
                for (int x = 0; x < party[y].size(); x++) {
                    int people = party[y].get(x);
                    if (truthSet.contains(people)) {
                        truthPeople = true;
                        break;
                    }
                }
                if (truthPeople) {
                    truthParty[y] = true;
                    max--;
                    truthSet.addAll(party[y]);
                }
            }
        } while (setSize != truthSet.size());
    }
}
