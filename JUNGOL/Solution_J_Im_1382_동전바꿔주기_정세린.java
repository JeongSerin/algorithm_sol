package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_J_Im_1382_동전바꿔주기_정세린 {
	static int T, k;
	static int[] p, n;
	static int cnt = 0, sum = 0;
	static int[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); // 금액
		k = Integer.parseInt(br.readLine()); // 동전 가지수
		p = new int[k]; // 동전 금액
		n = new int[k]; // 동전 개수
		visit = new int[k];
		StringTokenizer st = null;

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
			n[i] = visit[i] = Integer.parseInt(st.nextToken());
		}
		
		
		System.out.println(cnt);
	}

	
		
}
