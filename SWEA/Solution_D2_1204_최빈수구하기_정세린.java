package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D2_1204_최빈수구하기_정세린 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int[] cnt = new int[101];
		int num;
		int index = 0, max = 0;
		int score;
		// 입력
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			Arrays.fill(cnt, 0);
			max = 0;
			num = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 1000; j++) {
				score = Integer.parseInt(st.nextToken());
				cnt[score]++;

			}

			for (int k = 0; k < cnt.length; k++) {
				if (max <= cnt[k]) {
					max = cnt[k];
					index = k;
				}

			}

			System.out.printf("#%d %d\n", num, index);
		}

	}
}
