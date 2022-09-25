package baekjoon.level_bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2675_문자열반복 {
    static int T, R;
    static String target;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            st=new StringTokenizer(br.readLine());
            R=Integer.parseInt(st.nextToken());
            target=st.nextToken();
            System.out.println(solution());
        }
    }
    static String solution(){
        String answer="";
        for(int i=0;i<target.length();i++){
            for(int j=0;j<R;j++){
                answer+=target.charAt(i);
            }
        }
        return answer;
    }
}
