package ssafy_a;
import java.util.*;
public class JUNGOL1169_주사위던지기1 {
	static int N,M;
	static int[]pick;
	static boolean[] used;
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		M=scan.nextInt();
		pick=new int[N];
		used=new boolean[7];
		solution();
	}
	
	static void solution() {
		if(M==1) {
			duplicatePermutation(0);
		}else if(M==2) {
			permutation1(0, 1);
		}else if(M==3) {
			permutation2(0);
		}
	}
	
	static void duplicatePermutation(int level) {
		if(level==N) {
			print();
			return;
		}
		for(int i=1;i<=6;i++) {
			pick[level]=i;
			duplicatePermutation(level+1);
		}
	}
	
	static void permutation1(int level, int start) {
		if(level==N) {
			print();
			return;
		}
		for(int i=start;i<=6;i++) {
			pick[level]=i;
			permutation1(level+1, i);
		}
	}
	
	static void permutation2(int level) {
		if(level==N) {
			print();
			return;
		}
		for(int i=1;i<=6;i++) {
			if(used[i])continue;
			used[i]=true;
			pick[level]=i;
			permutation2(level+1);
			used[i]=false;
		}
	}
	
	static void print() {
		for(int i=0;i<N;i++) {
			System.out.print(pick[i]+" ");
		}
		System.out.println();
	}

}
