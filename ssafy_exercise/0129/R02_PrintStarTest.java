package com.ssafy.recursive;

import java.util.Scanner;

public class R02_PrintStarTest {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		printStar(N);
	}

	private static void printStar(int n) {
		if (n == 0)
			return;
		
		printStar(n - 1);
		for (int i = 0; i < n; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
}
