package ssafy.algo.study.week01;
import java.io.*;
import java.util.*;
public class BOJ1182_부분수열의합 {
    static int N;
    static int target;
    static int cnt;
    static int[] nums;
    static int last;
    static void recursion(int now, int index, int sum){
        if(now==last){
            if(sum==target){
                cnt++;
            }
            return;
        }
        for(int i=index;i<N;i++){
            recursion(now+1, i+1,sum+nums[i]);
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader sb=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(sb.readLine());
        N=Integer.parseInt(st.nextToken());
        target=Integer.parseInt(st.nextToken());
        nums=new int[N];
        st=new StringTokenizer(sb.readLine());
        for(int i=0;i<N;i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }

        for(int j=1;j<=N;j++){
            last=j;
            recursion(0,0, 0);
        }

        System.out.println(cnt);
    }
}
