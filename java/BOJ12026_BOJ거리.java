package 백준특강;
import java.util.*;

public class BOJ12026_BOJ거리 {
    static int[] arr;
    static int[]dp;
    static int N;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        N=scan.nextInt();
        arr=new int[N];
        dp=new int[N];
        String input=scan.next();
        for(int i=0;i<N;i++){
            switch(input.charAt(i)){
                case 'B':
                    arr[i]=0;
                    break;
                case 'O':
                    arr[i]=1;
                    break;
                case 'J':
                    arr[i]=2;
                    break;
            }
        }
        solution();
        System.out.println(dp[N-1]);
    }
    static void solution(){
        Arrays.fill(dp, -1);
        dp[0]=0;

        for(int i=1;i<N;i++){
            int find=(arr[i]+2)%3;
            for(int j=0;j<i;j++){
                if(dp[j]!=-1 && arr[j]==find){
                    dp[i]=Math.min(dp[i], dp[j]+(int)Math.pow(j-i,2));
                    if(dp[i]==-1){
                        dp[i]=dp[j]+(int)Math.pow(j-i,2);
                    }
                }
            }
        }
    }
}
