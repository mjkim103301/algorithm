package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ10816_숫자카드2 {
    static int N,M;
    static HashMap<Integer, Integer> cards=new HashMap<>();
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            setMap(Integer.parseInt(st.nextToken()));
        }

        M=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            solution(Integer.parseInt(st.nextToken()));
        }
        System.out.println(sb);
    }

    static void setMap(int num){
        if(cards.containsKey(num)){
            cards.put(num, cards.get(num)+1);
        }else{
            cards.put(num, 1);
        }
    }

    static void solution(int target){
        if(cards.containsKey(target)){
            sb.append(cards.get(target)+" ");
        }else{
            sb.append("0 ");
        }
    }
}
