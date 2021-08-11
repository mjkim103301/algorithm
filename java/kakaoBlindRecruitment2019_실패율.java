import java.util.Arrays;
import java.util.Comparator;

public class kakaoBlindRecruitment2019_실패율 {
    public static void main(String[]args){
        int N=5;
        int[] stages={2,1,2,6,2,4,3,3};
        Solution_실패율 sol=new Solution_실패율();
        int [] ans=sol.solution(5,stages);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
class Node_실패율{
    int stageNum;
    double failRate;
    int cnt;
    public Node_실패율(int stageNum, double failRate, int cnt){
        this.stageNum=stageNum;
        this.failRate=failRate;
        this.cnt=cnt;
    }
}
class Solution_실패율 {
    int n;
    int[] stages_copy;
    Node_실패율[] list;
    public void addNode(int i){
            list[i].cnt++;
    }
    public void sort(){
        Arrays.sort(list, new Comparator<Node_실패율>() {
            @Override
            public int compare(Node_실패율 node_실패율, Node_실패율 t1) {
                if(node_실패율.failRate < t1.failRate){
                    return 1;
                }else if(node_실패율.failRate == t1.failRate){//번호 작은순
                   return node_실패율.stageNum-t1.stageNum;
                }
                return -1;
            }
        });
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        n=N;
        stages_copy=stages.clone();
        int len=stages.length;
        list=new Node_실패율[n];
        for(int i=0;i<n;i++){
            list[i]= new Node_실패율(i+1, 0, 0);
        }
        for(int i=0;i<len;i++){
            int stageNum=stages[i];
            if(stageNum>n){
                continue;
            }
            addNode(stageNum-1);
        }
        int people=len;
        double failRate;
        for(int i=0;i<n;i++){
            if(people==0){
                failRate=0;
            }else{
                failRate=(double)(list[i].cnt)/(double)people;
            }

            list[i].failRate=failRate;
            people-=list[i].cnt;

        }

        sort();
        answer=new int[n];
        for(int i=0;i<n;i++){
            answer[i]=list[i].stageNum;
        }
        return answer;
    }
}
