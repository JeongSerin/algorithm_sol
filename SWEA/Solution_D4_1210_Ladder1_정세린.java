package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1210_Ladder1_정세린 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int testNum;
		int pos = 0;
		int[][] ladder = new int[100][100]; // int[100][102] 로 좌우끝 예외처리
		int X;
		int y = 99;

		for (int test = 0; test < 10; test++) {
			y = 99;
			testNum = Integer.parseInt(br.readLine());

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					if (i == 99 && ladder[i][j] == 2)   // if (ladder[i][j] == 2)
						pos = j;
				}
			}

			while (y != 0) {
				if (pos > 0 && ladder[y][pos - 1] == 1) {
					while (pos > 0 && ladder[y][pos - 1] == 1) {
						pos--;
					}
					y--;
				} else if (pos < 99 && ladder[y][pos + 1] == 1) {
					while (pos < 99 && ladder[y][pos + 1] == 1) {
						pos++;
					}
					y--;
				} else {
					y--;
				}
			}
			X = pos;
			System.out.printf("#%d %d\n", testNum, X);
		}
	}

}
