package baekjoon.silver;
import java.util.*;
import java.io.*;
public class BOJ2805_나무자르기_2 {
    static int N,M;
    static int answer, maxHeight;
    static int[]tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        tree=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            tree[i]=Integer.parseInt(st.nextToken());
            if(tree[i]>maxHeight){
                maxHeight=tree[i];
            }
        }

        solution();
        System.out.println(answer);
    }

    static void solution(){
        long start=0;
        long end=maxHeight-1;
        while(start<=end){
            long mid=(start+end)/2;
            long canGetLength=cutTree(mid);
            if(canGetLength<M){
                end=mid-1;
            }else {
                start=mid+1;
                answer=(int)mid;
            }
        }
    }

    static long cutTree(long mid){
        long standard=mid;
        long cut=0;
        for(int i=0;i<N;i++){
            long diff=tree[i]-standard;
            if(diff>=0){
                cut+=diff;
            }

        }
        return cut;
    }
}
