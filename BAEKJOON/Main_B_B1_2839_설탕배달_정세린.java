/*
 * 11552KB
 * 80ms
 * 10m
 */
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B_B1_2839_설탕배달_정세린 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 4) {
			System.out.println(-1);
			return;
		}
		int cnt = 0;

		int n = N;
		while (n % 5 != 0) { // 5로 나누어떨어지지 않으면 3을 뺴면서 확인
			n = n - 3;
			cnt++;
			if (n < 0) {
				System.out.println(-1);
				return;
			}
		}
		cnt += n / 5; // 5로 나눔
		
		System.out.println(cnt);
	} // end of main
	
}
