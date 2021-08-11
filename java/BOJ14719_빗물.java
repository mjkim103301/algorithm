package ssafy.algo.study.week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14719_빗물 {
    static int H,W;
    static boolean[][]map;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        H=parse(st.nextToken());
        W=parse(st.nextToken());
        map=new boolean[H][W];

        st=new StringTokenizer(br.readLine());
        for(int x=0;x<W;x++){
            int wall=parse(st.nextToken());
            for(int y=H-1, end=H-1-wall;y>end;y--){
                map[y][x]=true; //벽인 부분을 true 로 만듦
            }
        }
        System.out.println(solution());
    }

    static int parse(String s){
        return Integer.parseInt(s);
    }

    static int solution(){
        int water=0; //빗물의 총량
        int tempWater; //y 행 돌면서 빗물 임시저장
        boolean wallStart; //벽인지 아닌지

        for(int y=0;y<H;y++){
            tempWater=0; // 임시저장할 빗물 0으로 초기화
            wallStart=false; //벽을 false로 초기화

            for(int x=0;x<W;x++){ //map의 y행 x열 순회
                boolean now=map[y][x]; //now= 현재 맵의 상태

                if(now && !wallStart) { //벽이 시작함을 체크
                    wallStart = true;
                }else if(!now && wallStart){ //벽 내부라면 tempWater++
                    tempWater++;
                }else if(now && wallStart){ //벽이 끝났을 때
                    water+=tempWater; // 빗물 총량에 임시저장한 빗물 더함
                    tempWater=0; //임시저장한 빗물 0으로 초기화
                }
            }
        }
        return water;
    }
}
