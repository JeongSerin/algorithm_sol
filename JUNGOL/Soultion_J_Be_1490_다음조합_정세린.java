package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Soultion_J_Be_1490_다음조합_정세린 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); // 개수
		int[] comb = new int[K];
		boolean flag = false;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			comb[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = K - 1; i >= 0; i--) {
			if (comb[i] < N--) {
				comb[i]++;
				if (!flag && i < K - 1)
					comb[i + 1] = comb[i] + 1;
				flag = true;
				break;
			}
		}
		
		if (flag) {
			for (int c : comb)
				System.out.print(c + " ");
		} else
			System.out.println("NONE");
	}
}
