package level2;

public class summer_winter_coding_2018_점프와_순간이동 {
    public static void main(String[] args) {
        Solution_점프와순간이동 sol=new Solution_점프와순간이동();
        int n=5;
        int ans=sol.solution(n);
        System.out.println(ans);
    }
}
class Solution_점프와순간이동 {
    public int solution(int n) {
        int ans = 0;

        while(n==1){
            if(n%2==1){
                ans++;
                System.out.println(ans);
                n--;
            }
            n=n/2;
        }
        ans++;
        return ans;
    }
}