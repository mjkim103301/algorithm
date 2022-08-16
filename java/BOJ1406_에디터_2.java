package baekjoon.level_silver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class BOJ1406_에디터_2 {
    static int N;
    static List<Character> scentence = new LinkedList<>();
    static ListIterator<Character> cursur;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            scentence.add(input.charAt(i));
        }
        cursur = scentence.listIterator(scentence.size());

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            solution(command);
        }
        for(Character ch:scentence){
            bw.write(ch);
        }
        bw.flush();
        bw.close();
    }

    static void solution(String[] command) {
        switch (command[0]) {
            case "L": {
                if (cursur.hasPrevious()) {
                    cursur.previous();
                }
                break;
            }
            case "D": {
                if (cursur.hasNext()) {
                    cursur.next();
                }
                break;
            }
            case "B": {
                if (cursur.hasPrevious()) {
                    cursur.previous();
                    cursur.remove();
                }
                break;
            }
            case "P": {
                cursur.add(command[1].charAt(0));
                break;
            }
        }
    }
}
