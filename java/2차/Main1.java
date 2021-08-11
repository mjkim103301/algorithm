package scofe2021_2차;

import java.util.*;
import java.io.*;
public class Main1 {
    static int N;
    static int practiceTime;
    static int[]playList;
    static int answerNum, answerIndex;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        String time=st.nextToken();
        int h=Integer.parseInt(time.substring(0,2));
        int m=Integer.parseInt(time.substring(3,5));
        int s=Integer.parseInt(time.substring(6));
        practiceTime=h*3600+m*60+s;

        playList=new int[N];
        for(int i=0;i<N;i++){
            String music=br.readLine();
            int mm=Integer.parseInt(music.substring(0,2));
            int ss=Integer.parseInt(music.substring(3));
            playList[i]=mm*60+ss;
        }
       solution();
        System.out.println(answerNum+" "+ answerIndex);
    }
    static void solution(){
        int musicIndex=0,musicCnt=0;
        int tempIndex=0,tempPracTime=0;
        int deleteIndex=0;
        while(musicIndex<N){
            if(tempPracTime<practiceTime) {
                tempPracTime += playList[musicIndex++];
                musicCnt++;
                if (musicCnt > answerNum) {
                    answerNum = musicCnt;
                    answerIndex = deleteIndex + 1;
                }
            }else{
                tempPracTime-=playList[deleteIndex++];
                musicCnt--;
            }
        }
    }
}
