/*
 * 47884KB
 * 436ms
 */

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_B_G4_1197_최소스패닝트리_정세린 {
	static int[] parents;
	static int V, E;
	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {
		@ Override
		public int compare(Edge o1, Edge o2) {
			return Integer.compare(o1.weight, o2.weight);
		};
	});
	
	static class Edge{
		int a, b, weight;

		public Edge(int a, int b, int weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		makeSet(V + 1);
		
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());	// v1
			int b = Integer.parseInt(st.nextToken());	// v2
			int w = Integer.parseInt(st.nextToken());	// weight
			pq.offer(new Edge(a, b, w));
		}
		
		int edgeCnt = 0;
		int result = 0;
		while (edgeCnt < V - 1) {
			Edge cur = pq.poll();
			if (unionSet(cur.a, cur.b)) {
				result += cur.weight;
				edgeCnt++;
			}
		}
		System.out.println(result);
	}
	
	private static void makeSet(int size) {
		parents = new int[size];
		Arrays.fill(parents, -1);
	}
	
	private static int findSet(int a) {
		if (parents[a] < 0) return a;
		return parents[a] = findSet(parents[a]);

	}
	
	private static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}

}
