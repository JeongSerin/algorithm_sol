package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D3_1289_원재의메모리복구하기_정세린 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(bf.readLine());
		String[] test = new String[5000];
		char[] fst = new char[50]; // 초기값
		Arrays.fill(fst, '0');
		char[] testArr;

		int cnt = 0;
		for (int i = 0; i < T; i++) {
			test[i] = bf.readLine();
		}

		for (int i = 0; i < T; i++) {
			cnt = 0;
			Arrays.fill(fst, '0');
			// test문자열 문자배열로
			testArr = test[i].toCharArray();
			// test 첫번째 자리부터
			for (int num = 0; num < testArr.length; num++) {
//			 문자가 다르면	
				if (fst[num] != testArr[num]) {
					cnt++;
					Arrays.fill(fst, num, testArr.length, testArr[num]);
				}
			}
//			System.out.println(fst);
			System.out.printf("#%d %d", i + 1, cnt);
			if (i < T - 1)
				System.out.println();

		}
	}
}