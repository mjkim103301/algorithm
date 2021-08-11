package com.supplementary;

import java.util.*;

public class BOJ2164_카드2 {
	static int N;
	static ArrayDeque <Integer>cards;
	static void init() {
		for(int i=N;i>0;i--) {
			cards.offer(i);
		}
	}
	static void recursion() {
		if(cards.size()==1) {
			return;
		}
		cards.pollLast();
		int temp=cards.pollLast();
		cards.addFirst(temp);
		recursion();
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		N=scan.nextInt();
		cards=new ArrayDeque<>(N);
		init();
		recursion();
		System.out.println(cards.pop());
	}
}
