package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5215_햄버거다이어트_정세린 {
	static int N, L, max;
	static int[] T, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tNum = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		for (int tc = 0; tc < tNum; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			T = K = new int[N];
			T = new int[N];
			K = new int[N];

			max = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				T[i] = Integer.parseInt(st.nextToken());
				K[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0, 0);

			System.out.printf("#%d %d\n", tc + 1, max);
		}
	}

	private static void dfs(int v, int tSum, int kSum) {
		if (kSum > L)
			return;
		else if (v == N) {
			if (max < tSum)
				max = tSum;
			return;
		}
		dfs(v + 1, tSum + T[v], kSum + K[v]);
		dfs(v + 1, tSum, kSum);
	}
}
