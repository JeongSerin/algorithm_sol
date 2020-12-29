/*
 * 26,612 kb
 * 212 ms
 */
package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5607_Professional조합_정세린 {
	static final int mod = 1234567891;
	static int N, R;
	static long nFac, rFac, nrFac;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		long res;
		
		for (int tc = 1; tc <= T; tc++) {
			nFac = 1;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			
			factorial(N);
			long down = pow((rFac * nrFac) % mod, mod-2);
			res = (nFac * down) % mod;
			
			sb.append("#" + tc + " " + res + "\n");
		}
		System.out.println(sb);
	}
	
	private static void factorial(int n) {
		for (int i = 1; i <= n; i++) {
			nFac = (nFac * i) % mod;
			if (i == R) rFac = nFac;
			if (i == (N - R)) nrFac = nFac;
		}
	}
	
	private static long pow (long num, int p) {
		if (p == 0) return 1;
		long n = pow(num, p / 2);
		long tmp = (n * n) % mod;
		if (p % 2 == 0) return tmp;
		else return (tmp * num) % mod;
	}

}
