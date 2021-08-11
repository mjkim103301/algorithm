import java.util.*;


public class sort_가장_큰_수 {

    public static class customComparator implements Comparator<String> {
        @Override
        public int compare(String s, String t1) {
            String temp1=s+t1;//s win
            String temp2=t1+s;//t1 win
            int res=temp1.compareTo(temp2);
            if(res==0){
                return 0;
            }else if(res>0){
                return -1;
            }else if(res<0){
                return 1;
            }
            return 0;
        }
    }
    public static String solution(int[] numbers) {
        String answer = "";
        int len=numbers.length;
        String nums []=new String [len];
        for(int i=0;i<len;i++){
            nums[i]=String.valueOf(numbers[i]);
        }
       Arrays.sort(nums, new customComparator());
        if(nums[0].equals("0")){
            return "0";
        }
        for(String item:nums){
            answer+=item;
        }
        return answer;
    }



    public static void main(String [] args){
        //int[] numbers={0, 0, 0, 0, 0, 0};
       // int[] numbers={10, 101};
        //int[] numbers={1,11,111,1111};
        //int[] numbers={6646, 6466};
        //int[] numbers={2,20,200};
        //int[] numbers={40,403};
        int[] numbers={3, 30, 34, 5, 9};
        String ans=solution(numbers);
        System.out.println(ans);
    }
}


