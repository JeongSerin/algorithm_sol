package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_G2_2252_줄세우기_정세린 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[] inDgree = new int[V+1];
		StringBuilder sb = new StringBuilder();
		List<List<Integer>> edge = new ArrayList<List<Integer>>();
		
		for (int i = 0; i <= V; i++) {
			edge.add(new ArrayList<>());
		}
		
		// 간선 추가
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			edge.get(from).add(to);
			inDgree[to]++;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		// 진입차수가 0인 정점 push
		for (int v = 1; v <= V; v++) {
			if (inDgree[v] == 0) q.offer(v); 
		}
		
		for (int i = 1; i <= V; i++) {
			// 사이클
			
			if (q.isEmpty()) break;

			int cur = q.poll();
			sb.append(cur + " ");

			
			for (int j = 0; j < edge.get(cur).size(); j++) { // 현재 정점과 연결된 간선들
				// 간선 확인
				int to = edge.get(cur).get(j);
				// 진입 차수가 하나 줄음
				inDgree[to]--;
				
				// 진입차수가 0 이면 push 
				if (inDgree[to] == 0) q.offer(to);
			}
		}
		
		System.out.println(sb.toString());
	}

}
