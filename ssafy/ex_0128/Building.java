package ssafy.ex_0128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Building {
	static char[][] map;
	static int N;
	static int[][] d = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
	static int itmp, jtmp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int max = 0;
		StringTokenizer st = null;
		int isum, jsum;

		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			max = 0;
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
			System.out.printf("#%d %d\n", tc + 1, max);
		}
	}

	private static boolean green(int i, int j) {
		for (int k = 0; k < 8; k++) {
			itmp = i + d[k][0];
			jtmp = j + d[k][1];
			if (itmp >= 0 && itmp < N && jtmp >= 0 && jtmp < N) {
				if (map[itmp][jtmp] == 'G') {
					return true;
				}
			}
		}
		return false;
	}

}
