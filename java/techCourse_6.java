import java.util.*;
public class techCourse_6 {
    public static class Node{
        String name;
        String action;
        int [] time;
        public Node(String n, String a, int[] t){
            name=n;
            action=a;
            time=t;
        }
    }
    static Node[] map;
    static  int len;
    static void init(String[] logs){
        for(int i=0;i<len;i++){
            int request=logs[i].indexOf("request");
            int leave=logs[i].indexOf("leave");
            int[]time=new int[3];
            if(request>=0){
                time[0]=Integer.parseInt(logs[i].substring(request+8, request+10));
                time[1]=Integer.parseInt(logs[i].substring(request+11, request+13));
                time[2]=Integer.parseInt(logs[i].substring(request+14));
                map[i]=new Node(logs[i].substring(0,request-1), "request",time );
            }else if(leave>=0){
                time[0]=Integer.parseInt(logs[i].substring(leave+6, leave+8));
                time[1]=Integer.parseInt(logs[i].substring(leave+9, leave+11));
                time[2]=Integer.parseInt(logs[i].substring(leave+12));
                map[i]=new Node(logs[i].substring(0,leave-1), "leave",time );
            }
        }
    }
    public static String[] findAns(int totalTicket){
        HashSet<String> set=new HashSet<>();
        String name="";
        int[] time=new int[3];
        for(int i=0;i<len;i++){
            if(name.equals("") && map[i].action.equals("request")){
                time=map[i].time;
                if(time[0]==10 || (time[0]==9 && time[1]==59 && time[2]>0))break;
                name=map[i].name;

            }else if(map[i].action.equals("request")){
                if(name.equals(map[i].name)){
                    name="";
                    continue;
                }else if(time[1]+1<map[i].time[1] || (time[1]<map[i].time[1] && time[2]<=map[i].time[2])){
                    totalTicket--;
                    set.add(name);
                    time=map[i].time;
                    if(time[0]==10 || (time[0]==9 && time[1]==59 && time[2]>0))break;
                    if(totalTicket==0)break;
                    name=map[i].name;

                }
            }else if(map[i].action.equals("leave")){
                name="";
            }
        }
        set.add(name);
        String[] ans=new String[set.size()];
        Iterator iter= set.iterator();
        int index=0;
        while(iter.hasNext()){
            ans[index++]= (String) iter.next();

        }
        Arrays.sort(ans);
        return ans;
    }
    public static String[] solution(int totalTicket, String[]logs){
        String[] answer={};
        len=logs.length;
        map=new Node[len];
        init(logs);
        answer=findAns(totalTicket);
        return answer;
    }
    public static void main(String[] args){
        int totalTicket=2000;
//        String [] logs={
//               "woni request 09:12:29",
//                "brown request 09:23:11",
//                "brown leave 09:23:44",
//                "jason request 09:33:51",
//                "jun request 09:33:56",
//                "cu request 09:34:02"
//        };
        String [] logs={
                "woni request 09:12:29",
                "brown request 09:23:11",
                "brown leave 09:23:44",
                "jason request 09:33:51",
                "jun request 09:35:56",
                "cu request 09:59:00"
        };
        String[] ans=solution(totalTicket, logs);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }

    }

}
