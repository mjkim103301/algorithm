package baekjoon.level_silver;

import java.util.*;
import java.io.*;
public class BOJ18870_좌표압축 {
    static int N;
    static int[]origin, arr;
    static HashMap<Integer, Integer> hashMap=new HashMap<>();
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        origin=new int[N];
        arr=new int[N];

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            origin[i]=Integer.parseInt(st.nextToken());
            arr[i]=origin[i];
        }
        solution();
        System.out.println(sb);
    }
    static void solution(){
        Arrays.sort(arr);
        int last=arr[0];
        int num=0;
        hashMap.put(last, num++);
        for(int i=1;i<N;i++){
            if(last==arr[i])continue;
            last=arr[i];
            hashMap.put(last, num++);
        }
        for(int i=0;i<N;i++){
            int target=origin[i];
            sb.append(hashMap.get(target)+" ");
        }
    }
}
