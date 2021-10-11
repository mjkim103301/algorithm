package baekjoon.level_silver;

import java.util.*;
import java.io.*;
public class BOJ14889_스타트와링크 {
    static int N;
    static int[][]map;
    static int minDiff=Integer.MAX_VALUE;
    static int [] people;
    static int[]startTeam;
    static boolean[]used;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        people=new int[N];
        startTeam=new int[N/2];
        used=new boolean[N];
        for(int y=0;y<N;y++){
            st=new StringTokenizer(br.readLine());
            for(int x=0;x<N;x++){
                map[y][x]=Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(minDiff);
    }

    static void solution(){
        for(int i=0;i<N;i++){
            people[i]=i;
        }
        startTeam[0]=0;
        used[0]=true;
        combination(1,1);
    }

    static void combination(int level, int start){
        if(level==N/2){
           // System.out.println(Arrays.toString(startTeam));
            int diff=getDiff();
            if(diff<minDiff){
                minDiff=diff;
            }
            return;
        }

        for(int i=start;i<N;i++){
            startTeam[level]=i;
            used[i]=true;
            combination(level+1, i+1);
            used[i]=false;
        }
    }

    static int getDiff(){
        int start=0;
        int link=0;
        int[]linkTeam=new int[N/2];
        int linkIndex=0;
        for(int i=0;i<N;i++){
            if(!used[i]){
                linkTeam[linkIndex++]=i;
            }
        }
        for(int i=0;i<N/2;i++){
            for(int j=i+1;j<N/2;j++){
                start+=map[startTeam[i]][startTeam[j]];
                start+=map[startTeam[j]][startTeam[i]];
                link+=map[linkTeam[i]][linkTeam[j]];
                link+=map[linkTeam[j]][linkTeam[i]];
            }
        }
        return Math.abs(start-link);
    }
}
