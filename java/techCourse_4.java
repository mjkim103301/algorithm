import java.util.*;
public class techCourse_4 {
    public static int solution(int[] pobi, int[] crong){
        int ans=-1;
        if(pobi[1]-pobi[0]!=1 || crong[1]-crong[0]!=1){
            return -1;
        }
        int []pobiLeft=new int[3];
        int[] pobiRight=new int[3];
        int[] crongLeft=new int[3];
        int[] crongRight=new int[3];
        for(int i=2;i>=0;i--){
            pobiLeft[2-i]=pobi[0]/(int)Math.pow(10, i);
            pobiRight[2-i]=pobi[1]/(int)Math.pow(10, i);
            crongLeft[2-i]=crong[0]/(int)Math.pow(10, i);
            crongRight[2-i]=crong[1]/(int)Math.pow(10, i);
            pobi[0]=pobi[0]%(int)Math.pow(10, i);
            pobi[1]=pobi[1]%(int)Math.pow(10, i);
            crong[0]=crong[0]%(int)Math.pow(10, i);
            crong[1]=crong[1]%(int)Math.pow(10, i);
        }
        int []pobiCan=new int[]{0,1,0,1};
        int[]crongCan=new int[]{0,1,0,1};

        for(int j=0;j<3;j++){
            pobiCan[0]+=pobiLeft[j];
            pobiCan[2]+=pobiRight[j];
            crongCan[0]+=crongLeft[j];
            crongCan[2]+=crongRight[j];
            if(pobiLeft[j]==0){
                pobiCan[1]*=1;
            }else{
                pobiCan[1]*=pobiLeft[j];
            }
            if(pobiRight[j]==0){
                pobiCan[3]*=1;
            }else{
                pobiCan[3]*=pobiRight[j];
            }
            if(crongLeft[j]==0){
                crongCan[1]*=1;
            }else{
                crongCan[1]*=crongLeft[j];
            }
            if(crongRight[j]==0){
                crongCan[3]*=1;
            }else{
                crongCan[3]*=crongRight[j];
            }
        }
        int maxPobi=0, maxCrong=0;
        for(int k=0;k<4;k++){
            if(pobiCan[k]>maxPobi){
                maxPobi=pobiCan[k];
            }
            if(crongCan[k]>maxCrong){
                maxCrong=crongCan[k];
            }
        }
        if(maxPobi>maxCrong){
            return 1;
        }else if(maxPobi==maxCrong){
            return 0;
        }else if(maxPobi<maxCrong){
            return 2;
        }


        return ans;
    }
    public static void main(String [] args){
//        int[] pobi={97,98};
//        int[] crong={197, 198};
//        int[] pobi={131,132};
//        int[] crong={211, 212};
        int[] pobi={99,102};
        int[] crong={211, 212};
        int ans=solution(pobi, crong);
        System.out.println(ans);
    }
}
