package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Soultion_J_Be_2071_파스칼삼각형_정세린 {
	static int n, m; // 높이 종류
	static int[][] pascal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		pascal = new int[n][n];
		for (int i = 0; i < n; i++) {
			pascal[i][i] = 1;
			pascal[i][0] = 1;
		}

		for (int i = 2; i < n; i++) {
			for (int j = 1; j < i; j++) {
				pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
			}
		}

		switch (m) {
		case 1:
			print_pascal1();
			break;
		case 2:
			print_pascal2();
			break;
		case 3:
			print_pascal3();
			break;
		}

	}

	private static void print_pascal1() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(pascal[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void print_pascal2() {
		for (int i = n - 1; i >= 0; i--) {
			for (int space = 0; space < n - i - 1; space++)
				System.out.print(" ");
			for (int j = 0; j <= i; j++) {
				System.out.print(pascal[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void print_pascal3() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(pascal[n - 1 - j][n - 1 - i] + " ");
			}
			System.out.println();
		}
	}
}
