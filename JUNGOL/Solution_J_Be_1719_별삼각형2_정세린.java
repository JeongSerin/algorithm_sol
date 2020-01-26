package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_J_Be_1719_별삼각형2_정세린 {
	static int n, m; // 크기, 종류

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		if (!(n <= 100 && n % 2 == 1 && m >= 1 && m <= 4)) {
			System.out.println("INPUT ERROR!");
			return;
		}

		switch (m) {
		case 1:
			printType1();
			break;
		case 2:
			printType2();
			break;
		case 3:
			printType3();
			break;
		case 4:
			printType4();
			break;
		}
	}

	private static void printType1() {
		for (int i = 0; i < n; i++) {
			if (i < n / 2 + 1) {
				for (int j = 0; j < i + 1; j++) {
					System.out.print("*");
				}
			} else {
				for (int j = n - i; j > 0; j--) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	private static void printType2() {
		for (int i = 0; i < n; i++) {
			if (i < n / 2 + 1) {
				for (int j = 0; j < n / 2 + 1; j++) {
					if (j < n / 2 - i)
						System.out.print(" ");
					else
						System.out.print("*");
				}
				System.out.println();
			} else {
				for (int j = 0; j < n / 2 + 1; j++) {
					if (j < i - n / 2)
						System.out.print(" ");
					else
						System.out.print("*");
				}
				System.out.println();
			}
		}
	}

	private static void printType3() {
		for (int i = 0; i < n; i++) {
			if (i < n / 2 + 1) {
				for (int j = n - 1; j >= i; j--) {
					if (j > n - i - 1)
						System.out.print(" ");
					else
						System.out.print("*");
				}
			} else
				for (int j = 0; j <= i; j++) {
					if (j < n - i - 1)
						System.out.print(" ");
					else
						System.out.print("*");
				}
			System.out.println();
		}
	}

	private static void printType4() {
		for (int i = 0; i < n; i++) {
			if (i < n / 2 + 1) {
				for (int j = 0; j <= n / 2; j++) {
					if (j < i)
						System.out.print(" ");
					else
						System.out.print("*");
				}
			} else {
				for (int j = 0; j <= i; j++) {
					if (j < n / 2)
						System.out.print(" ");
					else
						System.out.print("*");
				}
			}
			System.out.println();
		}
	}

}
