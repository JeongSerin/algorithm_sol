package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1258_행렬찾기_정세린 {

	static class Case implements Comparable<Case> {
		int size;
		int i;
		int j;

		Case(int i, int j) {
			this.i = i;
			this.j = j;
			this.size = this.i * this.j;
		}

		@Override
		public int compareTo(Case o) {
			Integer s1 = this.size;
			Integer s2 = o.size;
			if (s1.compareTo(s2) == 0) {
				Integer i1 = this.i;
				Integer i2 = o.i;
				return i1.compareTo(i2);
			}
			return s1.compareTo(s2);
		}
	}

	static int[][] matters;
	static int n;
	static boolean[][] visited;
	static int[][] dh = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int iend, jend;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		// 용기 사이즈를 담는 큐
		Queue<Case> queue = new PriorityQueue<Case>();

		for (int tc = 1; tc <= T; tc++) {

			n = Integer.parseInt(br.readLine());
			visited = new boolean[n][n];

			matters = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					matters[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (boolean[] v : visited) {
				Arrays.fill(v, false);
			}
			cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					iend = i;
					jend = j;
					if (!visited[i][j] && matters[i][j] > 0) {
						dfs(i, j);
						queue.offer(new Case(iend - i + 1, jend - j + 1));
						cnt++;
					}
				}
			}
			sb.append('#').append(tc).append(' ').append(cnt).append(' ');
			while (!queue.isEmpty()) {
				sb.append(queue.peek().i).append(' ').append(queue.poll().j).append(' ');
//				sb.append(queue.poll().size).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	private static void dfs(int i, int j) {
		visited[i][j] = true;
		if (i > iend) iend = i;
		if (j > jend) jend = j;

		for (int dir = 0; dir < 4; dir++) {
			int itmp = i + dh[dir][0];
			int jtmp = j + dh[dir][1];

			if (itmp >= 0 && itmp < n && jtmp >= 0 && jtmp < n) {
				if (!visited[itmp][jtmp] && matters[itmp][jtmp] > 0) {
					dfs(itmp, jtmp);
				}
			}
		}
	}

}