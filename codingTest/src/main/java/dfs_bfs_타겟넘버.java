public class dfs_bfs_타겟넘버 {
    static int size;
    static int[] oper;//0 plus/ 1 minus

    static int cnt=0;
    static void DFS(int[] numbers, int[] oper, int target, int level){
        if(level==size){
            int temp=0;
            for(int i=0;i<size;i++){
                if(oper[i]==0){
                    temp+=numbers[i];
                }else if(oper[i]==1){
                    temp-=numbers[i];
                }
            }
            if(temp==target){
                cnt++;
            }
            return;
        }
        for(int i=0;i<=1;i++){
            oper[level]=i;
            DFS(numbers, oper, target, level+1);
            oper[level]=-1;
        }

    }
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        size=numbers.length;
        oper=new int[size];
        DFS(numbers, oper, target, 0);
        answer=cnt;
        return answer;
    }
    public static void main(String [] args){
        int[]numbers={1,1,1,1,1};
        int target=3;
        int answer=solution(numbers, target);
        System.out.println(answer);
    }

}
