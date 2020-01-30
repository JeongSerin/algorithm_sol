package com.ssafy.subset;

import java.util.Scanner;

public class S02_RecursiveTest2 {
	static int N;
	static boolean[] selected;
	static int[] numbers;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		selected = new boolean[N];

		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		subset(0);
	}

	private static void subset(int index) {
		if (index == N) {
			for (int s = 0; s < N; s++) {
				System.out.print((selected[s] ? numbers[s] + " " : "") + "");
			}
			System.out.println();
			return;
		}
		selected[index] = true;		// 아래 두줄과 자리를 바꾸면 
		subset(index + 1);			// 방문
		
		selected[index] = false;	//
		subset(index + 1);			// 비방문

	}

}
