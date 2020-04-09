/*
 * 113,032 kb
 * 373 ms
 */

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_1251_하나로_정세린 {
	
	static int[] parents;
	static int N;	// 정점 개수
	static int[] xpos;
	static int[] ypos;
	static double E;	// 세율
	static double res;
	static PriorityQueue<Weight> pq = new PriorityQueue<Weight>(new Comparator<Weight>() {
		@Override
		public int compare(Weight o1, Weight o2) {
			return Long.compare(o1.distance, o2.distance);
		}
	});
	
	static class Weight{
		int a, b;
		long distance;
		
		Weight(int a, int b){
			this.a = a;
			this.b = b;
			long distance = (long)(xpos[a] - xpos[b]) * (long)(xpos[a] - xpos[b])
					+ (long)(ypos[a] - ypos[b]) * (long)(ypos[a] - ypos[b]);
			this.distance = distance;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			xpos = new int[N];
			ypos = new int[N];
			parents = new int[N];
			makeSet();
			res = 0;
			pq.clear();
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				xpos[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				ypos[i] = Integer.parseInt(st.nextToken());
			}
			E = Double.parseDouble(br.readLine());
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					pq.offer(new Weight(i, j));
				}
			}
			
			int cnt = 0;
			while (cnt < N - 1) {
				Weight cur = pq.poll();
				if (union(cur.a, cur.b)){ // 유니온 성공시 
					res += cur.distance;
					cnt++;
				}
			}
			
			res = res * E;
			sb.append("#" + tc + " " + Math.round(res) + "\n");
		}
		System.out.println(sb);
	}
	
	private static void makeSet() {
		Arrays.fill(parents, -1);
	}
	
	private static int findSet(int a) {
		// 자신이 대표자면
		if (parents[a] < 0) return a;
		// path compression
		return parents[a] = findSet(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		// 다른 집합이면
		if (aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		// 이미 같은 집합
		return false;
	}
}
