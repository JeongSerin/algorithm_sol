/*
 * 25,820kb
 * 124ms
 */

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_모의_1953_탈주범검거_정세린 {

	static int[][] map;
	static boolean[][] visited;
	static int N, M, R, C, L;
	static int[][][] dh = {
			{{},{},{},{}},	// 0
			{{-1, 0}, {1, 0}, {0, -1}, {0, 1}},	// 1 상하좌우
			{{-1, 0}, {1, 0}},	// 2 상하
			{{0, -1}, {0, 1}},	// 3 좌우
			{{-1, 0}, {0, 1}},	// 4 상우
			{{1, 0},  {0, 1}},	// 5 하우
			{{1, 0},  {0, -1}},	// 6 하좌
			{{-1, 0}, {0, -1}},	// 7 상좌
	};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());	// 맵세로
			M = Integer.parseInt(st.nextToken());	// 맵가로
			R = Integer.parseInt(st.nextToken());	// 맨홀i
			C = Integer.parseInt(st.nextToken());	// 맨홀j
			L = Integer.parseInt(st.nextToken());	// 시간
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			// input
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.offer(R*100 + C);	// i: value/100, j: value%100
			int l = 0;	// time
			int res = 0;
			
			while (l < L) {
				int size = q.size();
				
				while (size-- > 0) {
					int cur = q.poll();
					
					int i = cur / 100;
					int j = cur % 100;
					
					if (!visited[i][j]) {
						visited[i][j] = true;
						res++;
					}
					int dir = map[i][j];	// 파이프로 이동 가능한 방형
					
					for (int d = 0; d < dh[dir].length; d++) {
						int ni = i + dh[dir][d][0];
						int nj = j + dh[dir][d][1];
						
						if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] != 0) {
							// 가려는 곳의 파이프가 현재 위치와 연결되야됨
							int ndir = map[ni][nj];
							boolean flag = false;	// 이동 가능 여부
							// 이동하려는 파이프와 연결되어있는지 확인, 가려는 곳은 현재가는 방향의 반대방향이 이동 가능해야함
							for (int nd = 0; nd < dh[ndir].length; nd++) {
								if (dh[dir][d][0] * (-1) == dh[ndir][nd][0] && dh[dir][d][1] * (-1) == dh[ndir][nd][1]) {
									flag = true;
									break;
								}
							}
							// 연결 되어 있고, 방문한 적 없다면
							if (flag && !visited[ni][nj]) q.offer(ni*100 + nj);
						}
					}
				}
				
				l++;	// 시간 증가
			}// end of bfs
			
			sb.append("#" + tc + " " + res + "\n");
		}// end of tc
		
		System.out.print(sb.toString());
	}// end of main
}


