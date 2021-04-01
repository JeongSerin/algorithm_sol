package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PermutationRecursiveTest {
	static boolean[] visited;
	static int[] selected;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		visited = new boolean[N];
		selected = new int[R];

		permutation(N, R);
	}
	
	static void permutation(int n, int r) {
		if (r == 0) {
			System.out.println(Arrays.toString(selected));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			selected[r - 1] = i;
			permutation(n, r - 1);
			visited[i] = false;
		}
	}

}
