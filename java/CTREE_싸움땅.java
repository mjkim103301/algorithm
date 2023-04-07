package codetree.gold;

import java.util.*;
import java.io.*;

public class CTREE_싸움땅 {
    static int N, M, K;

    static class Node {
        PriorityQueue<Integer> gun;
        int playerIndex;

        public Node() {
            gun = new PriorityQueue<>(Collections.reverseOrder());
        }
    }

    static class Player {
        int y, x;
        int direction;
        int ability;
        int gun;

        public Player(int y, int x, int direction, int ability) {
            this.y = y;
            this.x = x;
            this.direction = direction;
            this.ability = ability;
        }
    }

    static Node[][] map;
    static List<Player> players = new ArrayList<>();
    static int[] score;
    static int[][] dydx = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new Node[N][N];
        score = new int[M + 1];
        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                int gun = Integer.parseInt(st.nextToken());
                map[y][x] = new Node();
                if (gun > 0) {
                    map[y][x].gun.add(gun);
                }
            }
        }
        players.add(new Player(0, 0, 0, 0));
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            players.add(new Player(y, x, d, s));
            map[y][x].playerIndex=i;
        }

        solution();
        for (int i = 1; i <= M; i++) {
            System.out.print(score[i] + " ");
        }
    }

    static void solution() {
        for (int i = 0; i < K; i++) {
            round();
        }
    }

    static void round() {
        for (int i = 1; i < players.size(); i++) {
            Player player = players.get(i);
            int y = player.y + dydx[player.direction][0];
            int x = player.x + dydx[player.direction][1];
            if (y < 0 || x < 0 || y >= N || x >= N) {
                player.direction += 2;
                player.direction %= 4;
                y = player.y + dydx[player.direction][0];
                x = player.x + dydx[player.direction][1];
            }
            map[player.y][player.x].playerIndex = 0;
            players.get(i).y = y;
            players.get(i).x = x;
            if (map[y][x].playerIndex > 0) {
                int winIndex = getWinPlayer(i, map[y][x].playerIndex);
                int loseIndex = getLosePlayer(i, map[y][x].playerIndex, winIndex);
                getScore(winIndex, loseIndex);
                moveLose(loseIndex);
                getGun(winIndex);
                map[y][x].playerIndex = winIndex;
            } else {
                map[y][x].playerIndex = i;
                getGun(i);
            }
        }
    }

    static int getWinPlayer(int index1, int index2) {
        Player p1 = players.get(index1);
        Player p2 = players.get(index2);
        if (p1.ability + p1.gun > p2.ability + p2.gun) {
            return index1;
        } else if (p1.ability + p1.gun < p2.ability + p2.gun) {
            return index2;
        } else if (p1.ability > p2.ability) {
            return index1;
        } else if (p1.ability < p2.ability) {
            return index2;
        }
        return 0;
    }

    static int getLosePlayer(int index1, int index2, int winPlayer) {
        if (winPlayer == index1) {
            return index2;
        } else {
            return index1;
        }
    }

    static void getScore(int winIndex, int loseIndex) {
        Player win = players.get(winIndex);
        Player lose = players.get(loseIndex);
        int point = (win.ability + win.gun) - (lose.ability + lose.gun);
        score[winIndex] += point;
    }

    static void moveLose(int loseIndex) {
        Player lose = players.get(loseIndex);
        map[lose.y][lose.x].gun.add(lose.gun);
        players.get(loseIndex).gun = 0;
        for (int i = lose.direction; i < lose.direction + 4; i++) {
            int direct = i % 4;
            int y = lose.y + dydx[direct][0];
            int x = lose.x + dydx[direct][1];
            if (y < 0 || x < 0 || y >= N || x >= N || map[y][x].playerIndex > 0) continue;
            players.get(loseIndex).y = y;
            players.get(loseIndex).x = x;
            players.get(loseIndex).direction = direct;
            map[y][x].playerIndex = loseIndex;
            getGun(loseIndex);
            break;
        }

    }

    static void getGun(int index) {
        Player player = players.get(index);
        if (player.gun > 0) {
            map[player.y][player.x].gun.add(player.gun);
        }
        if(map[player.y][player.x].gun.size()>0){
            player.gun = map[player.y][player.x].gun.poll();

        }
    }
}
