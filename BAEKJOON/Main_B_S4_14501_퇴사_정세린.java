/*
 * 11564KB
 * 88ms
 * 1H
 */
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_S4_14501_퇴사_정세린 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N + 1일날 퇴사
		int[] T = new int[N]; // 걸리는 시간
		int[] P = new int[N]; // 금액
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		} // end of input
		
		int max = 0; // 최대 수당
		int[] pay = new int[N + 1]; // 마지막날 하루치 일을 해도 퇴사날(N+1)일날 돈을 받음
		int dayMax = 0; // 해당 날포함 이전까지의 최대 수당
		
		for (int i = 0; i < N; i++) { // i일에 해당하는 일을 받으면 i+T[i]일날 받을 수 있는 금액
			
			dayMax = Integer.max(pay[i], dayMax); // 오늘의 수당, 이전까지의 수당 중 더 큰것
			
			if (i + T[i] >= N + 1) continue; // 퇴사날 전까지 마루리 할 수 없으면 pass
			
			if (dayMax + P[i] > pay[i + T[i]]) {
				pay[i + T[i]] = dayMax + P[i];
			}
			
			max = Integer.max(max, pay[i + T[i]]);
		}
		
		System.out.println(max);
	} // end of main

}
