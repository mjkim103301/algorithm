package samsung_algo;

import java.util.*;
import java.io.*;
public class BOJ20058_마법사상어와파이어스톰 {
	static int N,Q,size;
	static int[][]map, temp;
	static boolean[][]visit;
	static int[]L;
	static int[][]dydx= {
			{1,0},
			{-1,0},
			{0,1},
			{0,-1},
	};
	static int sum, maxCnt;
	static ArrayList<int[]> queue=new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		size=(int)Math.pow(2, N);
		
		map=new int[size][size];
		temp=new int[size][size];
		visit=new boolean[size][size];
		L=new int[Q];
		
		for(int y=0;y<size;y++) {
			st=new StringTokenizer(br.readLine());
			for(int x=0;x<size;x++) {
				map[y][x]=Integer.parseInt(st.nextToken());
			}
		}
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<Q;i++) {
			L[i]=Integer.parseInt(st.nextToken());
		}
		
		solution();
		System.out.println(sum);
		System.out.println(maxCnt);
	}
	
	static void solution() {
		for(int i=0;i<Q;i++) {
			rotate(L[i]);
			firestorm();
		}
		getSum();
		getBiggestCnt();
	}
	
	static void rotate(int l) {
		int length=(int)Math.pow(2,l);
		for(int y=0;y<size;y+=length) {
			for(int x=0;x<size;x+=length) {
				for(int yy=y;yy<y+length;yy++) {
					for(int xx=x;xx<x+length;xx++) {
						int mapY=y+x+length-1-xx;
						int mapX=x+yy-y;
						temp[yy][xx]=map[mapY][mapX];
					}
				}
			}
		}
		map=temp;
		temp=new int[size][size];
	}
	
	static void firestorm() {
		queue.clear();
		for(int y=0;y<size;y++) {
			for(int x=0;x<size;x++) {
				if(map[y][x]==0)continue;
				int iceCnt=0;
				for(int i=0;i<4;i++) {
					int yy=y+dydx[i][0];
					int xx=x+dydx[i][1];
					if(yy<0||xx<0||yy>=size||xx>=size)continue;
					if(map[yy][xx]>0) {
						iceCnt++;
					}
				}
				
				if(iceCnt<3) {
					queue.add(new int[] {y,x});
				}
			}
		}
		
		for(int i=0, size=queue.size();i<size;i++) {
			int[]now=queue.get(i);
			map[now[0]][now[1]]--;
		}
	}
	
	static void getSum() {
		for(int y=0;y<size;y++) {
			for(int x=0;x<size;x++) {
				sum+=map[y][x];
			}
		}
	}
	
	static void getBiggestCnt() {
		for(int y=0;y<size;y++) {
			for(int x=0;x<size;x++) {
				if(visit[y][x])continue;
				if(map[y][x]==0) {
					visit[y][x]=true;
					continue;
				}
				bfs(y, x);
			}
		}
	}
	
	static void bfs(int y, int x) {
		visit[y][x]=true;
		queue.clear();
		queue.add(new int[] {y,x});
		int index=0;
		
		while(index<queue.size()) {
			int[]now=queue.get(index);
			for(int i=0;i<4;i++) {
				int yy=now[0]+dydx[i][0];
				int xx=now[1]+dydx[i][1];
				if(yy<0||xx<0||yy>=size||xx>=size)continue;
				if(visit[yy][xx] || map[yy][xx]==0) continue;
				visit[yy][xx]=true;
				
				queue.add(new int[] {yy,xx});
			}
			index++;
		}
		
		int cnt=queue.size();
		if(cnt>maxCnt) {
			maxCnt=cnt;
		}
	
	}
	
}
