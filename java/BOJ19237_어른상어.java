package samsung_algo;

import java.util.*;
import java.io.*;
public class BOJ19237_어른상어 {
	static int N,M,k;
	static class Node{
		int num,scent;
		boolean isIn;
		public Node() {}
		public Node(int num, int scent, boolean isIn) {
			this.num=num;
			this.scent=scent;
			this.isIn=isIn;
		}
	}
	static Node[][]map, temp;
	static int[][]dydx= {
			{},
			{-1,0},
			{1,0},
			{0,-1},
			{0,1},
	};
	static int [][][] shark;
	static int[]direct;
	static int answer=-1, alive, time;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		map=new Node[N][N];
		temp=new Node[N][N];
		shark=new int[M+1][5][4];
		alive=M;
		direct=new int[M+1];
		
		for(int y=0;y<N;y++) {
			st=new StringTokenizer(br.readLine());
			for(int x=0;x<N;x++) {
				map[y][x]=new Node(Integer.parseInt(st.nextToken()), 0, false);
				temp[y][x]=new Node();
				if(map[y][x].num>0) {
					map[y][x].scent=k;
					map[y][x].isIn=true;
				}
			}
		}
		
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=M;i++) {
			direct[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=M;i++) {
			for(int j=1;j<=4;j++) {
				st=new StringTokenizer(br.readLine());
				for(int k=0;k<4;k++) {
					shark[i][j][k]=Integer.parseInt(st.nextToken());
				}
			}
		}
		solution();
		System.out.println(answer);
	}
	
	static void solution() {
		while(alive>1) {
			time++;
			//System.out.println("time: "+time);
			//print("before move");
			moveShark();
			//print("after move");
			decrease();
			//print("decrease");
			if(time>=1000 && alive>1) {
				return;
			}
		}
		
		answer=time;
	}
	
	static void print(String message) {
		System.out.println("===="+message+"====");

		for(int y=0;y<N;y++) {
			for(int x=0;x<N;x++) {
				System.out.print("{ "+map[y][x].num+" "+map[y][x].scent+" } ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static void moveShark() {
		for(int y=0;y<N;y++) {
			for(int x=0;x<N;x++) {
				if(map[y][x].isIn) {
					//다음 칸이 비어있는지
					if(!moveToEmpty(map[y][x], y, x) ){
						//내 냄새있는 칸으로 이동
						moveToMyScent(map[y][x], y, x);
					}
					map[y][x].isIn=false;
					if(alive==1) {
						return;
					}
				}
			}
		}
		//temp에서 상어를 map으로 이동시키기
		for(int y=0;y<N;y++) {
			for(int x=0;x<N;x++) {
				if(temp[y][x].isIn) {
					map[y][x]=temp[y][x];
					temp[y][x]=new Node();
				}
			}
		}
	}
	
	static boolean moveToEmpty(Node target, int y, int x) {
		int num=target.num;
		int d=direct[num];
		for(int i=0;i<4;i++) {
			int nd=shark[num][d][i];
			int ny=y+dydx[nd][0];
			int nx=x+dydx[nd][1];
			
			if(ny<0||nx<0||ny>=N||nx>=N)continue;
			if(map[ny][nx].scent>0)continue;
			if(temp[ny][nx].isIn) {
				if(temp[ny][nx].num>num) {//내가 더 작으면 먹음
					temp[ny][nx]=new Node(num, k, true);
				}//아니면 먹힘
				alive--;
			}else {
				temp[ny][nx]=new Node(num, k, true);
			}	
			direct[num]=nd;
			return true;
		}
		return false;
	}
	
	static void moveToMyScent(Node target, int y, int x) {
		int num=target.num;
		int d=direct[num];
		for(int i=0;i<4;i++) {
			int nd=shark[num][d][i];
			int ny=y+dydx[nd][0];
			int nx=x+dydx[nd][1];
			
			if(ny<0||nx<0||ny>=N||nx>=N)continue;
			if(map[ny][nx].num!=num) continue;	
			
			if(temp[ny][nx].isIn) {
				if(temp[ny][nx].num>num) {//내가 더 작으면 먹음
					temp[ny][nx]=new Node(num, k, true);
				}//아니면 먹힘
				alive--;
			}else {
				temp[ny][nx]=new Node(num, k, true);
			}	
			direct[num]=nd;
			return;
		}
	}
	
	static void decrease() {
		for(int y=0;y<N;y++) {
			for(int x=0;x<N;x++) {
				if(!map[y][x].isIn && map[y][x].scent>0) {
					map[y][x].scent--;
					if(map[y][x].scent==0) {
						map[y][x].num=0;
					}
				}
			}
		}
	}
}
