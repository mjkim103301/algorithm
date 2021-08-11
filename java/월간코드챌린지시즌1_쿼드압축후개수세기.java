
public class 월간코드챌린지시즌1_쿼드압축후개수세기 {
    static int zeroCnt=0, oneCnt=0;
    static int[][]map;
    public static void mergeSort2(int x1, int y1, int x2, int y2){
        int first=map[y1][x1];
        int tempCnt=0;
        for(int y=y1;y<=y2;y++){
            for(int x=x1;x<=x2;x++){
                if(map[y][x]==1){
                    tempCnt++;
                }
            }
        }
        int range=(x2-x1+1)*(y2-y1+1);
        if(range==tempCnt){
            oneCnt++;
        }else if(tempCnt==0){
            zeroCnt++;
        }else{
            int midX=(x2-x1)/2;
            int midY=(y2-y1)/2;
            mergeSort2(x1, y1, x1+midX, y1+midY);
            mergeSort2(x1+midX+1, y1, x2, y1+midY);
            mergeSort2(x1, y1+midY+1, x1+midX, y2);
            mergeSort2(x1+midX+1, y1+midY+1, x2, y2);
        }

    }
    public static int[] solution(int[][] arr) {
        int[] answer;
        map=arr;
        int len=arr.length;
        mergeSort2(0,0,len-1, len-1);
        answer=new int[]{zeroCnt, oneCnt};
        return answer;
    }
    public static void main(String[] args){
        int[][]arr={
                {1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}
        };
        int [][]arr2={
                {1,1,1,1,1,1,1,1},
                {0,1,1,1,1,1,1,1},
                {0,0,0,0,1,1,1,1},
                {0,1,0,0,1,1,1,1},
                {0,0,0,0,0,0,1,1},
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,1,0,0,1},
                {0,0,0,0,1,1,1,1}
        };
        int [] ans=solution(arr2);
        System.out.println(ans[0]);//0 개수
        System.out.println(ans[1]);//1 개수
    }
}
