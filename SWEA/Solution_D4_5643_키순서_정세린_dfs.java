package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_5643_키순서_정세린_dfs {
	static boolean[][] adj;
	static boolean[] visited;
	static int V, E, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			V = Integer.parseInt(br.readLine().trim());
			E = Integer.parseInt(br.readLine().trim());
			adj = new boolean[V+1][V+1];
			visited = new boolean[V+1];
			int res = 0;
			
			// 간선 추가
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from][to] = true;
			}
			
			for (int i = 1; i <= V; i++) {
				cnt = 0;
				
				Arrays.fill(visited, false);
				dfs1(i);
				Arrays.fill(visited, false);
				dfs2(i);
				
				if (cnt == V - 1) res++;
			}
			sb.append("#" + tc + " " + res + "\n");
		}
		
		System.out.print(sb.toString());
	}
	
	private static void dfs1(int idx){
		visited[idx] = true;
		for (int i = 1; i <= V; i++) {
			if (!visited[i] && adj[idx][i]) {
				cnt++;
				dfs1(i);
			}
		}
	}
	
	private static void dfs2(int idx){
		visited[idx] = true;
		for (int i = 1; i <= V; i++) {
			if (!visited[i] && adj[i][idx]) {
				cnt++;
				dfs2(i);
			}
		}
	}

}
