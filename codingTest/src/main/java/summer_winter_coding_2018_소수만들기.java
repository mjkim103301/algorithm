package level2;
import java.util.*;
public class summer_winter_coding_2018_소수만들기 {
    public static void main(String[] args){
        int[]nums={1,2,3,4};
        nums= new int[]{1, 2, 7, 6, 4};
        Solution_소수 sol=new Solution_소수();
        int ans=sol.solution(nums);
        System.out.println(ans);
    }
}

class Node_소수{
    int num;
    int index;
    public Node_소수(int num, int index){
        this.num=num;
        this.index=index;
    }
}
class Solution_소수 {
    int cnt=0;
    Node_소수[] path=new Node_소수[3];
    int []cnums;
    int numsSize;
    int[] visited;


    boolean isValid(int sum){
        int n=(int)Math.sqrt(sum);
        n++;
        if(sum<=2)return true;
        for(int i=2;i<=n;i++){
            if(sum%i==0){
                return false;
            }
        }
        return true;
    }
    void dfs(int now){
        if(now==3){
            int sum=0;
            for(int i=0;i<3;i++){
                sum+=path[i].num;
            }
            if(isValid(sum)){
                cnt++;
            }
            return;
        }
        int last=0;
        if(now>0){
            last=path[now-1].index;
        }

        for(int i=0;i<numsSize;i++){
            if(last>i)continue;
            if(visited[i]==1)continue;
            visited[i]=1;
            path[now]=new Node_소수(cnums[i],i );
            dfs(now+1);
            visited[i]=0;
            path[now]=new Node_소수(0,0);
        }
    }
    public int solution(int[] nums) {
        int answer = -1;
        numsSize=nums.length;
        visited=new int[numsSize];
        cnums=nums.clone();
        dfs(0);
        answer=cnt;
        return answer;
    }
}
