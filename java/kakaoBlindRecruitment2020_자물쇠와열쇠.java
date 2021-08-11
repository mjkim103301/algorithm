public class kakaoBlindRecruitment2020_자물쇠와열쇠 {

    public static void main(String []args){
        int[][] key={{0,0,0}, {1,0,0}, {0,1,1}};
        int[][] lock={{1,1,1}, {1,1,0}, {1,0,1}};
        key= new int[][]{{0, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {1, 0, 1, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 0, 0, 1}};
        lock=new int[][]{{1, 1, 1, 1, 0}, {1, 1, 1, 0, 1}, {1, 1, 0, 1, 1}, {1, 0, 1, 1, 1}, {1, 1, 0, 1, 1}};
        Solution sol=new Solution();
        boolean ans=sol.solution(key, lock);
        System.out.println(ans);
    }

}

class Solution {
    int minX,minY,maxX,maxY;
    int [][]minLock;

    void findMinRange(int y, int x){
        if((minX==0) && (minY==0)&& (maxX==0)&&(maxY==0)){
            minY=y;
            minX=x;
            maxY=y;
            maxX=x;
        }else{
            if(x<minX){
                minX=x;
            }else if(x>maxX){
                maxX=x;
            }

            if(y<minY){
                minY=y;
            }else if(y>maxY){
                maxY=y;
            }
        }
    }

    public boolean findMinLock(int[][]lock, int lockSize){
        int rangeY, rangeX;
        for(int y=0;y<lockSize;y++){
            for(int x=0;x<lockSize;x++){
                if(lock[y][x]==1){
                    continue;
                }
                findMinRange(y, x);
            }
        }
        if(minX==0 && minY==0&& maxX==0&&maxY==0){
            return false;
        }
        rangeY=maxY-minY+1;
        rangeX=maxX-minX+1;
        minLock=new int[rangeY][rangeX];
        for(int y=0;y<rangeY;y++){
            for(int x=0;x<rangeX;x++){
                minLock[y][x]=lock[y+minY][x+minX];
            }
        }
        return true;
    }

    boolean canOpen(int[][]compKey, int lockHSize, int lockVSize, int y, int x){
        for(int yy=0;yy<lockHSize;yy++){
            for(int xx=0;xx<lockVSize;xx++){
                int keyValue=compKey[y+yy][x+xx];
                int lockValue=minLock[yy][xx];
                if((keyValue==1 && lockValue==1) ||(keyValue==0 && lockValue==0)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(int[][]compKey, int keySize){
        int lockHSize=minLock.length;//자물쇠 행길이
        int lockVSize=minLock[0].length;//자물쇠 열길이
        int rangeV=keySize-(lockVSize-1);//키 열 탐색범위
        int rangeH=keySize-(lockHSize-1);//키 행 탐색범위

        for(int y=0;y<rangeH;y++){
            for(int x=0;x<rangeV;x++){
                if(canOpen(compKey, lockHSize, lockVSize, y, x)==true){
                    return true;
                }
            }
        }
        return false;
    }

    public int[][] copy(int [][]result, int[][]target, int size){
        for(int y=0;y<size;y++){
            for(int x=0;x<size;x++){
                result[y][x]=target[y][x];
            }
        }
        return result;
    }

    public int[][] rotate(int[][] rotateKey, int[][]tempKey,int keySize){
        for(int y=0;y<keySize;y++){
            for(int x=0;x<keySize;x++){
                rotateKey[y][x]=tempKey[keySize-1-x][y];
            }
        }
        return rotateKey;
    }

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int lockSize=lock.length;
        int cnt=0;
        int keySize=key.length;
        int [][]tempKey=new int[keySize][keySize];
        int [][]rotateKey=new int[keySize][keySize];

        tempKey=copy(tempKey, key, keySize);
        rotateKey=copy(rotateKey, tempKey, keySize);

        if(findMinLock(lock, lockSize)==false){
            return true;
        }

        while(cnt<4){
            cnt++;
            if(isValid(rotateKey, keySize)==true){
                answer=true;
                break;
            }
            rotateKey=rotate(rotateKey, tempKey, keySize);//key 90도씩 회전
            tempKey=copy(tempKey,rotateKey, keySize); //rotateKey를 tempKey에 복사

        }
        return answer;
    }
}
