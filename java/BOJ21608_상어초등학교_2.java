package baekjoon.level_silver;

import java.util.*;
import java.io.*;

public class BOJ21608_상어초등학교_2 {
    static int N, people;
    static int[][]arr, map;
    static int[][]dydx={
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };
    static class Node{
        int y,x;
        int like;
        int empty;
        public Node(int y, int x, int like, int empty){
            this.y=y;
            this.x=x;
            this.like=like;
            this.empty=empty;
        }
    }
    static ArrayList<Node> candidate=new ArrayList<>();
    static int satisfied;
    static int[]point={0,1,10,100,1000};
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        people=N*N;
        arr=new int[people][5];
        map=new int[N][N];

        for(int y=0;y<people;y++){
            st=new StringTokenizer(br.readLine());
            for(int x=0;x<5;x++){
                arr[y][x]=Integer.parseInt(st.nextToken());
            }
        }
        solution();
        System.out.println(satisfied);
    }

    static void solution(){
        for(int y=0;y<people;y++){
            findCandidate(y);
            sitStudent(y);
        }
        getSatisfied();
    }
    static void findCandidate(int index){
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                if(map[y][x]>0)continue;
                int like=0;
                int empty=0;
                for(int i=0;i<4;i++){
                    int yy=y+dydx[i][0];
                    int xx=x+dydx[i][1];
                    if(yy<0||xx<0 ||yy>=N||xx>=N) continue;
                    if(map[yy][xx]==0){
                        empty++;
                    }else if(isLike(map[yy][xx], index)){
                        like++;
                    }
                }
                candidate.add(new Node(y, x, like, empty));
            }
        }
    }

    static boolean isLike(int target, int index){
        if(target==arr[index][1] || target==arr[index][2] ||target==arr[index][3] ||target==arr[index][4] ){
            return true;
        }
        return false;
    }

    static void sitStudent(int index){
        Collections.sort(candidate, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.like!=o2.like){
                    return o2.like-o1.like;
                }else if(o1.empty!=o2.empty){
                    return o2.empty-o1.empty;
                }else if(o1.y!=o2.y){
                    return o1.y-o2.y;
                }
                return o1.x-o2.x;
            }
        });

        Node sit=candidate.get(0);
        map[sit.y][sit.x]=arr[index][0];
        candidate.clear();
    }
    static void getSatisfied(){
        for(int y=0;y<N;y++){
            for(int x=0;x<N;x++){
                int like=0;
                int index=0;
                int num=map[y][x];
                for(int i=0;i<4;i++){
                    int yy=y+dydx[i][0];
                    int xx=x+dydx[i][1];
                    if(yy<0||xx<0 ||yy>=N||xx>=N) continue;
                    for(int j=0;j<people;j++){
                        if(arr[j][0]==num){
                            index=j;
                            break;
                        }
                    }
                    if(isLike(map[yy][xx], index)){
                        like++;
                    }
                }
                satisfied+=point[like];
            }
        }
    }
}
