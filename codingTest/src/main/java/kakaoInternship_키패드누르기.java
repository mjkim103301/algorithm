import java.util.*;
public class kakaoInternship_키패드누르기 {
    static char [][]arr={
            {'1','2','3'},
            {'4','5','6'},
            {'7','8','9'},
            {'*','0','#'}
    };
    static int leftY=3, leftX=0;
    static  int rightY=3, rightX=2;
    public static void LR(char hand, int num){
        for(int y=0;y<4;y++){
            for(int x=0;x<3;x++){
                if(arr[y][x]-'0'==num){
                    if(hand=='L'){
                        leftY=y;
                        leftX=x;
                    }else{
                        rightY=y;
                        rightX=x;
                    }
                }
            }
        }
    }
    public static int findLocation(int num, String hand){
        for(int y=0;y<4;y++){
            for(int x=0;x<3;x++){
                if(arr[y][x]-'0'==num){
                    int rightTemp=(int)Math.abs(rightY-y)+(int)Math.abs(rightX-x);
                    int leftTemp=(int)Math.abs(leftY-y)+(int)Math.abs(leftX-x);
                   // System.out.println("r:"+rightTemp+" l:"+leftTemp);
                    if(leftTemp<rightTemp){
                        leftY=y;
                        leftX=x;
                        return -1;
                    }else if(leftTemp>rightTemp){
                        rightY=y;
                        rightX=x;
                        return 1;
                    }else{
                        if(hand.equals("right")){
                            rightY=y;
                            rightX=x;
                            return 1;

                        }else{
                            leftY=y;
                            leftX=x;
                            return -1;
                        }

                    }

                }
            }
        }
        return -2;
    }
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int len=numbers.length;
        for(int i=0;i<len;i++){
            int num=numbers[i];
            if(num==1 ||num==4 ||num==7){
                answer+='L';
                LR('L', num);
            }else if(num==3 ||num==6 ||num==9){
                answer+='R';
                LR('R', num);
            }
            else{
                int value= findLocation(num, hand);
                if(value==1){
                    answer+='R';
                }else if(value==-1){
                    answer+='L';
                }

            }

        }
        return answer;
    }
    public static void main(String [] args){
        int[] numbers={1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand="right";
        String result=solution(numbers, hand);
        System.out.println(result);
    }
}
