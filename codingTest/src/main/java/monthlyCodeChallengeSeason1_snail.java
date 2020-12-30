package level2;

public class monthlyCodeChallengeSeason1_snail {
    public static void main(String [] args){
        int n=5;
        Solution_snail sol=new Solution_snail();
        int[]ans=sol.solution(n);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+", ");
        }
    }
}
class Solution_snail {
    int [][]map;
    void makeMap(int n){
        int y=-1;
        int x=0;
        int num=1;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                switch (i%3){
                    case 0:
                        y++;
                        break;
                    case 1:
                        x++;
                        break;
                    case 2:
                        y--;
                        x--;
                        break;
                }
                map[y][x]=num++;
            }
        }

    }
    public int[] solution(int n) {
        int[] answer = {};
        map=new int[n][n];
        makeMap(n);

        int index=0;
        int size=n*(n+1)/2;
        answer=new int[size];
        for(int y=0;y<n;y++){
            for(int x=0;x<n;x++){
              if(map[y][x]==0)break;
                answer[index++]=map[y][x];
            }
        }

        return answer;
    }
}
