/*
 22280KB
 380ms
 2h
 DP 분할정복, memo[a][b] : a~b까지 연산 횟수 최솟값 저장
 유사한 문제: B_G3_11066_파일합치기
*/
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B_G3_11049_행렬곱셈순서_정세린 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 행렬의 개수
		int[][] memo = new int[N][N];	// n1 ~ n2까지 곱셈연산의 최솟값
		int[][][] size = new int[N][N][2]; 	//[n][n][0]: r, [n][n][1]: c
		
		for (int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], Integer.MAX_VALUE);
		}
		
		StringTokenizer st = null;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			size[n][n][0] = Integer.parseInt(st.nextToken());
			size[n][n][1] = Integer.parseInt(st.nextToken());
			memo[n][n] = 0;
			
			if (n > 0) {	
				memo[n-1][n] = size[n-1][n-1][0] * size[n-1][n-1][1] * size[n][n][1];	// n-1, n곱셈 연산 수
				size[n-1][n][0] = size[n-1][n-1][0];
				size[n-1][n][1] = size[n][n][1];	// n-1, n곱셈 후 행렬 크기
			}
		}	// end of input
		
		// i~d, d~j합
		for (int x = 2; x < N; x++) {	// 우상>좌하 대각방향 [0][2], [1][3], [2][4], ... [0][3], [1][4], ...
			for (int t = 0; t < N; t++) {
				int i = t;
				int j = t + x;
				if (j >= N) continue;
				
				for (int d = i; d < j; d++) {	// i~d, d~j
					int tmp = memo[i][d] + memo[d+1][j];	// i~d + d~j 각 연산 횟수 합
					tmp += size[i][d][0] * size[i][d][1] * size[d+1][j][1]; 	// 두개를 곱했을 떄 연산 횟수 더함
					if (tmp < memo[i][j]) {	// 전보다 작은 값이면
						memo[i][j] = (memo[i][j] < tmp) ? memo[i][j] : tmp;	// 다시 저장	
						size[i][j][0] = size[i][d][0];	// 해당 값에 대한 행렬의 크기 저장
						size[i][j][1] = size[d+1][j][1];	
					}
				}
			}
		}

		System.out.println(memo[0][N-1]);
	}
	
}
