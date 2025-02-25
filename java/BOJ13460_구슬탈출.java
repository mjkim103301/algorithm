package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class R1{
    int y,x;
    public R1(){}
    public R1(int y, int x){
        this.y=y;
        this.x=x;
    }
}

class B1{
    int y,x;
    public B1(){}
    public B1(int y, int x){
        this.y=y;
        this.x=x;
    }
}

public class BOJ13460_구슬탈출 {
    static int []dirY={1,0,-1,0};
    static int []dirX={0,1,0,-1};
    static char[][]map;
    static int []path=new int[11];
    static int H, W;
    static R1 r;
    static B1 b;
    static R1[] rPath=new R1[11];
    static B1[] bPath=new B1[11];
    static int min=11;

    static int moveR1(int dir, int now){
        int isOut=-1;
        int check=0;

        while(true){

            int y=rPath[now].y+dirY[dir];
            int x=rPath[now].x+dirX[dir];
            if(y<1 || x<1 || y>=H-1 || x>=W-1){
                break;
            }
            if((y==bPath[now].y) && (x==bPath[now].x)){
                if(check==0){
                    moveB1(dir, now);
                    check=1;
                }else{
                    break;
                }
            }
            else if(map[y][x]=='.'){
                rPath[now].y=y;
                rPath[now].x=x;

            }else if(map[y][x]=='O'){
                rPath[now].y=0;
                rPath[now].x=0;
               isOut=1;
               break;
            }else if(map[y][x]=='#'){
               break;
            }

        }
        return isOut;
    }

    static int moveB1(int dir, int now){
        int isOut=-1;

        while(true){

            int y=bPath[now].y+dirY[dir];
            int x=bPath[now].x+dirX[dir];

            if(y<1 || x<1 || y>=H-1 || x>=W-1){
               break;
            }
            if((y==rPath[now].y) && (x==rPath[now].x)){
               break;
            }else if(map[y][x]=='O'){
                bPath[now].y=0;
                bPath[now].x=0;
                isOut=1;
                break;
            }else if(map[y][x]=='#'){
               break;
            }else if(map[y][x]=='.'){
                bPath[now].y=y;
                bPath[now].x=x;

            }

        }
        return isOut;
    }

    static void init(){
        int cnt=0;
        for(int i=0;i<11;i++){
            rPath[i]=new R1();
            bPath[i]=new B1();
        }
        for(int y=0;y<H;y++){
            for(int x=0;x<W;x++){
                if(map[y][x]=='R'){
                    r=new R1(y, x);
                    map[y][x]='.';
                    cnt++;
                }else if(map[y][x]=='B'){
                    b=new B1(y, x);
                    map[y][x]='.';
                    cnt++;
                }
                if(cnt==2)break;
            }
        }
    }

    static void init2(int now){
        if(now>0){
            rPath[now] =new R1(rPath[now-1].y, rPath[now-1].x) ;
            bPath[now] = new B1(bPath[now - 1].y, bPath[now - 1].x);

        }else if(now==0){
            rPath[now]=new R1(r.y, r.x);
            bPath[now]=new B1(b.y, b.x);
        }
    }
    static boolean stop=false;
    static void solution(int now, int rr, int bb){
        if(bb==1){
            return;
        }else if(rr==1 && bb==-1){
            min=Math.min(min,now);
            stop=true;
            return;
        }
        if(now>=10 || now>=min){
            return;
        }
        init2(now);

        for(int i=0;i<4;i++){
            path[now]=i;
            rr=moveR1(i, now);
            bb=moveB1(i, now);
            if(bPath[now].y==0 && bPath[now].x==0){
                bb=1;
            }
            solution(now+1, rr, bb);
            if(stop){
                return;
            }
            init2(now);
            path[now]=0;

        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        H=Integer.parseInt(st.nextToken());
        W=Integer.parseInt(st.nextToken());
        map=new char[H][W];
        for(int y=0;y<H;y++){
            String line=br.readLine();
            for(int x=0;x<W;x++){
                map[y][x]=line.charAt(x);
            }
        }
        init();
        solution(0, 0, 0);
        int answer;
        if(min>10){
            answer=0;
        }else{
            answer=1;
        }
        System.out.println(answer);
    }
}
