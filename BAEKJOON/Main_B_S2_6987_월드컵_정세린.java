/*
 * 11564KB
 * 80ms
 * 1H 30m
 * dfs, 백트래킹
 */
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_S2_6987_월드컵_정세린 {
	static int[][] score;
	static int[] teamA = new int[15];
	static int[] teamB = new int[15];
	static boolean check = false;
	StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		score = new int[6][3];
		
		int idx = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 6; j++) {
				teamA[idx] = i;
				teamB[idx] = j;
				idx++;
			}
		}
		
		for (int tc = 1; tc <= 4; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 6; i++) { // 6개의 나라에 대하여
				for (int j = 0; j < 3; j++) { // 승 무 패
					score[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end of input
			
			check = false;
			dfs(0);
			if (check) sb.append("1 ");
			else sb.append("0 ");
		} // end of test case
		
		System.out.println(sb.toString());
	} // end of main

	static void dfs(int cnt) {
		if (check) return; // 가능한 결과로 이미 나온경우
		
		if (cnt >= 15) {
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					if (score[i][j] != 0) {
						return;
					}
				}
			}
			check = true;
			return;
		}
		
		int a = teamA[cnt];
		int b = teamB[cnt];
		
		// 1. i승
		score[a][0]--; // i승리점수 +1
		score[b][2]--; // j패배점수 +1
		if (score[a][0] >= 0 && score[b][2] >= 0) dfs(cnt + 1);
		score[a][0]++; // i승리점수 복구
		score[b][2]++; // j패배점수 복구
		
		// 2. j승
		score[b][0]--;
		score[a][2]--;
		if (score[b][0] >= 0 && score[a][2] >= 0) dfs(cnt + 1);
		score[b][0]++; 
		score[a][2]++;
		
		// 3. 무승부
		score[a][1]--;
		score[b][1]--;
		if (score[a][1] >= 0 && score[b][1] >= 0)  dfs(cnt + 1);
		score[a][1]++; 
		score[b][1]++;
	} // end of dfs;
}
