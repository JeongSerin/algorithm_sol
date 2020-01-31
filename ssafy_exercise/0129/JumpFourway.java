import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JumpFourway {
	static int[][] dir = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 0x1동2남3서4북
	static int[][] map; // 십의자리 방향, 일의자리 이동칸수, 0은 함정, 상금x-1000
	static int Y, X, N;
	static int money;
	static int[][] man;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int trap;
		int itmp, jtmp;

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			Y = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[Y + 1][X + 1];
			N = Integer.parseInt(st.nextToken());
			man = new int[N][3]; // 행 열, 횟수

			money = 0;

			for (int i = 1; i < Y + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < X + 1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				man[n][0] = Integer.parseInt(st.nextToken());
				man[n][1] = Integer.parseInt(st.nextToken());
				man[n][2] = Integer.parseInt(st.nextToken());

			}
			st = new StringTokenizer(br.readLine());
			trap = Integer.parseInt(st.nextToken());
			for (int t = 0; t < trap; t++) {
				itmp = Integer.parseInt(st.nextToken());
				jtmp = Integer.parseInt(st.nextToken());
				map[itmp][jtmp] = 0;
			}

			for (int n = 0; n < N; n++) {
				jumping(man[n][0], man[n][1], man[n][2]);
			}
			System.out.printf("#%d %d\n", tc + 1, money);
		}
	}

	private static void jumping(int i, int j, int cnt) {
		// 범위 내일때
		if (i > 0 && i < Y + 1 && j > 0 && j < X + 1) {
			// 함정
			if (map[i][j] == 0) {
				money = money - 1000; // 참가비 -1000
				return;
			} else if (cnt == 0) {
				// 함정이 아니고 도착하면
				money = money + map[i][j] * 100 - 1000; // 참가비 -1000
				return;
			}
			int d = map[i][j] / 10;
			int len = map[i][j] % 10;
			jumping(i + len * dir[d][0], j + len * dir[d][1], cnt - 1);

		} else {
		    // 맵을 벗어나면
			money = money - 1000; // 참가비 -1000
			return;
		}
	}

}
