package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UnionFind {

	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		makeSet(N);
		
		StringTokenizer st = null;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			unionSet(a, b);
		}
		
		for (int i = 1; i <= N; i++) {
			System.out.print(parents[i] + "\t");
		}
	}
	
	// make
	static void makeSet(int n) {
		parents = new int[n + 1];
		Arrays.fill(parents, -1);
	}
	
	// find set
	static int findSet(int a) {
		if (parents[a] < 0) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	// union
	static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

}
