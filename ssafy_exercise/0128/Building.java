package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Building {
	static char[][] map;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int max = 0;
		StringTokenizer st = null;
		int isum, jsum;

		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					jsum = 0;
					isum = 0;
					if (map[i][j] == 'B') {
						if (green(i, j)) {
							max = (2 > max) ? 2 : max;
						} else {
							for (int k = 0; k < N; k++) {
								if (map[i][k] == 'B')
									jsum++;
								if (map[k][j] == 'B')
									isum++;
							}
							max = ((jsum + isum - 1) > max) ? (jsum + isum - 1) : max;
						}

					}

				}
			}

			System.out.printf("#%d %d", tc + 1, max);
		}

	}

	private static boolean green(int i, int j) {
		if (i > 0) {
			if (map[i - 1][j] == 'G')
				return true;
			if (j > 0 && map[i - 1][j - 1] == 'G')
				return true;
			if (j < N - 1 && map[i - 1][j + 1] == 'G')
				return true;
		} else if (j < N - 1 && map[i][j + 1] == 'G') {
			return true;
		} else if (i < N - 1) {
			if (map[i + 1][j] == 'G')
				return true;
			if (j > 0 && map[i + 1][j - 1] == 'G')
				return true;
			if (j < N - 1 && map[i + 1][j + 1] == 'G')
				return true;
		} else if (j > 0 && map[i][j - 1] == 'G') {
			return true;
		}
		return false;
	}

}
