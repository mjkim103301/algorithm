package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ11724_연결_요소의_개수 {
    static int N, M;
    static int[] map;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1];
        Arrays.fill(map, -1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            linkNode(u, v);
        }
        getRootCnt();
        System.out.println(cnt);
    }

    static int findParent(int parent) {
        if (map[parent] == -1) {
            return parent;
        }

        return map[parent]=findParent(map[parent]);
    }

    static void linkNode(int u, int v) {
        int parentU = findParent(u);
        int parentV = findParent(v);
        if (parentU == parentV) {
            return;
        }
        if(parentU==u && parentV!=v){
            map[u]=parentV;
        }else if(parentU!=u && parentV==v){
            map[v]=parentU;
        }
        map[v]=parentU;
    }

    static void getRootCnt() {
        for (int i = 1; i <= N; i++) {
            if (map[i] == -1) {
                cnt++;
            }
        }
    }
}
