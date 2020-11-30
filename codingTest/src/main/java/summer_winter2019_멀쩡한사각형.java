import java.math.BigInteger;

public class summer_winter2019_멀쩡한사각형 {
    public static int gcd(int w, int h){
        BigInteger num1=BigInteger.valueOf(w);
        BigInteger num2=BigInteger.valueOf(h);
        BigInteger gcdValue=num1.gcd(num2);
        return gcdValue.intValue();
    }
    public static long solution(int w, int h) {
        long answer = -1;
        long whole=(long)w*(long)h;
        long  broken=w+h-gcd(w,h);
        answer=whole-broken;

        return answer;
    }

    public static void main(String [] args){
        //100000000, 999999999
        int w=8;
        int h=12;
        long answer=solution(w, h);
        System.out.println(answer);
    }
}
