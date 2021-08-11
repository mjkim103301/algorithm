package ssafy.algo.study.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class Node{ // target 의 좌표 저장. y: 세로, x: 가로
    int y,x;
    public Node(int y, int x){
        this.y=y;
        this.x=x;
    }
}

public class BOJ1303_전쟁_전투 {
    static int N,M;
    static char[][]map;
    static boolean[][]visited;
    static int[][]dir={
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };

    static Queue<Node> queue=new ArrayDeque<>();

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] size=br.readLine().split(" ");
        N=Integer.parseInt(size[0]);
        M=Integer.parseInt(size[1]);

        map=new char[M][N];
        for(int y=0;y<M;y++){
            String line=br.readLine();
            for(int x=0;x<N;x++){
                map[y][x]=line.charAt(x);
            }
        }

        int [] answer=solution();
        System.out.println(answer[0]+" "+answer[1]);
    }

    static int[]solution(){
        int[] ans=new int[2]; // 답을 배열에 저장
        ans[0]=strength('W'); // 우리 병사의 위력
        ans[1]=strength('B'); // 적국 병사의 위력
        return ans;
    }

    static int strength(char target){
        int cnt=0;
        visited=new boolean[M][N]; // visited 배열 생성
        for(int y=0;y<M;y++){
            for(int x=0;x<N;x++){
                if( !visited[y][x] && map[y][x]==target){ //방문하지 않았고, map의 요소가 target이면
                    queue.offer(new Node(y, x)); //큐에 첫번째 요소를 넣음
                    visited[y][x]=true;  // 방문 체크
                    cnt+=Math.pow(bfs(target), 2); // bfs를 통해 target의 개수를 세고 (tempCnt)^2
                }
            }
        }
        return cnt;
    }

    static int bfs(char target){
        int tempCnt=0;
        while(!queue.isEmpty()){
            tempCnt++; // 큐에서 꺼낼 때마다 target의 개수 ++
            Node now=queue.poll();

            for(int i=0;i<4;i++){
                int y=now.y+dir[i][0];
                int x=now.x+dir[i][1];
                if(y<0|| x<0 || y>=M || x>=N)continue;
                if(visited[y][x] || map[y][x]!=target) continue;
                visited[y][x]=true;
                queue.offer(new Node(y, x));
            }
        }
        return tempCnt;
    }
}
