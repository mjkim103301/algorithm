package scofe2021_2차;

import java.io.*;

public class Main4 {
    static int N, Q;
    static String[] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        N=Integer.parseInt(br.readLine());
        map=new String[N];
        for(int i=0;i<N;i++){
            map[i]=br.readLine();
        }
        Q=Integer.parseInt(br.readLine());
        for(int i=0;i<Q;i++){
            String target=br.readLine();
            int cnt=find(target);
                bw.write(cnt+"\n");

        }
        bw.flush();
        bw.close();
    }
    static int find(String target){
        int cnt=0;
        for(int i=0;i<N;i++){
            if(map[i].contains(target)){
                cnt++;
            }
        }
        return cnt;
    }
}
