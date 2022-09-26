package baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ2108_통계학 {
    static int N;
    static int[]arr;
    static Map<Integer, Integer> countMap=new HashMap<>();
    static int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
    static long sum;
    static int mostCommonNumber;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        arr=new int[N];
        for(int i=0;i<N;i++){
           arr[i]=Integer.parseInt(br.readLine());
           setMap(arr[i]);
           max=Math.max(arr[i], max);
           min=Math.min(arr[i], min);
           sum+=arr[i];
        }
        solution();
        System.out.println(Math.round(sum/(double)N));
        System.out.println(arr[N/2]);
        System.out.println(mostCommonNumber);
        System.out.println(Math.abs(max-min));
    }

    static void setMap(int number){
        if(countMap.containsKey(number)){
            countMap.put(number, countMap.get(number)+1);
        }else{
            countMap.put(number, 1);
        }
    }

    static void solution(){
        Arrays.sort(arr);
        List<Integer> mostCommonNums=new ArrayList<>();
        int most=0;
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()){
            if(entry.getValue()>most){
                most=entry.getValue();
                mostCommonNums.clear();
                mostCommonNums.add(entry.getKey());
            }else if(entry.getValue()==most){
                mostCommonNums.add(entry.getKey());
            }
        }

        Collections.sort(mostCommonNums);
        if(mostCommonNums.size()>=2){
            mostCommonNumber=mostCommonNums.get(1);
        }else{
            mostCommonNumber=mostCommonNums.get(0);
        }
    }

}
