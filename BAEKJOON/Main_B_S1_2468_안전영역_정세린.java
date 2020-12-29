/*
 * 16740kb	
 * 224ms
 */

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_S1_2468_안전영역_정세린 {
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int[][] dh = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		int minh = 100;	// 가장 낮은 건물
		int maxh = 0 ;	// 가장 높은건물
		int max = 0;
		
		// 건물 높이 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxh = map[i][j] > maxh ? map[i][j] : maxh;
				minh = map[i][j] < minh ? map[i][j] : minh;
			}
		}
		
		// 강수량 minh-1 ~ maxh 가장 낮은 건물보다 강수량이 낮으면 영역은 1
		for (int h = minh-1; h <= maxh; h++) {
			int cnt = 0;
			for (int i = 0; i < N; i++)	Arrays.fill(visited[i], false);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > h && !visited[i][j]) {
						dfs(i, j, h);
						cnt++;
					}
				}
			}
			max = cnt > max ? cnt : max;
		}
		System.out.println(max);
	}
	
	private static void dfs(int i, int j, int h) {
		visited[i][j] = true;
		
		for (int d = 0; d < 4; d++) {
			int ni = i + dh[d][0];
			int nj = j + dh[d][1];
			
			if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj]) {
				if (map[ni][nj] > h)	// 물에 잠기지 않으려면 건물이 더 높아야함
					dfs(ni, nj, h);
			}
		}
	}

}
