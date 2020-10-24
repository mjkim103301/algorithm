public class dfs_bfs_네트워크 {
    static int []arr;
    static int findP(int target){
        if(arr[target]==-1){
            return target;
        }
        int temp=findP(arr[target]);
        arr[target]=temp;
        return temp;
    }
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=-1;
        }
        for(int child=0;child<n;child++){
            for(int parent=0;parent<n;parent++){
                if(child==parent)continue;
                if(computers[child][parent]==0)continue;
                int p1=findP(child);
                int p2=findP(parent);
                if(p1!=p2){
                    arr[p1]=p2;
                }
            }
        }
        answer=n;
        for(int i=0;i<n;i++){
            if(arr[i]!=-1){
               answer--;
            }
        }

        return answer;
    }
    public static void main(String [] args){
        int[][]computers={
                {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
        };
//        int[][]computers={
//                {1, 1, 0}, {1, 1, 1}, {0, 1, 1}
//        };
//        int[][]computers={
//                {1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 0}, {1, 1, 0, 1}
//        };
        int n=3;
        int answer=solution(n, computers);
        System.out.println(answer);
    }
}
