/*
 * 282780KB
 * 868ms
 * 2H
 * dfs, bfs
 */
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_G4_1707_이분그래프_정세린 {
	static int V, E;
	static ArrayList<ArrayList<Integer>> abj;
	static int[] color;
	static boolean flag = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			abj = new ArrayList<>();
			for (int i = 0; i <= V; i++) abj.add(new ArrayList<Integer>());
			color = new int[V + 1];
			flag = false;
			
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine(), " ");
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				
				abj.get(i).add(j);
				abj.get(j).add(i);
			} // end of input
			
			for (int i = 1; i <= V; i++) {
				if(color[i] == 0) {
					color[i] = 1;
					dfs(i);
//					bfs(i);
				}
				if (flag) break;
			}
			
			if (flag) sb.append("NO\n");
			else sb.append("YES\n");
		} // end of test case
		
		System.out.println(sb.toString());
	} // end of main

	static void dfs(int from) {
		if (flag) return;
		
		for (Integer to: abj.get(from)) {
			if (color[to] == 0) {
				color[to] = color[from] * -1;
				dfs(to);
			} else if (color[to] == color[from]){
				flag = true;
				return;
			}
		} // end of for
		
	} // end of dfs
	
	static void bfs(int from) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(from);
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int to: abj.get(cur)) {
				if (color[to] == 0) {
					color[to] = color[cur] * -1;
					q.offer(to);
				}else if (color[cur] == color[to]) {
					flag = true;
					return;
				}
			}
		}
	} // end of bfs
	
}
