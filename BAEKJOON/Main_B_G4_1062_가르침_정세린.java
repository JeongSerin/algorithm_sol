/*
 * 15504KB
 * 496ms
 */

package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_G4_1062_가르침_정세린 {
	static int N;	// 단어의 수
	static int K;	// 가르치는 글자 수 (1개 이상의 단어를 알려면 a, c, i, n, t 5개 이상의 글자를 가르쳐야함)
	static String[] words;	// 단어들
	static char[] alpha;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		words = new String[N];
		
		if (K < 5)	{	// 글자를 5개 미만으로 알려주면 단어를 아무것도 모름
			System.out.println(0);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}

		alpha = new char[K - 5];
		combination(0, 'b');
		
		System.out.println(max);
		
	}
	
	private static void combination(int cnt, char cur) {
		if (cnt == K - 5) {
			canRead(alpha);
			return;
		}
		
		for (char c = cur; c <= 'z'; c++) {
			if (c == 'a'|| c == 'c'|| c == 'i' || c == 'n' || c == 't') continue;
			alpha[cnt] = c;
			combination(cnt + 1, (char)(c + 1));
		}
	}
	
	private static void canRead(char[] a) {
		int cnt = 0;
		
		L:for (int i = 0; i < N; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				char c = words[i].charAt(j);
				if (c == 'a'|| c == 'c'|| c == 'i' || c == 'n' || c == 't') continue;
				if (!isin(c, a)) continue L;
			}
			cnt++;
		}
		
		max = cnt > max ? cnt : max;
	}
	
	private static boolean isin(char c, char[] a) {
		for (int i = 0; i < a.length; i++) {
			if (c == a[i]) return true;
		}
		
		return false;
	}
	
}
