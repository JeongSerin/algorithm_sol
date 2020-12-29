package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ING_Main_J_Im_1077_배낭채우기1_정세린 {
	static int N, W;
	static int[] Wi, Pi, bagW, bagP;
	static int[] memo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Wi = new int[N];
		Pi = new int[N];
		bagP = new int[W + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Pi[i] = Integer.parseInt(st.nextToken());
		}

//		for (int i = 0; i <= W; i++) {
//			for (int j = 0; j < N; j++) {
//				if (Wsum > i) continue;
//				if (Wsum <= i) {
//					bagP[i] = bagP[i] + Pi[j];
//					Wsum = Wsum + Wi[j];
//				}
//			}
//		}
		packing(0, W, 0);

	}

	private static void packing(int index, int weight, int Psum) {
		if (index == N)
			return;
		if (weight < 0)
			return;

		for (int i = 0; i < N; i++) {
			packing(index + 1, weight - Wi[index], Psum + Pi[i]);
			packing(index + 1, weight, Psum);
		}
	}

}
