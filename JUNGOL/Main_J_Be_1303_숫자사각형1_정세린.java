package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_J_Be_1303_숫자사각형1_정세린 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(i * m + j + 1 + " ");
			}
			System.out.println();
		}
	}
}
