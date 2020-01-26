package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_J_Im_1328_빌딩_정세린 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] H = new int[N];
		int look;
		for (int i = 0; i < N; i++) {
			H[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < N; i++) {
			look = 0;
			for (int j = i + 1; j < N; j++) {
				if (H[i] < H[j]) {
					look = j + 1;
					break;
				}
			}
			System.out.println(look);
		}
	}
}
