/*
 * 95,124kb
 * 2,285ms
 */
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

public class Solution_D4_5643_키순서_정세린_FloydWarshall {
	static int[][] adj;
	static int V, E;
	static final int INF = 999_999;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			V = Integer.parseInt(br.readLine().trim());
			E = Integer.parseInt(br.readLine().trim());
			adj = new int[V+1][V+1];
			for (int i = 1; i <= V; i++) Arrays.fill(adj[i], INF);
			int res = 0;
			
			// 간선 추가
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from][to] = 1;
			}
			
			for (int k = 1; k <= V; k++) {
				for (int i = 1; i <= V; i++) {
					for (int j = 1; j <= V; j++) {
						if (adj[i][k] + adj[k][j] < adj[i][j]) {
							adj[i][j] = adj[i][k] + adj[k][j]; 
						}
					}
				}
			}
			
			int[] cnt = new int[V+1]; 
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if (adj[i][j] != INF) {
						cnt[i]++;
						cnt[j]++;
					}
				}
			}
			
			for (int i = 1; i <= V; i++) {
				if (cnt[i] == V - 1) res++;
			}
			
			sb.append("#" + tc + " " + res + "\n");
		}
		System.out.print(sb.toString());
	}

}
