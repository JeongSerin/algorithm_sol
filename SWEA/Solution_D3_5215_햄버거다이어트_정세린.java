package com.ssafy.subset;

import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5215_햄버거다이어트_정세린 {
	static int N, L, Tmax;
	static int[] Ti, Ki;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			Ti = new int[N];
			Ki = new int[N];
			Tmax = 0;
			
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				Ti[n] = Integer.parseInt(st.nextToken());
				Ki[n] = Integer.parseInt(st.nextToken());
			}
			makeBurger(0, 0, 0);
			System.out.printf("#%d %d\n", tc + 1, Tmax);
		}
	}

	private static void makeBurger(int index, int Tsum, int Ksum) {
		if (Ksum >= L)
			return;
		if (index == N) {
			Tmax = (Tsum > Tmax) ? Tsum : Tmax;
			return;
		}
		makeBurger(index + 1, Tsum + Ti[index], Ksum + Ki[index]);
		makeBurger(index + 1, Tsum, Ksum);
	}

}
