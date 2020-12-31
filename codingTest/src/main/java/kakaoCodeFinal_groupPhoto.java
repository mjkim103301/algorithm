package level2;

public class kakaoCodeFinal_groupPhoto {
    public static void main(String[]args){
        Solution_groupPhoto sol=new Solution_groupPhoto();
        int n=2;
        String[]data={	"N~F=0", "R~T>2"};
        int ans=sol.solution(n, data);
        System.out.println(ans);
    }

}

class Solution_groupPhoto {
    String friends="ACFJMNRT";
    int []visited;//프렌즈들 배치 했는지
    int []map;//프렌즈들이 어느 위치에 있는지
    int count=0;
    int N;
    String[] datas;
    boolean isValid(){
        for(int i=0;i<N;i++){
            int friend1=friends.indexOf(datas[i].charAt(0));
            int freind2=friends.indexOf(datas[i].charAt(2));
            char condition=datas[i].charAt(3);
            int distance=datas[i].charAt(4)-'0'+1;
            int mapF1=map[friend1];
            int mapF2=map[freind2];
            int distanceMapF=Math.abs(mapF1-mapF2);
            if(condition=='='){
                if(distanceMapF!=distance){
                    return false;
                }
            }else if(condition=='>'){
                if(distanceMapF<=distance){
                    return false;
                }
            }else{
                if(distanceMapF>=distance){
                    return false;
                }

            }
        }
        return true;
    }
    void dfs(int now){
        if(now>=8){
            if(isValid()){
                count++;
            }
            return;
        }
        for(int i=0;i<8;i++){
            if(visited[i]==1)continue;
            visited[i]=1;
            map[now]=i;
            dfs(now+1);
            map[now]=-1;
            visited[i]=0;
        }
    }
    public int solution(int n, String[] data) {
        int answer = 0;
        map=new int[8];
        visited=new int[8];
        N=n;
        datas=data;
        dfs(0);
        answer=count;
        return answer;
    }
}
