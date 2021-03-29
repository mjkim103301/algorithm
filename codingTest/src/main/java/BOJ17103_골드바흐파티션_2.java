package 백준특강;

import java.util.*;

// 에라토스테네스의 체
public class BOJ17103_골드바흐파티션_2 {
    static int N;
    static int MAX=1000000;
    static Set<Integer> set=new HashSet<>();
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int T=scan.nextInt();
        init();
        for(int i=1;i<=T;i++){
            N=scan.nextInt();
            System.out.println(getPartition());
        }
    }
    static void init(){
        for(int i=2;i<=MAX;i++){
            set.add(i);
        }
        for(int i=2;i<=MAX;i++){
            if(!set.contains(i))continue;
            for(int j=2;j*i<=MAX;j++){
                if(set.contains(j*i)){
                    set.remove(j*i);
                }

            }
        }
    }
    static int getPartition(){
        int cnt=0;
        int end=N/2;
        for(int i=2;i<=end;i++){
            if(isPrime(i)&& isPrime(N-i)){
                cnt++;
            }
        }
        return cnt;
    }
    static boolean isPrime(int num){
       if(set.contains(num)){
           return true;
       }
        return false;
    }
}
