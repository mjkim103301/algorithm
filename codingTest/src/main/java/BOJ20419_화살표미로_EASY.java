package baekjoon.level_gold;

import java.util.*;
import java.io.*;

class Node{
    int y,x;
    int [] rotateCard;
    public Node(int y, int x, int []rotateCard){
        this.y=y;
        this.x=x;
        this.rotateCard=rotateCard;
    }
}
public class BOJ20419_화살표미로_EASY {
    static String dir="URDL";
    static int[][]dydx={
            {-1,0},
            {0,1},
            {1,0},
            {0,-1}
    };
    static int[]rotateCard={0,1,0,1}; //오른쪽 왼쪽 카드 1개씩
    static boolean [][]visited;
    static char[][]map;
    static int R,C,K;
    static  Queue<Node> queue;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []size=br.readLine().split(" ");
        R=parse(size[0]);
        C=parse(size[1]);
        K=parse(size[2]);

        map=new char[R][C];
        visited=new boolean[R][C];
        for(int y=0;y<R;y++){
            map[y]=br.readLine().toCharArray();
        }
        if(K==0){
            Arrays.fill(rotateCard, 0);
        }
        System.out.println(solution()?"Yes":"No");
    }
    static int parse(String s){
        return Integer.parseInt(s);
    }
    static boolean pushOrigin(Node now, int direct) {
        int[] rotate=Arrays.copyOf(now.rotateCard, 4);
        int y = now.y + dydx[direct][0];
        int x = now.x + dydx[direct][1];

        if (y < 0 || x < 0 || y >= R || x >= C) return false;
        if (visited[y][x]) return false;
        if (y == R - 1 && x == C - 1) {
            return true;
        }
        //visited[y][x] = true;

        queue.offer(new Node(y, x, rotate));
        return false;
    }
    static boolean pushTurnRight(Node now, int direct) {
        int[] rotate = Arrays.copyOf(now.rotateCard, 4);
        if(rotate[1]==0) return false;
        rotate[1]--;
        direct = (direct + 1) % 4;

        int y = now.y + dydx[direct][0];
        int x = now.x + dydx[direct][1];

        if (y < 0 || x < 0 || y >= R || x >= C) return false;
        if (visited[y][x]) return false;
        if (y == R - 1 && x == C - 1) {
            return true;
        }
       // visited[y][x] = true;

        queue.offer(new Node(y, x, rotate));
        return false;
    }
    static boolean pushTurnLeft(Node now, int direct) {
        int[] rotate = Arrays.copyOf(now.rotateCard, 4);
        if(rotate[3]==0) return false;
        rotate[3]--;
        direct = (direct + 3) % 4;

        int y = now.y + dydx[direct][0];
        int x = now.x + dydx[direct][1];

        if (y < 0 || x < 0 || y >= R || x >= C) return false;
        if (visited[y][x]) return false;
        if (y == R - 1 && x == C - 1) {
            return true;
        }
        //visited[y][x] = true;

        queue.offer(new Node(y, x, rotate));
        return false;
    }
    static boolean solution(){
        queue=new ArrayDeque<>();
        queue.offer(new Node(0,0,rotateCard));
        visited[0][0]=true;
        if (0 == R - 1 && 0 == C - 1) {
            return true;
        }
        while(!queue.isEmpty()){
            Node now=queue.poll();
            visited[now.y][now.x]=true;
            int direct=dir.indexOf(map[now.y][now.x]);

            if(pushOrigin(now, direct) || pushTurnRight(now, direct)||pushTurnLeft(now, direct)){
                return true;
            }
        }
        return false;
    }
}
