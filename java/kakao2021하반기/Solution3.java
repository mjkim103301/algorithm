package kakao2021하반기;

import java.util.*;
public class Solution3 {
    static int[]answer;
    static HashMap<Integer, ArrayList<Integer>> carMap=new HashMap<>();
    static int recordsSize;
    static Object[] mapKeySort;
    static int lastTime=1439;
    public static int[] solution(int[] fees, String[] records) {
        recordsSize=records.length;
       //차량번호별로 index랑 timeMap 채우기
        init(records);

        // 정렬
        sort();

        // 기본요금 추가요금 계산해서 answer 채우기
        calculate(fees);
        return answer;
    }

    static void init(String[] records){
        for(int i=0;i<recordsSize;i++){
            String input=records[i];
            int blankIndex1=input.indexOf(" ");
            int blankIndex2=input.indexOf(" ", blankIndex1+1);
            String time=input.substring(0,blankIndex1);
            String carNum=input.substring(blankIndex1+1, blankIndex2);
           // System.out.println("time: "+time+" carNum: "+carNum);
            setCarIndexAndTimeMap(time, carNum);
        }

    }

    static void setCarIndexAndTimeMap(String time, String carNum){
        int dotIndex=time.indexOf(":");
        int hour=Integer.parseInt(time.substring(0,dotIndex));
        int minute=hour*60+Integer.parseInt(time.substring(dotIndex+1));
        //System.out.println(minute);

        int key=Integer.parseInt(carNum);


        if(!carMap.containsKey(key)){
            ArrayList<Integer>  timeList=new ArrayList<>();
            timeList.add(minute);
            carMap.put(key, timeList);
        }else{
            ArrayList<Integer>  timeList=carMap.get(key);
            timeList.add(minute);
            carMap.put(key, timeList);
        }

       //System.out.println(carMap);
    }

    static void sort(){
        mapKeySort= carMap.keySet().toArray();
        Arrays.sort(mapKeySort);
    }

    static void calculate(int[]fees){
        int carMapSize=carMap.size();
        answer=new int[carMapSize];
        int answerIndex=0;
        for (Object key : mapKeySort)
        {
           int time=getDuringTime(carMap.get(key));
           int money=0;
           int extraTime=0;
           if(time>fees[0]){
               extraTime=(int)Math.ceil((time-fees[0])/(double)fees[2]);
               money=fees[1]+(extraTime*fees[3]);
           }else{
               money=fees[1];
           }
           answer[answerIndex++]=money;


        }


    }

    static int getDuringTime(ArrayList<Integer> inOut){
        int inOutSize=inOut.size();
        int timeSum=0;
        for(int i=0;i<inOutSize;i+=2){
            int from=inOut.get(i);
            int to;
            if(i+1<inOutSize){
                to=inOut.get(i+1);
            }else{
                to=lastTime;
            }
            timeSum+=to-from;
        }
        return timeSum;
    }

    public static void main(String[] args) {
        int[] fees={120, 0, 60, 591};
        String[] records={"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"};
        int[] ans=solution(fees, records);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
