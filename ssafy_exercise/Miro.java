import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Miro {
	static boolean[][] map;
	static int N;
	static int ipos, jpos;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int jumpNum, M, dir, len;

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new boolean[N + 1][N + 1];
			ipos = Integer.parseInt(st.nextToken());
			jpos = Integer.parseInt(st.nextToken());
			jumpNum = Integer.parseInt(st.nextToken());

			for (boolean[] m : map)
				Arrays.fill(m, false);

			st = new StringTokenizer(br.readLine());
			for (int jum = 0; jum < jumpNum; jum++) {
				// 점퍼가 있는 곳은 true
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
			}

			// 1~4 상 우 하 좌
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				dir = Integer.parseInt(st.nextToken());
				len = Integer.parseInt(st.nextToken());
				switch (dir) {
				case 1:
					moveUp(ipos, jpos, len);
					break;
				case 2:
					moveRight(ipos, jpos, len);
					break;
				case 3:
					moveDown(ipos, jpos, len);
					break;
				case 4:
					moveLeft(ipos, jpos, len);
					break;
				}
				if (map[ipos][jpos] == true) {
					ipos = 0;
					jpos = 0;
				}
				if (ipos == 0 && jpos == 0)
					break;
			}
			System.out.printf("#%d %d %d\n", tc + 1, ipos, jpos);
		}
	}

	private static void moveUp(int i, int j, int l) {
		if (l <= 0) {
			ipos = i;
			jpos = j;
			return;
		}
		if (map[i][j] == true || i <= 1) {
			ipos = 0;
			jpos = 0;
			return;
		} else if (i > 1) {
			moveUp(i - 1, j, l - 1);
		}
	}

	private static void moveRight(int i, int j, int l) {
		if (l <= 0) {
			ipos = i;
			jpos = j;
			return;
		}
		if (map[i][j] == true || j >= N) {
			ipos = 0;
			jpos = 0;
			return;
		} else if (j < N) {
			moveRight(i, j + 1, l - 1);
		}
	}

	private static void moveDown(int i, int j, int l) {
		if (l <= 0) {
			ipos = i;
			jpos = j;
			return;
		}
		if (map[i][j] == true || i >= N) {
			ipos = 0;
			jpos = 0;
			return;
		} else if (i < N) {
			moveDown(i + 1, j, l - 1);
		}
	}

	private static void moveLeft(int i, int j, int l) {
		if (l <= 0) {
			ipos = i;
			jpos = j;
			return;
		}
		if (map[i][j] == true || j <= 1) {
			ipos = 0;
			jpos = 0;
			return;
		} else if (j > 1) {
			moveUp(i, j - 1, l - 1);
		}
	}

}
