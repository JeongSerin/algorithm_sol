package ssafy.ex_0128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WaterStrider1 {
	static boolean[][] visit;
	static int res, N;
	static boolean flag = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int num;
		int[] starti, startj, dir;

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			visit = new boolean[N][N];
			starti = new int[num];
			startj = new int[num];
			dir = new int[num];

			for (boolean[] v : visit) {
				Arrays.fill(v, false);
			}

			res = 0;
			flag = false;

			// 처음위치 (행, 열), 1: 하, 2: 우
			for (int i = 0; i < num; i++) {
				st = new StringTokenizer(br.readLine());
				starti[i] = Integer.parseInt(st.nextToken());
				startj[i] = Integer.parseInt(st.nextToken());
				dir[i] = Integer.parseInt(st.nextToken());

			}

			for (int i = 0; i < num; i++) {
				switch (dir[i]) {
				// 하
				case 1:
					jumpDown(i, starti[i], startj[i], 3);
					break;
				// 우
				case 2:
					jumpRight(i, starti[i], startj[i], 3);
					break;
				}
				if (res != 0) {
					break;
				}
			}

			System.out.printf("#%d %d\n", tc + 1, res);
		}

	}

	private static void jumpDown(int num, int i, int j, int n) {
		if (visit[i][j] == false) {
			visit[i][j] = true;
			if (i + n < N && n > 0) {
				jumpDown(num, i + n, j, n - 1);
			} else
				return;
		} else {
			res = num + 1;
			return;
		}
	}

	private static void jumpRight(int num, int i, int j, int n) {
		if (visit[i][j] == false) {
			visit[i][j] = true;
			if (j + n < N && n > 0) {
				jumpDown(num, i, j + n, n - 1);
			} else
				return;
		} else {
			res = num + 1;
			return;
		}
	}
}
