package com.java.algo;

import java.io.*;
import java.util.*;

/**
 * BOJ 1244번 스위치 켜고 끄기 구현 문제
 * 
 * @author mjkim103301
 *
 */
public class BOJ1244_스위치켜고끄기 {
	static int N;
	static int[] switchArr;
	static int studentNum;
	static int[][] student;
	static StringBuilder sb = new StringBuilder();

	static void boy(int num) {
		int multiple = num;
		int index = 1;
		while (multiple <= N) {
			switchArr[multiple] = switchArr[multiple] ^ 1;
			multiple = num * (++index);
		}
	}

	static void girl(int num) {
		int left = num - 1;
		int right = num + 1;
		while (true) {
			if (left < 1 || right > N)
				break;
			if (switchArr[left] != switchArr[right]) {
				break;
			}
			left--;
			right++;
		}
		left++;
		right--;

		for (int i = left; i <= right; i++) {
			switchArr[i] = switchArr[i] ^ 1;
		}
	}

	static void solution() {
		for (int i = 0; i < studentNum; i++) {
			if (student[i][0] == 1) {
				boy(student[i][1]);
			} else if (student[i][0] == 2) {
				girl(student[i][1]);
			}
		}

		for (int i = 1; i <= N; i++) {
			sb.append(switchArr[i] + " ");
			if (i % 20 == 0) {
				sb.append("\n");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = parse(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		switchArr = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			switchArr[i] = parse(st.nextToken());
		}
		studentNum = parse(br.readLine());
		student = new int[studentNum][2];
		for (int i = 0; i < studentNum; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				student[i][j] = parse(st.nextToken());
			}
		}
		solution();
		System.out.println(sb);
	}

	static int parse(String s) {
		return Integer.parseInt(s);
	}
}
