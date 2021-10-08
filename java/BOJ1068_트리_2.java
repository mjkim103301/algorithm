package baekjoon.level_gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1068_트리_2 {
   static int N;
   static boolean[][]arr;
   static int delete;
   static int answer;
   static ArrayList<Integer> root=new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        arr=new boolean[N][N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int parent=Integer.parseInt(st.nextToken());
            int child=i;
            if(parent==-1){
                root.add(i);
                continue;
            }
            arr[parent][child]=true;

        }
        delete=Integer.parseInt(br.readLine());
        solution();
        System.out.println(answer);
    }

    static void solution(){
        dfs(delete);
        for(int i=0;i<N;i++){
            arr[i][delete]=false;
        }
        for(int i=0, cnt=root.size();i<cnt;i++){
            findLeefNode(root.get(i));
        }
        if(root.contains(delete)){
            answer--;
        }
    }

    static void dfs(int parent){
        for(int i=0;i<N;i++){
            if(arr[parent][i]){
                arr[parent][i]=false;
                dfs(i);
            }
        }
    }

    static void findLeefNode(int parent){
        int child=0;
        for(int i=0;i<N;i++){
            if(arr[parent][i]){
                findLeefNode(i);
                child++;
            }
        }
        if(child==0){
            answer++;
        }

    }

}
