package samsung_algo;
import java.util.*;
import java.io.*;
public class BOJ17779_게리맨더링2 {
	static int N;
	static int[][]map, locate;
	static int minDiff=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		locate=new int[N][N];
		
		for(int y=0;y<N;y++) {
			st=new StringTokenizer(br.readLine());
			for(int x=0;x<N;x++) {
				map[y][x]=Integer.parseInt(st.nextToken());
			}
		}
		solution();
		System.out.println(minDiff);
	}
	
	static void solution() {
		for(int x=0;x<N-2;x++) {
			for(int y=1;y<N-1;y++) {
				for(int d1=1;d1<N-1;d1++) {
					for(int d2=1;d2<N-1;d2++) {
						if(y-d1<0 || y+d2>=N || x+d1+d2>=N)continue;
						setLocateFive(x, y, d1, d2);
						setLocateAll(x, y, d1, d2);
						int diff=getDiff();
						if(minDiff>diff) {
							minDiff=diff;
						}
						locate=new int[N][N];
					}
				}
			}
		}
	}
	
	static void setLocateFive(int x, int y, int d1, int d2) {
		for(int i=0;i<=d1;i++) {
			locate[x+i][y-i]=5;
			locate[x+d2+i][y+d2-i]=5;
		}
		for(int i=0;i<=d2;i++) {
			locate[x+i][y+i]=5;
			locate[x+d1+i][y-d1+i]=5;
		}
		
		int level=d1+d2;
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				if(locate[r][c]==5) {
					fillFive(r, c, level);
					return;
				}
			}
		}
	}
	
	static void fillFive(int r, int c, int level) {
		for(int y=r+1;y<r+level;y++) {
			boolean start=false;
			for(int x=0;x<N-1;x++) {
				if(locate[y][x]==5 && !start) {
					start=true;
				}else if(locate[y][x]==5 && start) {
					break;
				}else if(start) {
					locate[y][x]=5;
				}
			}
		}
	}
	
	static void setLocateAll(int x, int y, int d1, int d2) {
		for(int r=0;r<x+d1;r++) {
			for(int c=0;c<=y;c++) {
				if(locate[r][c]>0)continue;
				locate[r][c]=1;
			}
		
		}
		for(int r=0;r<=x+d2;r++) {
			for(int c=y+1;c<=N-1;c++) {
				if(locate[r][c]>0)continue;
				locate[r][c]=2;
			}
		}
		for(int r=x+d1;r<=N-1;r++) {
			for(int c=0;c<y-d1+d2;c++) {
				if(locate[r][c]>0)continue;
				locate[r][c]=3;
			}
		}
		for(int r=x+d2+1;r<=N-1;r++) {
			for(int c=y-d1+d2;c<=N-1;c++) {
				if(locate[r][c]>0)continue;
				locate[r][c]=4;
			}
		}
	}
	
	static int getDiff() {
		int min=Integer.MAX_VALUE;
		int max=0;
		int[]sum=new int[6];
		for(int y=0;y<N;y++) {
			for(int x=0;x<N;x++) {
				int loc=locate[y][x];
				sum[loc]+=map[y][x];
			}
		}
		
		for(int i=1;i<=5;i++) {
			if(sum[i]<min) {
				min=sum[i];
			}
			if(sum[i]>max) {
				max=sum[i];
			}
		}
		return max-min;
	}

}
