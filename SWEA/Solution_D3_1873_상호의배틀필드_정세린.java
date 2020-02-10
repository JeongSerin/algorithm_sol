import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1873_상호의배틀필드_정세린 {
	static int[][] dh = { {}, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static int dir, H, W, si, sj;
	static int p, q; // 전차의 위치

	public static void main(String[] args) throws IOException {
// 		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String str;
		int N;
		boolean flag = false;
		String order;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			flag = false;

			for (int i = 0; i < H; i++) {
				str = br.readLine();
				map[i] = str.toCharArray();

				// 전차 찾기
				if (!flag) {
					for (int j = 0; j < map[i].length; j++) {
						if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
							switch (map[i][j]) {
							case '^':
								dir = 1;
								break;
							case 'v':
								dir = 2;
								break;
							case '<':
								dir = 3;
								break;
							case '>':
								dir = 4;
								break;
							}
							p = i;
							q = j;
							flag = true;
							break;
						}
					}
				}
			}
			N = Integer.parseInt(br.readLine());
			// 명령 수행
			order = br.readLine();
			for (int i1 = 0; i1 < N; i1++) {
				switch (order.charAt(i1)) {
				case 'U':
					dir = 1;
					map[p][q] = '^';
					move();
					break;
				case 'D':
					dir = 2;
					map[p][q] = 'v';
					move();
					break;
				case 'L':
					dir = 3;
					map[p][q] = '<';
					move();
					break;
				case 'R':
					dir = 4;
					map[p][q] = '>';
					move();
					break;
				case 'S':
					si = p + dh[dir][0];
					sj = q + dh[dir][1];
					while (si >= 0 && si < H && sj >= 0 && sj < W) {
						if (map[si][sj] == '*') {
							map[si][sj] = '.';
							break;
						}
						if (map[si][sj] == '#')
							break;
						si = si + dh[dir][0];
						sj = sj + dh[dir][1];
					}
					break;
				}
			}
			sb.append('#').append(tc).append(' ');
			for (int i = 0; i < H; i++) {
				sb.append(String.valueOf(map[i])).append('\n');
			}
		}
		System.out.println(sb);
	}

	private static void move() {
		char tmp;
		int i1 = p + dh[dir][0];
		int j1 = q + dh[dir][1];
		if (i1 >= 0 && i1 < H && j1 >= 0 && j1 < W)
			if (map[i1][j1] == '.') {
				tmp = map[p][q];
				map[p][q] = '.';
				p = i1;
				q = j1;
				map[p][q] = tmp;
			}
	}

}
