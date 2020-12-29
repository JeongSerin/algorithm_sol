package ssafy.ex_0128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RobotABC {
	static int cnt, N;
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		// A 우, B 좌우, C 상하좌우
		// S 공백, W 벽, A, B, C로봇
		for (int tc = 0; tc < T; tc++) {
			cnt = 0;
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
					switch (map[i][j]) {
					case 'A':
						goRight(i, j);
						break;
					case 'B':
						goRight(i, j);
						goLeft(i, j);
						break;
					case 'C':
						goRight(i, j);
						goLeft(i, j);
						goDown(i, j);
						goUp(i, j);
						break;
					}
				}
			}
			System.out.printf("#%d %d\n", tc + 1, cnt);
		}
	}

	private static void goLeft(int i, int j) {
		if (j > 0 && map[i][j - 1] == 'S') {
			cnt++;
			goLeft(i, j - 1);
		} else
			return;
	}

	private static void goRight(int i, int j) {
		if (j < N - 1 && map[i][j + 1] == 'S') {
			cnt++;
			goRight(i, j + 1);
		} else
			return;
	}

	private static void goDown(int i, int j) {
		if (i < N - 1 && map[i + 1][j] == 'S') {
			cnt++;
			goDown(i + 1, j);
		} else
			return;
	}

	private static void goUp(int i, int j) {
		if (i > 0 && map[i - 1][j] == 'S') {
			cnt++;
			goUp(i - 1, j);
		} else
			return;
	}
}
