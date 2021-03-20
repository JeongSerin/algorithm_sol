/*
 * 11900KB
 * 80ms
 * 1H 30m
 * greedy (완탐은 시간초과)
 * 1. 각 행에서 0의개수를 셈
 * 2. 0의 개수와 K의 개수가 홀수인지 짝수인지 구함
 * 3. 둘이 짤수 홀수 다르다면 K번 스위치 눌러서 킬 수 없는행임.
 * 4. 둘다 짝수 또는 홀수이면 같은 패턴을 가진 행의개수를 구한뒤 max값 갱신
 */
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_G5_1034_램프_정세린 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열
		String[] lamp = new String[N];
		for (int i = 0; i < N; i++) {
			lamp[i] = br.readLine();
		} 
		int K = Integer.parseInt(br.readLine()); // 스위치를 누르는 횟수
		// end of input
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			int patternCnt = 0; // 같은 패턴을 가진 램프Cnt
			int zeroCnt = 0; // 꺼진 램프의 개수
			
			char[] curLamp = lamp[i].toCharArray();
			for (int j = 0; j < M; j++) 
				if (curLamp[j] == '0') zeroCnt++; // 해당 행에서 꺼진 램프의 수
			
			// 해당 행은 K번 스위치를 눌러 불을 전부 켤 수 없음
			if (zeroCnt > K || (zeroCnt % 2 != K % 2)) continue;
			
			for (int j = 0; j < N; j++)  // 같은 패턴을 가진 램프의 수
				if (lamp[i].equals(lamp[j])) patternCnt++;
			
			max = Integer.max(max, patternCnt);
		}
		
		System.out.println(max);
	} // end of main

}
