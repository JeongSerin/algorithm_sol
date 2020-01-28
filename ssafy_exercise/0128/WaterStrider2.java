package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WaterStrider2 {
	static boolean[][] visit;
	static int die, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int wsnum;
		int[] starti, startj, dir;

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			wsnum = Integer.parseInt(st.nextToken());
			visit = new boolean[N][N];
			starti = new int[wsnum];
			startj = new int[wsnum];
			dir = new int[wsnum];

			for (boolean[] v : visit) {
				Arrays.fill(v, false);
			}

			die = 0;

			// 처음위치 (행, 열), 1: 상, 2: 하, 3: 좌, 4: 우
			for (int i = 0; i < wsnum; i++) {
				st = new StringTokenizer(br.readLine());
				starti[i] = Integer.parseInt(st.nextToken());
				startj[i] = Integer.parseInt(st.nextToken());
				dir[i] = Integer.parseInt(st.nextToken());

			}

			for (int i = 0; i < wsnum; i++) {
				switch (dir[i]) {
				// 상
				case 1:
					jumpUp(starti[i], startj[i], 3);
					break;
				// 하
				case 2:
					jumpDown(starti[i], startj[i], 3);
					break;
				// 좌
				case 3:
					jumpLeft(starti[i], startj[i], 3);
					break;
				// 우
				case 4:
					jumpRight(starti[i], startj[i], 3);
					break;
				}

			}
			System.out.printf("#%d %d\n", tc + 1, wsnum - die);
		}

	}

	private static void jumpUp(int i, int j, int n) {
		if (visit[i][j] == false) {
			if (n == 0)
				visit[i][j] = true;
			if (i - n >= 0) {
				if (n > 0)
					jumpUp(i - n, j, n - 1);
			} else {
				die++;
				return;
			}
		} else {
			die++;
			return;
		}
	}

	private static void jumpDown(int i, int j, int n) {
		if (visit[i][j] == false) {
			if (n == 0)
				visit[i][j] = true;
			if (i + n < N) {
				if (n > 0)
					jumpDown(i + n, j, n - 1);
			} else {
				die++;
				return;
			}
		} else {
			die++;
			return;
		}
	}

	private static void jumpLeft(int i, int j, int n) {
		if (visit[i][j] == false) {
			if (n == 0)
				visit[i][j] = true;
			if (j - n >= 0) {
				if (n > 0)
					jumpLeft(i, j - n, n - 1);
			} else {
				die++;
				return;
			}
		} else {
			die++;
			return;
		}
	}

	private static void jumpRight(int i, int j, int n) {
		if (visit[i][j] == false) {
			if (n == 0)
				visit[i][j] = true;
			if (j + n < N) {
				if (n > 0)
					jumpRight(i, j + n, n - 1);
			} else {
				die++;
				return;
			}
		} else {
			die++;
			return;
		}
	}
}
