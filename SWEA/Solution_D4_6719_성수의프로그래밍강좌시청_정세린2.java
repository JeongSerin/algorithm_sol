/*
 * 31,156 kb
 * 131 ms
 */

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_6719_성수의프로그래밍강좌시청_정세린2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int N;			// 전체 강좌 수
		int K;			// 들을 강좌 수
		int[] M;		// 강좌 레벨
		double A = 0;	// 성수의 실력
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			// 입력
			A = 0;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = new int[N];
			K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				M[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(M);
			// 레빌의 가장 높은 강좌 (N-K) ~ (N-1) 번째 까지
			for (int i = (N-K); i < N; i++) {
				A = (A + M[i]) / 2;
			}
			sb.append("#" + tc + " " + A + "\n");
		}
		System.out.println(sb);
	}

}
