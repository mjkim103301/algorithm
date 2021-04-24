package baekjoon.level_gold;

import java.io.*;
import java.util.*;
public class BOJ17140_이차원배열과연산 {
    static int r,c,k;
    static int[][]map=new int[3][3];
    static int[] number=new int[101];
    static int answer=101;
    static class Node implements Comparable<Node>{
        int num,cnt;
        Node(int num,int cnt){
            this.num=num;
            this.cnt=cnt;
        }

        @Override
        public int compareTo(Node o) {
            int diff=this.cnt-o.cnt;
            if(diff==0){
                return this.num-o.num;
            }
            return diff;
        }
    }
    static int maxYLength=3, maxXLength=3;
    static ArrayList<Node>[]temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        r=Integer.parseInt(st.nextToken())-1;
        c=Integer.parseInt(st.nextToken())-1;
        k=Integer.parseInt(st.nextToken());
        init();
        for(int y=0;y<3;y++){
            st=new StringTokenizer(br.readLine());
            for(int x=0;x<3;x++){
                map[y][x]=Integer.parseInt(st.nextToken());
            }
        }
        solution();
        if(answer==101){
            answer=-1;
        }
        System.out.println(answer);
    }
    static void solution(){
        int time=0;
        if(r<maxYLength && c<maxXLength && map[r][c]==k){
            answer=time;
            return;
        }
        while(time++<=100){
            for(int i=0;i<100;i++){
                temp[i].clear();
            }
            if(maxYLength>=maxXLength){
                sortRow();
                makeNewRowMap();
            }else{
                sortCol();
                makeNewColMap();
            }
            if(r<maxYLength && c<maxXLength && map[r][c]==k){
                answer=time;
                return;
            }
        }
    }
    static void init(){
        temp=new ArrayList[100];
        for(int i=0;i<100;i++){
            temp[i]=new ArrayList<>();
        }
    }
    static void sortRow(){
        int newMaxXLength=0;
        for(int y=0;y<maxYLength;y++){
            Arrays.fill(number, 0);
            for(int x=0;x<maxXLength;x++){
                int num=map[y][x];
                if(num==0)continue;
                number[num]++;
            }
            fillTemp(y);
            Collections.sort(temp[y]);
            if(temp[y].size()*2>newMaxXLength){
                newMaxXLength=temp[y].size()*2;
            }
        }
        maxXLength=newMaxXLength;
    }
    static void sortCol(){
        int newMaxYLength=0;
        for(int x=0;x<maxXLength;x++){
            Arrays.fill(number, 0);
            for(int y=0;y<maxYLength;y++){
                int num=map[y][x];
                if(num==0)continue;
                number[num]++;
            }
            fillTemp(x);
            Collections.sort(temp[x]);
            if(temp[x].size()*2>newMaxYLength){
                newMaxYLength=temp[x].size()*2;
            }
        }
        maxYLength=newMaxYLength;
    }

    static void makeNewRowMap(){
        if(maxXLength>100){
            maxXLength=100;
        }
        map=new int[maxYLength][maxXLength];

        for(int y=0;y<maxYLength;y++){
            int x=0;
            for(int i=0, end=temp[y].size();i<end;i++){
                map[y][x++]=temp[y].get(i).num;
                map[y][x++]=temp[y].get(i).cnt;
            }
            if(x>100)break;
        }
    }
    static void makeNewColMap(){
        if(maxYLength>100){
            maxYLength=100;
        }
        map=new int[maxYLength][maxXLength];
        for(int x=0;x<maxXLength;x++){
            int y=0;
            for(int i=0, end=temp[x].size();i<end;i++){
                map[y++][x]=temp[x].get(i).num;
                map[y++][x]=temp[x].get(i).cnt;
            }
            if(y>100)break;
        }
    }
    static void fillTemp(int index){
        for(int i=1;i<=100;i++){
            if(number[i]>0){
                temp[index].add(new Node(i, number[i]));
            }
        }
    }
}
