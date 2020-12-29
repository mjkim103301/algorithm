package level2;

import java.util.LinkedList;
import java.util.Queue;

public class kakao_code_qualify_kakaoFriendsColoringBook {
    public static void main(String[]args){
        Solution_coloringBook sol=new Solution_coloringBook();
        int m=6;
        int n=4;
        int[][] picture={{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
        int []ans=sol.solution(m, n, picture);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }

}
class Node{
    int y,x;
    public Node(int y, int x){
        this.y=y;
        this.x=x;
    }
}
class Solution_coloringBook {
    int [][]map;
    int [][]move={
            {0,1},{0,-1},{1,0},{-1,0}
    };
    int startY, startX, startColor;
    Queue<Node> queue=new LinkedList<>();
    int M,N;
    boolean findStart(){
        for(int y=0;y<M;y++){
            for(int x=0;x<N;x++){
                if(map[y][x]>0){
                    startY=y;
                    startX=x;
                    startColor=map[y][x];
                    map[y][x]=0;
                    return true;
                }
            }
        }
        return false;
    }
    int findArea(){
        queue.add(new Node(startY, startX));
        int area=1;
        while(!queue.isEmpty()){
            Node now=queue.peek();
            queue.remove();
            for(int i=0;i<4;i++){
                int y=now.y+move[i][0];
                int x=now.x+move[i][1];
                if(y<0||x<0||y>=M||x>=N)continue;
                if(map[y][x]==startColor){
                    map[y][x]=0;
                    queue.add(new Node(y,x));
                    area++;
                }
            }
        }
        return area;
    }
    void init(int[][]picture){
        for(int y=0;y<M;y++){
            for(int x=0;x<N;x++){
                map[y][x]=picture[y][x];
            }
        }
    }
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        map=new int[m][n];
        M=m;
        N=n;
        init(picture);
        while(findStart()==true){
            numberOfArea++;
            int area=findArea();
            if(area>maxSizeOfOneArea){
                maxSizeOfOneArea=area;
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
