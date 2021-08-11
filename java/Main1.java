package scofe2021;

import java.util.*;
import java.io.*;
public class Main1 {
    static int N;
    static String[]start,end;
    static StringBuilder answer=new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N=Integer.parseInt(br.readLine());
        start=new String[N];
        end=new String[N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            start[i]=st.nextToken();
            st.nextToken();
            end[i]=st.nextToken();
        }
        answer.append("-1");
        solution();
        System.out.println(answer);
    }
    static void solution(){
        String startTime="00:00";
        String endTime="23:59";
      // System.out.println("12:00".compareTo("14:00"));
        for(int i=0;i<N;i++){
            if(startTime.compareTo(start[i])<=-1){
                startTime=start[i];
            }
        }

        for(int i=0;i<N;i++){
            if(startTime.compareTo(end[i])==1){
               return;
            }
            if(endTime.compareTo(end[i])>=1){
                endTime=end[i];
            }
        }

        answer.delete(0, answer.length());
        answer.append(startTime+" ~ "+endTime);
    }

}
