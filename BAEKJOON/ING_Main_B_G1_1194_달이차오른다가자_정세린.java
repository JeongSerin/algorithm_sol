package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ING_Main_B_G1_1194_달이차오른다가자_정세린 {
	static int N, M;	// 세로, 가로
	static char[][] map;
	static boolean[][] visited;
	static int min = Integer.MAX_VALUE;
	static boolean[] key = new boolean[6];	// ['key' - 97]
	static int pos;	// i*100 + j
	static int[][] dh = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];
		boolean findFlag = false;
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
			// 민식이의 초기 위치
			if (!findFlag) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == '0') pos = i * 100 + j;
				}
			}
		}	// end of input
		dfs(pos/100, pos%100, 0);
		
		if (min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}
	
	static void dfs (int i, int j, int cnt) {
		System.out.println(i + " " + j + ": " + map[i][j]);
		visited[i][j] = true;
		if (map[i][j] == '1') {
			min = (min < cnt)? min : cnt;	// 출구 만남 
			return;
		}
		if (map[i][j] == '#') return;	// 벽을 만나면 뒤로
		if (map[i][j] >= 'A' && map[i][j] <= 'F') {	// 문을 만나면
			if (!key[map[i][j] - 65]) {
				visited[i][j] = false;
				return;	// 문에 해당하는 키가 없으면 돌아감
			}
		}
		if (map[i][j] >= 'a' && map[i][j] <= 'f') {
			key[map[i][j] - 97] = true;	// 키를 주움
		}
		
		
		for (int d = 0; d < 4; d++) {
			int ni = i + dh[d][0];
			int nj = j + dh[d][1];
			if (ni < 0 || ni >= N || nj < 0 || nj >= M) continue;
			if (!visited[ni][nj]) dfs(ni, nj, cnt + 1);
			visited[i][j] = false;
		}
	}
	
	// bfs
	
}
