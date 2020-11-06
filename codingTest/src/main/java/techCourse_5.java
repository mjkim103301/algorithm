public class techCourse_5 {
    public static int Find369(String temp){
        int index3=-1, index6=-1, index9=-1;
        int cnt=0;
        while(true){
            index3=temp.indexOf('3',++index3);
            if(index3>=0){
                cnt++;
            }else{
                break;
            }
        }
        while(true){
            index6=temp.indexOf('6',++index6);
            if(index6>=0){
                cnt++;
            }else{
                break;
            }
        }
        while(true){
            index9=temp.indexOf('9',++index9);
            if(index9>=0){
                cnt++;
            }else{
                break;
            }
        }
        return cnt;
    }
    public static int solution(int number){
        int answer=0;
        int num=1;
        int cnt=0;
        while(num<=number){
            String temp=String.valueOf(num);
            cnt+=Find369(temp);
            num++;
        }
        answer=cnt;
        return answer;
    }
    public static void main(String []args){
        int number=33;
        int ans=solution(number);
        System.out.println(ans);
    }
}
