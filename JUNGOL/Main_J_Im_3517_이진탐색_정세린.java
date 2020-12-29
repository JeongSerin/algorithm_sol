package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_J_Im_3517_이진탐색_정세린 {
	static int[] ai, bi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ai = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ai[i] = Integer.parseInt(st.nextToken());
		}
		int Q = Integer.parseInt(br.readLine());
		bi = new int[Q];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < Q; i++) {
			bi[i] = Integer.parseInt(st.nextToken());
			binarySearch(bi[i], 0, ai.length - 1);
		}

		Arrays.sort(ai);
		Arrays.sort(bi);

	}

	private static void binarySearch(int bi, int begin, int end) {
		int mid = (begin + end) / 2;

		if (ai[mid] == bi) {
			System.out.print(mid + " ");
			return;
		}

		if (bi >= ai[begin] && bi <= ai[end]) {
			if (bi < ai[mid]) {
				binarySearch(bi, begin, mid - 1);
			} else
				binarySearch(bi, mid + 1, end);
		} else {
			System.out.print(-1 + " ");
			return;
		}
	}

}
