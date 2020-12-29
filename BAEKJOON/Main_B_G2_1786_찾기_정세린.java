/*
 * 77312KB
 * 472ms
 */

package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B_G2_1786_찾기_정세린 {

	
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
	
	static void searchKMP(String parent, String pattern) {
		int[] table = getPi(pattern);
		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		
		int j = 0; 
		for(int i = 0 ; i< parent.length(); i++) {
			while(j >0 && parent.charAt(i) != pattern.charAt(j)) {
				j = table[j - 1];
			}
			if(parent.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length()-1) {
					sb.append((i-pattern.length()+1+1) + "\n");
					cnt++;
					j = table[j];
				}else {
					j++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String pattern = br.readLine();
		searchKMP(origin, pattern);
	}

}
