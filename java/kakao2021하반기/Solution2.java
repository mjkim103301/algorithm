package kakao2021하반기;

import java.math.BigInteger;
import java.util.*;

public class Solution2 {
    static String change="";
    static int changeSize;
    static int answer;
    public static int solution(int n, int k) {
        // k 진수로 변환
        changeToK(n, k);

        // change를 돌면서 0발견하면 바로 소수인지 판별
        checkPrime();
        return answer;
    }

    static void changeToK(int n, int k){
        while(n>0){
            change=(n%k)+change;
            n/=k;
        }
       // System.out.println(change);
    }

    static void checkPrime(){
        changeSize=change.length();
        BigInteger value;
        for(int i=0;i<changeSize;i++){
            int index=change.indexOf("0", i);
            if(index==-1){
                index=changeSize;
            }else if(i==index){
                i=index;
                continue;
            }
            value=new BigInteger(change.substring(i, index));

           if(value.isProbablePrime(10)){
               answer++;
           }
            i=index;
        }
    }

    public static void main(String[] args) {
        int n=110011;
        int k=10;
        int ans=solution(n,k);
        System.out.println(ans);
    }
}
