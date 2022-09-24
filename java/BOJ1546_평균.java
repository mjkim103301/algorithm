package baekjoon.level_bronze;
import java.io.*;
import java.util.StringTokenizer;

public class BOJ1546_평균 {
    static int num, max;
    static int[] scores;
    static double average;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        num=Integer.parseInt(br.readLine());
        scores=new int[num];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<num;i++){
            scores[i]=Integer.parseInt(st.nextToken());
            if(max<scores[i]){
                max=scores[i];
            }
        }

        double sum=0;
        for(int i=0;i<num;i++){
            sum+=scores[i]/(double)max*100;
        }
        average=sum/num;
        System.out.println(average);

    }
}
