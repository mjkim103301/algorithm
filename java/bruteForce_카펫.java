public class bruteForce_카펫 {
    public static int[] solution(int brown, int yellow) {
        int[] answer = {0,0};
        for(int i=1;i<=yellow;i++){
            int value=yellow/i;
            if(yellow%i==0){
                if(((i+1)+(value+1))*2==brown){
                    answer[0]=value+2;
                    answer[1]=i+2;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args){
        //int brown=10, yellow=2;
        int brown=8, yellow=1;
        int[] answer;
        answer=solution(brown, yellow);
        for(Integer item: answer){
            System.out.println(item);
        }
    }
}
