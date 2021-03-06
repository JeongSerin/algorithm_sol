package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 6^7  약 28만, 다 돌려봐도 됨
public class Main_J_Be_1175_주사위던지기2_정세린 {
	static int N, M;
	static int[] numbers;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 던진 횟수
		M = Integer.parseInt(st.nextToken()); // 눈의 합
		numbers = new int[N];

		dice(M, 0);
	}

	private static void dice(int m, int index) {
	    // 재귀 가지치기
	    // if (m < 0) return;
		if (index == N) {
			if (m == 0) {
				for (int i = 0; i < N; i++) {
					System.out.print(numbers[i] + " ");
				}
				System.out.println();
			}
			return;
		}
		for (int i = 1; i <= 6; i++) {
			numbers[index] = i;
			dice(m - i, index + 1);
		}
	}

}
