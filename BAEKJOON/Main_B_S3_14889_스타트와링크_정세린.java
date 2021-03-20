/*
 * 13544KB
 * 308ms
 * 1H
 * 완탐
 * 1. combination으로 팀 짜기
 * 2. 두 팀의 능력치 차 구한뒤 min갱신
 */
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_S3_14889_스타트와링크_정세린 {
	static int[][] power;
	static boolean[] selected;
	static int N;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		power = new int[N][N];
		selected = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
			for (int j = 0; j < N; j++) {
				power[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of input
		
		combination(N, N/2, 0);
		
		System.out.println(min);
	} // end of main
	
	static void combination(int n, int r, int idx) {
		if (r == 0) { // 조합 완성
			sumPower();
			return;
		}
		
		for (int i = idx; i < n; i++) {
			selected[i] = true;
			combination(n, r - 1, i + 1);
			selected[i] = false;
		}
	} // end of combination
	
	static void sumPower () { // 두 팀의 능력치 합을 구함
		int team1 = 0;
		int team2 = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (selected[i] && selected[j]) { // 선택된 팀
					team1 += power[i][j];
					team1 += power[j][i];
				}
				if ((!selected[i]) && (!selected[j])) { // 선택되지 않은 다른 팀
					team2 += power[i][j];
					team2 += power[j][i];
				}
			}
		} // end of for
		
		int sub = Math.abs(team1 - team2);
		min = Integer.min(min, sub);
	} // end of sumPower
}
