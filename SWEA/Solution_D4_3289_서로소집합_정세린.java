package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_3289_서로소집합_정세린 {
	static int[] parents;

	private static void makeSet() {
		Arrays.fill(parents, -1);
	}

	private static int findSet(int a) {
		if (parents[a] < 0) return a;
		return parents[a] = findSet(parents[a]);
	}

	private static boolean sameSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot != bRoot) {
			return true;
		}
		return false;
	}
	
	private static void unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot != bRoot) 
			parents[bRoot] = aRoot;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int N, M, option;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#" + tc + " ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			parents = new int[N+1];
			makeSet();
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				option = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// 다른집합이면 0, 같은 집합이면 1
				if (option == 1) sb.append(sameSet(a, b)?  0 : 1);
				if (option == 0) unionSet(a, b);
				}
			sb.append('\n');
			}
		System.out.println(sb);
		}
	
}
