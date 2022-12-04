package baekjoon.silver;
import java.util.*;
import java.io.*;
public class BOJ1931_회의실배정 {
    static int N;
    static int[][]map;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        map=new int[N][2];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<2;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        
        solution();
        System.out.println(answer);
        
    }
    
    static void solution(){
        Arrays.sort(map, (i, j)->{
            if(i[1]!=j[1]){
                return i[1]-j[1];
            }else{
                return i[0]-j[0];
            }
        });

        int finish=0;
        for(int i=0;i<N;i++){
            if(finish<=map[i][0]){
                finish=map[i][1];
                answer++;
            }
        }
    }
}
