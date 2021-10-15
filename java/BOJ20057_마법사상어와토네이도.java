package samsung_algo;

import java.util.*;
import java.io.*;
public class BOJ20057_마법사상어와토네이도 {
	static int N;
	static int out;
	static int[][]map;
	static int[][]dydx= {
			{0,-1},//좌
			{1,0},//하
			{0,1},//우
			{-1,0},//상
	};
	static int[][][]tornado= {
			{//좌
				{-1,1,1},
				{1,1,1},
				{-1,0,7},
				{1,0,7},
				{-2,0,2},
				{2,0,2},
				{-1,-1,10},
				{1,-1,10},
				{0,-2,5},
				{0,-1,0},//a자리
			},
			{//하
				{-1,-1,1},
				{-1,1,1},
				{0,-1,7},
				{0,1,7},
				{0,-2,2},
				{0,2,2},
				{1,-1,10},
				{1,1,10},
				{2,0,5},
				{1,0,0},
			},
			{//우
				{-1,-1,1},
				{1,-1,1},
				{-1,0,7},
				{1,0,7},
				{-2,0,2},
				{2,0,2},
				{-1,1,10},
				{1,1,10},
				{0,2,5},
				{0,1,0},
			},
			{//상
				{1,-1,1},
				{1,1,1},
				{0,-1,7},
				{0,1,7},
				{0,-2,2},
				{0,2,2},
				{-1,-1,10},
				{-1,1,10},
				{-2,0,5},
				{-1,0,0},
			},
	};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		
		for(int y=0;y<N;y++) {
			st=new StringTokenizer(br.readLine());
			for(int x=0;x<N;x++) {
				map[y][x]=Integer.parseInt(st.nextToken());
			}
		}
		solution();
		System.out.println(out);
	}
	
	static void solution() {
		int y=N/2;
		int x=N/2;
		int temp=1;
		int count=0, direct=0;
		while(y!=0 || x!=0) {
			count++;
			for(int i=0;i<temp;i++) {
				y=y+dydx[direct][0];
				x=x+dydx[direct][1];
				moveSand(y,x, direct);
				if(y==0 && x==0)return;
			}
			if(count%2==0) {
				
				temp++;
			}
			direct=(direct+1)%4;
		}
	}
	
	static void moveSand(int y, int x, int direct) {
		int sand=map[y][x];
		for(int i=0;i<9;i++) {
			int yy=y+tornado[direct][i][0];
			int xx=x+tornado[direct][i][1];
			
			int move=(int)(sand*(tornado[direct][i][2]/100.0));
			if(move==0)continue;
			if(yy<0||xx<0||yy>=N||xx>=N) {// map범위 밖이면 out에 더하기
				out+=move;
			}else {
				map[yy][xx]+=move;
			}
			map[y][x]-=move;
		}
		//a 자리로 옮기기
		int yy=y+tornado[direct][9][0];
		int xx=x+tornado[direct][9][1];
		
		int move=map[y][x];
		if(yy<0||xx<0||yy>=N||xx>=N) {// map범위 밖이면 out에 더하기
			out+=move;
		}else {
			map[yy][xx]+=move;
		}
		map[y][x]=0;
	}
}
