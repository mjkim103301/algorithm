import java.util.*;
public class bruteForce_소수찾기 {
   static String nums;
    static String track="";
    static Integer[] visited;
    static Integer len;
    static HashSet<Integer> set= new HashSet<>();
    static void makeNum(String track, int level){
        if(level>=len) return;

        for(int i=0;i<len;i++){
            if(level==0 && nums.charAt(i)=='0') continue;
            if(visited[i]<=0) continue;
            visited[i]--;
            track+=nums.charAt(i);
            set.add(Integer.parseInt(track));

            makeNum(track, level+1);
            visited[i]++;
            track=track.substring(0,level);
        }
    }
    public static int solution(String numbers) {
        int answer = 0;
        nums=numbers;
        len=nums.length();
        visited=new Integer[len];
        for(int i=0;i<len;i++){
            visited[i]=1;
        }
        makeNum(track, 0);
        int flag=0;
        for(Integer item:set){
            if(item==2){
                answer++;
                continue;
            }
            if(item<2)continue;
            else{
                for(int i=2;i<item;i++){
                    if(item%i==0){
                        flag=1;
                        break;
                    }
                }
                if(flag==0){
                    answer++;

                }flag=0;
            }
        }
        return answer;
    }

    public static void main(String [] args){
        String numbers;
        //numbers="17";
        //numbers="011";
        numbers="1234";
        int answer=solution(numbers);
        System.out.println(answer);
    }
}
