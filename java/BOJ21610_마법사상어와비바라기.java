package samsung_algo;

import java.util.*;
import java.io.*;
public class BOJ21610_마법사상어와비바라기 {
	static int N,M;
	static class Node{
		int cloudLevel;
		int water;
		public Node(int cloudLevel, int water) {
			this.cloudLevel=cloudLevel;
			this.water=water;
		}
	}
	static Node[][]map;
	static int[][]move;
	static int[][]dydx= {
			{},
			{0,-1},
			{-1,-1},
			{-1,0},
			{-1,1},
			{0,1},
			{1,1},
			{1,0},
			{1,-1},
	};
	static int sum;
	static ArrayList<int[]> temp=new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new Node[N][N];
		move=new int[M][2];
		for(int y=0;y<N;y++) {
			st=new StringTokenizer(br.readLine());
			for(int x=0;x<N;x++) {
				map[y][x]=new Node(-1,Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int y=0;y<M;y++) {
			st=new StringTokenizer(br.readLine());
			move[y][0]=Integer.parseInt(st.nextToken());
			move[y][1]=Integer.parseInt(st.nextToken());
		}
		solution();
		System.out.println(sum);
	}
	
	static void solution() {
		map[N-2][0].cloudLevel=0;
		map[N-2][1].cloudLevel=0;
		map[N-1][0].cloudLevel=0;
		map[N-1][1].cloudLevel=0;
		
		for(int i=0;i<M;i++) {
			//print(i, "first");
			moveCloud(i);
			//print(i,"after moveCloud and plus water");
			plusWaterDiagonal(i);
			//print(i,"after plusWaterDiagonal");
			makeCloud(i);
			//print(i,"after makeCloud");
		}
		getSumWater();
	}
	
	static void plus1(int level) {
		for(int y=0;y<N;y++) {
			for(int x=0;x<N;x++) {
				if(map[y][x].cloudLevel!=level) continue;		
				map[y][x].water++;
			}
		}
	}
	
	static void moveCloud(int level) {
		int d=move[level][0];
		int s=move[level][1];
		s%=N;
		if(s==0) {
			plus1(level);
			return;
		}
		temp.clear();
		for(int y=0;y<N;y++) {
			for(int x=0;x<N;x++) {
				if(map[y][x].cloudLevel!=level) continue;				
				int nowY=y;
				int nowX=x;
				for(int i=0;i<s;i++) {
					int yy=nowY+=dydx[d][0];
					int xx=nowX+=dydx[d][1];
					if(yy<0) {
						yy=N-1;
					}else if(yy>=N) {
						yy=0;
					}
					if(xx<0) {
						xx=N-1;
					}else if(xx>=N) {
						xx=0;
					}
					nowY=yy;
					nowX=xx;
				}
				temp.add(new int[] {nowY, nowX});
				map[y][x].cloudLevel--;
				
			}
		}
		int size=temp.size();
		for(int i=0;i<size;i++) {
			int[]location=temp.get(i);
			map[location[0]][location[1]].cloudLevel=level;
			map[location[0]][location[1]].water++;
		}
	}
	
	
	static void plusWaterDiagonal(int level) {
		for(int y=0;y<N;y++) {
			for(int x=0;x<N;x++) {
				if(map[y][x].cloudLevel==level) {
					int cnt=0;
					for(int d=2;d<=8;d+=2) {
						int yy=y+dydx[d][0];
						int xx=x+dydx[d][1];
						if(yy<0||xx<0||yy>=N||xx>=N)continue;
						if(map[yy][xx].water>0) {
							cnt++;
						}
					}
					map[y][x].water+=cnt;
				}
			}
		}
	}
	
	static void makeCloud(int level) {
		for(int y=0;y<N;y++) {
			for(int x=0;x<N;x++) {
				if(map[y][x].cloudLevel==level) continue;
				if(map[y][x].water>=2) {
					map[y][x].water-=2;
					map[y][x].cloudLevel=level+1;
				}
			}
		}
	}
	
	static void getSumWater() {
		sum=0;
		for(int y=0;y<N;y++) {
			for(int x=0;x<N;x++) {
				sum+=map[y][x].water;
			}
		}
	}
	
//	static void print(int level, String message) {
//		System.out.println("=========== level: "+ level+" message: "+message+ "============");
//		for(int y=0;y<N;y++) {
//			for(int x=0;x<N;x++) {
//				System.out.print("{" +map[y][x].cloudLevel+" "+map[y][x].water+"} ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

}
