package BAEKJOON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_B_S1_2667_단지번호붙이기_정세린_bfs {
	static Queue<Integer> housesQueue = new PriorityQueue<Integer>();
	static int[][] billage;
	static boolean[][] visited;
	static int N, housecnt, groupcnt;
	static int[][] dh = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		billage = new int[N][N];
		visited = new boolean[N][N];
		String str;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < N; j++) {
				billage[i][j] = (str.charAt(j) - '0');
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && billage[i][j] > 0) {
					housecnt = 0;
					bfs(i * 100 + j);
					housesQueue.offer(housecnt);
				}
			}
		}
		groupcnt = housesQueue.size();
		while (!housesQueue.isEmpty())
			sb.append(housesQueue.poll()).append('\n');
		System.out.println(groupcnt + "\n" + sb.toString());
	}

	private static void bfs(int start) {
		int i = start / 100;
		int j = start % 100;
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[i][j] = true;
		queue.offer(start);
		housecnt++;

		int current;

		while (!queue.isEmpty()) {
			current = queue.poll();
			i = current / 100;
			j = current % 100;
			for (int d = 0; d < 4; d++) {
				int id = i + dh[d][0];
				int jd = j + dh[d][1];
				if (id < 0 || id >= N || jd < 0 || jd >= N)
					continue;
				// 집이 있고 근방 노드가 미방문일때
				if (billage[id][jd] > 0 && !visited[id][jd]) {
					visited[id][jd] = true;
					housecnt++;
					queue.offer(id * 100 + jd);
				}
			}
		}
	}
}
