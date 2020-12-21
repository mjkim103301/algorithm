import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class summer_winter2019_예산 {
    public static void main(String[] args){
        int[]d={2, 2, 4, 4, 5, 5, 1, 1, 1, 1};
        int budget=3;
        Solution_예산 sol=new Solution_예산();
        int ans=sol.solution(d, budget);
        System.out.print(ans);
    }

}

class Solution_예산 {
    public int solution(int[] d, int budget) {
        int answer = 0;
       // ArrayList<Integer> list=new ArrayList<>();
        int size=d.length;
       /* for(int i=0;i<size;i++){
            list.add(d[i]);
        }
        Collections.sort(list);*/
       Arrays.sort(d);
        int temp=0;
        int cnt=0;
        for(int j=0;j<size;j++){
            //temp+=list.get(j);
            temp+=d[j];
            cnt++;
            if(temp>budget){
                temp-=d[j];
                cnt--;
                break;
            }
        }
        answer=cnt;
        return answer;
    }
}