package baekjoon.silver;

import java.util.*;
import java.io.*;

public class BOJ14889_스타트와_링크 {
    static int N;
    static int[][]map;
    static boolean[] team;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());
        map=new int[N][N];
        team=new boolean[N];

        for(int y=0;y<N;y++){
            st=new StringTokenizer(br.readLine());
            for(int x=0;x<N;x++){
                map[y][x]=Integer.parseInt(st.nextToken());
            }
        }

        solution();
        System.out.println(answer);
    }

    static void solution(){
        team[0]=true;
        combination(N/2, 1, 1);
    }

    static void combination(int teamMember, int level, int next){
        if(level==teamMember){
            int diff=getDiffAbility();
            //System.out.println(Arrays.toString(team));
            if(diff<answer){
                answer=diff;
            }
            return;
        }

        for(int i=next;i<N;i++){
            team[i]=true;
            combination(teamMember, level+1, i+1);
            team[i]=false;
        }
    }

    static int getDiffAbility(){
        int []startTeam=new int[N/2];
        int []linkTeam=new int[N/2];
        int startTeamIndex=0;
        int linkTeamIndex=0;
        for(int i=0;i<N;i++){
            if(team[i]){
                startTeam[startTeamIndex++]=i;
            }else{
                linkTeam[linkTeamIndex++]=i;
            }
        }

        int startTeamScore=0;
        int linkTeamScore=0;
        for(int i=0;i<N/2;i++){
            for(int j=0;j<N/2;j++){
                startTeamScore+=map[startTeam[i]][startTeam[j]];
            }
        }

        for(int i=0;i<N/2;i++){
            for(int j=0;j<N/2;j++){
                linkTeamScore+=map[linkTeam[i]][linkTeam[j]];
            }
        }

        return Math.abs(startTeamScore-linkTeamScore);
    }
}
