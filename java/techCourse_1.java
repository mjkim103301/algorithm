import java.util.*;
public class techCourse_1 {
    public static int[] solution(int money){
        int [] answer=new int[9];
        int [] mon=new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        int mon_temp=money;
        for(int i=0;i<9;i++){
            answer[i]=mon_temp/mon[i];
            int remain=mon_temp%mon[i];
            mon_temp=remain;
        }
        return answer;
    }
    public static void main(String[] args){
        int money;
        //money=50237;
        money=15000;
        int[] ans=solution(money);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
