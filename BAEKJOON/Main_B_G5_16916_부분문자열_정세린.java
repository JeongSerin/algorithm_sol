/*
 * 31712KB
 * 292ms
 */

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B_G5_16916_부분문자열_정세린 {
	
	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];

		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {

			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			if (pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		return pi;
	}
	
	static void searchKMP(String origin, String pattern) {
		int[] table = getPi(pattern);
		int j = 0; 
		for(int i = 0 ; i< origin.length(); i++) {
			while(j >0 && origin.charAt(i) != pattern.charAt(j)) {
				j = table[j - 1];
			}
			//부모와 패턴이 일치한다면
			if(origin.charAt(i) == pattern.charAt(j)) {
				//j의 값이 패턴의 길이-1이라면 한번 다찾은거니까
				//찾앗다고 처리
				if(j == pattern.length()-1) {
					System.out.println(1);
					return;
				}else {
					j++;
				}
			}
		}
		System.out.println(0);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String pattern = br.readLine();
		searchKMP(origin, pattern);
	}

}
