package baekjoon.level_gold;

import java.util.*;
import java.io.*;
public class BOJ15683_감시 {
    static ArrayList<String>[] cctv; // cctv아이디별 볼 수 있는 방향 담음
    static int N,M;
    static int[][]map, copyMap;
    static int answer=Integer.MAX_VALUE;
    static class Node{
        int y,x,id;
        public Node(int y, int x, int id){
           this.y=y;
           this.x=x;
           this.id=id;
        }
    }
    static int[][]dydx={
            {-1,0}, // 위
            {0,1}, //오른쪽
            {1,0}, //아래
            {0,-1}, //왼쪽
    };
    static int room;
    static ArrayList<Node> item=new ArrayList<>();//현재 맵에 저장된 카메라
    static int[] direct; //완전탐색에서 1턴에 볼 방향 index 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        copyMap=new int[N][M];
        for(int y=0;y<N;y++){
            st=new StringTokenizer(br.readLine());
            for(int x=0;x<M;x++){
                map[y][x]=Integer.parseInt(st.nextToken());
                int id=map[y][x];
                if(id>=1 && id<=5){
                    item.add(new Node(y, x, id));
                }else if(id==0){
                    room++; // 방 개수 미리 카운트
                }
            }
        }
        solution();
        System.out.println(answer);
    }
    static void solution(){
        if(item.size()==0){ // 감시할 방이 없으면 return
            answer=room;
            return;
        }
        init(); // 감시카메라 id별 볼수있는 방향 담기
        direct=new int[item.size()];
        dfs(0);
    }
    static void dfs(int index){
        if(index==item.size()){
            int temp=room-watch();
            if(answer>temp){
                answer=temp;
            }
            return;
        }
        for(int i=0;i<cctv[item.get(index).id].size();i++){
            direct[index]=i;
            dfs(index+1);
        }
    }
    static int watch(){
        int watchRoom=0;
        for(int y=0;y<N;y++){
            copyMap[y]=Arrays.copyOf(map[y], M);
        }
        for(int i=0;i<item.size();i++){
            Node now=item.get(i);
            for(int j=0;j<4;j++){
                if( cctv[now.id].get(direct[i]).contains(j+"")){
                    watchRoom+=fill(now.y, now.x, j, now.id);
                }
            }

        }
        return watchRoom;
    }

    static int fill(int y, int x, int d, int id){ // 방 채우기
        int cnt=0;
        while(true){
            int yy=y+dydx[d][0];
            int xx=x+dydx[d][1];
            if(yy<0 || xx<0 || yy>=N||xx>=M)break;
            if(copyMap[yy][xx]==6)break;
            if(copyMap[yy][xx]==0){
                cnt++;
                copyMap[yy][xx]=(-1*id);
            }
            y=yy;
            x=xx;
        }
        return cnt;
    }
    static void init(){ // 감시카메라 별 볼 수 있는 방향
        cctv=new ArrayList[6];
        for(int i=0;i<6;i++){
            cctv[i]=new ArrayList<>();
        }

        //0: 상, 1: 우, 2: 하, 3: 좌
        cctv[1].add("0");
        cctv[1].add("1");
        cctv[1].add("2");
        cctv[1].add("3");
        cctv[2].add("02");
        cctv[2].add("13");
        cctv[3].add("01");
        cctv[3].add("12");
        cctv[3].add("23");
        cctv[3].add("30");
        cctv[4].add("012");
        cctv[4].add("123");
        cctv[4].add("230");
        cctv[4].add("301");
        cctv[5].add("0123");
    }
}
