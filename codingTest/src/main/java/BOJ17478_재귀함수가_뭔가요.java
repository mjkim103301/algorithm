package com.ssafy.recursive;

import java.util.Scanner;

/**
 * 실버5 재귀함수가 뭔가요? 
 * Main_S5_17478_김민지
 * @author user
 *
 */
public class BOJ17478_재귀함수가_뭔가요 {
	static int N;
	static StringBuilder sb = new StringBuilder();
	static String underBar ="";

	public static void printAsc(int now) {

		if (now > N) {
			sb.append(underBar + "\"재귀함수가 뭔가요?\"\n");
			sb.append(underBar+"\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			sb.append(underBar+"라고 답변하였지.\n");
			return;
		}
		
		sb.append(underBar + "\"재귀함수가 뭔가요?\"\n");
		sb.append(underBar + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		sb.append(underBar + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		sb.append(underBar + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
		underBar+="____";
		printAsc(now + 1);
		
		
		int end=underBar.length()-4;
		if(end<0)end=0;
		underBar=underBar.substring(0, end);
		sb.append(underBar+"라고 답변하였지.\n");
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		System.out.print("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
		printAsc(1);
		
		System.out.print(sb);
	}
}
