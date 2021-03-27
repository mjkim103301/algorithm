package scofe2021_2차;

import java.io.*;
import java.util.*;

public class Main3_3 {
    static int N, Q;
    static Map<Integer, Integer> item = new HashMap<>(); //자식 키에 부모 넣기
    static Map<Integer, ArrayList<Integer>> pMap = new HashMap<>(); //부모 키에 자식 리스트 넣기

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            makeSet(num1, num2);
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            if (isTrue(parent, child)) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

    static void makeSet(int num1, int num2) {//부모, 자식
        item.put(num2, num1);
        if (!item.containsKey(num1)) {
            item.put(num1, num1);
        }

        //모든 부모에 자식 num2 넣기
        int parent=num1;
        while(item.get(parent)!=parent){
            if (!pMap.containsKey(parent)) {
                pMap.put(parent, new ArrayList<>());
            }
            pMap.get(parent).add(num2);
            parent=item.get(parent);
        }
        if (!pMap.containsKey(parent)) {
            pMap.put(parent, new ArrayList<>());
        }
        pMap.get(parent).add(num2);

    }

    static boolean isTrue(int parent, int child) {

        if (!item.containsKey(parent) || !item.containsKey(child)) return false;
        if(!pMap.containsKey(parent))return false;

        ArrayList<Integer> childList=pMap.get(parent);
        for(Integer item:childList){
            if(item==child){
                return true;
            }
        }
        return false;
    }
}
