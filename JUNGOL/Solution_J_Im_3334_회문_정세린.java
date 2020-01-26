package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_J_Im_3334_회문_정세린 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		String str;
		char[] strArr;
		int diffCnt = 0, diffCnt1 = 0;
		int b;

		for (int i = 0; i < T; i++) {
			diffCnt = 0;
			diffCnt1 = 0;
			str = br.readLine();
			strArr = str.toCharArray();
			b = strArr.length - 1;
			for (int f = 0; f < strArr.length / 2;) {
				if (strArr[f] != strArr[b] && b > strArr.length / 2) {
					b--;
					diffCnt++;
				} else {
					f++;
					b--;
				}
			}

			if (diffCnt >= 2) {
				b = strArr.length - 1;
				for (int f = 0; f < strArr.length / 2 + 1;) {

					if (strArr[f] != strArr[b] && b > strArr.length / 2) {
						f++;
						diffCnt1++;
					} else {
						f++;
						b--;
					}
				}

				diffCnt = (diffCnt < diffCnt1) ? diffCnt : diffCnt1;
			}
			if (diffCnt > 2)
				diffCnt = 2;

			System.out.println(diffCnt);
		}
	}
}
