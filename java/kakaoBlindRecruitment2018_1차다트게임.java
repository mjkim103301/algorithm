public class kakaoBlindRecruitment2018_1차다트게임 {
    public static void main(String[]args){
        Solution_다트게임 sol=new Solution_다트게임();
        String dartResult="1S2D*3T";
        int answer=sol.solution(dartResult);
        System.out.println(answer);
    }
}

class Solution_다트게임 {
    String numTemp="";
    int scoreIndex=0;
    int []score;
    void calc(char target){
        if(target>='0' && target<='9'){
            numTemp+=target;
        }else if(target=='S' ||target=='D'||target=='T'){
            score[scoreIndex]=Integer.parseInt(numTemp);
            if(target=='D'){
                score[scoreIndex]=(int)Math.pow(score[scoreIndex],2);
            }else if(target=='T'){
                score[scoreIndex]=(int)Math.pow(score[scoreIndex],3);
            }
            scoreIndex++;
            numTemp="";
        }else if(target=='*' ||target=='#'){
            if(target=='*'){
                score[scoreIndex-1]*=2;
                if(scoreIndex-1>0){
                    score[scoreIndex-2]*=2;
                }
            }else{
                score[scoreIndex-1]*=-1;
            }

        }
    }
    public int solution(String dartResult) {
        int answer = 0;
        score=new int[3];
        int len=dartResult.length();
        for(int i=0;i<len;i++){
            calc(dartResult.charAt(i));
        }
        for(int i=0;i<3;i++){
            answer+=score[i];
        }
        return answer;
    }
}


