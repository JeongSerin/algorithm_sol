import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ING_Main_B_G4_17135_캐슬디펜스_정세린 {

	static class PointDistance {
		int i;
		int j;
		int distance;

		public PointDistance(int i, int j, int distance) {
			this.i = i;
			this.j = j;
			this.distance = distance;
		}
	}

	static int[][] map, originalmap;
	static int N, M, D, cnt, max = 0;
	static int[] archer;
	static Queue<PointDistance> enemy = new PriorityQueue<PointDistance>(new Comparator<PointDistance>() {

		@Override
		public int compare(PointDistance o1, PointDistance o2) {
			Integer d1 = o1.distance;
			Integer d2 = o2.distance;
			return d1.compareTo(d2);
		}
	});

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		archer = new int[3];
		map = new int[N][M];
		originalmap = new int[N][M];
		int index = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				originalmap[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		L: for (int comb = 7; comb < (1 << M); comb++) {

			Arrays.fill(archer, 0);

			index = 0;
			for (int a = 0; a < M; a++) {
				if ((comb >> a) % 2 == 1) {
					if (index == 3)
						continue L;
					archer[index++] = a;
				}
			}
			if (index < 3)
				continue L;

			for (int i = 0; i < N; i++) {
				map[i] = Arrays.copyOf(originalmap[i], originalmap[i].length);
			}

			cnt = 0;
			attack(N);
			max = Math.max(cnt, max);

		}
		System.out.println(max);
	}

	private static void attack(int ipos) {
		while (ipos-- > 0) {

			for (int a = 0; a < 3; a++) {

				for (int i = 0; i < ipos; i++) {
					for (int j = 0; j < M; j++) {
						if (map[i][j] == 1) {
							int idistance = ipos - i;
							int jdistance = Math.abs(archer[a] - j);
							int distance = idistance + jdistance;
							if (distance <= D) {
								PointDistance p = new PointDistance(i, j, distance);
								enemy.offer(p);
							}
						}
					}
				}
				while (!enemy.isEmpty()) {
					if (map[enemy.peek().i][enemy.peek().j] == 1) {
						map[enemy.peek().i][enemy.peek().j] = 0;
						enemy.poll();
						cnt++;
						enemy.clear();
						break;
					}
					if (map[enemy.peek().i][enemy.peek().j] == 0)
						enemy.poll();
				}

			}
		}
	}
}
