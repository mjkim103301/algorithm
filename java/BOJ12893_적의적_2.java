package baekjoon.gold;

import java.io.*;
import java.util.*;

//성공
public class BOJ12893_적의적_2 {
    static int N, M;
    static int[] friendTree, enemyTree;
    static boolean isRight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friendTree = new int[N + 1];
        enemyTree = new int[N + 1];
        isRight = true;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            solution(p1, p2);
            if (!isRight) {
                break;
            }
        }
        if (isRight) {
            System.out.print("1");
        } else {
            System.out.print("0");
        }
    }

    static void solution(int p1, int p2) {
        int friendParent1 = getFriendParent(p1);
        int friendParent2 = getFriendParent(p2);
        if (friendParent1 == friendParent2) {
            isRight = false;
            return;
        }

        int enemy1 = enemyTree[p1];
        int enemy2 = enemyTree[p2];
        if (enemy1 != 0) {
            setFriend(enemy1, p2);
        }else{
            enemyTree[p1]=p2;
        }
        if (enemy2 != 0) {
            setFriend(enemy2, p1);
        }else{
            enemyTree[p2]=p1;
        }
    }

    static int getFriendParent(int child) {
        if (friendTree[child] == 0) {
            return child;
        }
        return friendTree[child] = getFriendParent(friendTree[child]);
    }

    static void setFriend(int f1, int f2) {
        int parent1 = getFriendParent(f1);
        int parent2 = getFriendParent(f2);
        if (parent1 != parent2) {
            friendTree[parent1] = parent2;
        }
    }
}
