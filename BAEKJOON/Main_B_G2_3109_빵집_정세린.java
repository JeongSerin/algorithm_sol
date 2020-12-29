package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_G2_3109_빵집_정세린 {
	
	static int[][] dh = {{-1, 1}, {0, 1}, {1, 1}};
	static boolean[][] visited;
	static char[][] map;
	static int R, C, cnt = 0;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[R][C];
		map = new char[R][C];
		
		
		for(int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for (int i = 0; i < R; i++) {
			flag = false;
			if(!visited[i][0]) {
				dfs(i, 0);
			}
		}
		System.out.println(cnt);
		
	}
	
	private static void dfs(int i, int j) {
		if (flag) return;
		if (j == C-1) {
			cnt++;
			flag =true;
		}
		visited[i][j] = true;
		for (int dir = 0; dir < 3; dir++) {
			int itmp = i + dh[dir][0];
			int jtmp = j + dh[dir][1];
			if (itmp >= 0 && itmp < R && jtmp >= 0 && jtmp < C && !visited[itmp][jtmp] && map[itmp][jtmp] == '.')
				dfs(itmp, jtmp);
		}
	}
	
}
