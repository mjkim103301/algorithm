package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ16472_고냥이_2 {
    static int N;
    static String sentence;
    static int[] alphabet;
    static int maxLength;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        sentence = br.readLine();
        alphabet = new int[26];
        solution();
        System.out.print(maxLength);

    }

    static void solution() {
        int left = 0;
        int right = 0;
        int charCnt = 0;
        alphabet[getAlphbetIndex(0)]++;
        charCnt++;

        while (right < sentence.length()-1) {
            right++;
            alphabet[getAlphbetIndex(right)]++;
            if (alphabet[getAlphbetIndex(right)] == 1) {
                charCnt++;
            }

            while (charCnt > N) {
                alphabet[getAlphbetIndex(left)]--;
                if (alphabet[getAlphbetIndex(left)] == 0) {
                    charCnt--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
    }

    static int getAlphbetIndex(int sentenceIndex) {
        return sentence.charAt(sentenceIndex) - 'a';
    }
}
