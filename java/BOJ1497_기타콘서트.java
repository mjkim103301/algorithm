package bundang.algo.study.week3;

import java.util.*;
import java.io.*;

public class BOJ1497_기타콘서트 {
    static int N, M;
    static boolean canPlayTheSong;
    static Map<String, List<Integer>> map = new HashMap<>();
    static List<String> guitarNameList = new ArrayList<>();
    static int minGuitarCnt = Integer.MAX_VALUE, maxSong;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            String guitarName = st.nextToken();
            guitarNameList.add(guitarName);
            map.put(guitarName, getSongList(st.nextToken()));
        }

        if (canPlayTheSong) {
            solution(0, new boolean[N]);
            System.out.println(minGuitarCnt);
        } else {
            System.out.println(-1);
        }
    }

    static List<Integer> getSongList(String stringList) {
        List<Integer> songList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            if (stringList.charAt(i) == 'Y') {
                songList.add(i + 1);
                canPlayTheSong = true;
            }
        }
        return songList;
    }

    static void solution(int level, boolean[] visited) {
        if (level == N) {
            int guitarCnt = getGuitarCnt(visited);
            int songCnt = getSongCnt(visited);
            if (songCnt > maxSong) {
                maxSong = songCnt;
                minGuitarCnt = guitarCnt;
            } else if (songCnt == maxSong && guitarCnt < minGuitarCnt) {
                minGuitarCnt = guitarCnt;
            }
            return;
        }

        visited[level] = false;
        solution(level + 1, visited);
        visited[level] = true;
        solution(level + 1, visited);
    }

    static int getGuitarCnt(boolean[] visited) {
        int result = 0;
        for (boolean guitar : visited) {
            if (guitar) {
                result++;
            }
        }
        return result;
    }

    static int getSongCnt(boolean[] visited) {
        int result = 0;
        boolean[] songList = new boolean[M + 1];
        Arrays.fill(songList, false);
        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                List<Integer> canPlaySongList = map.get(guitarNameList.get(i));
                for (int j = 0; j < canPlaySongList.size(); j++) {
                    songList[canPlaySongList.get(j)] = true;
                }
            }
        }


        for (int i = 0; i < M + 1; i++) {
            if (songList[i]) {
                result++;
            }
        }
        return result;

    }

}
