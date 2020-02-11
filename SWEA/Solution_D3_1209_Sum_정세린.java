import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1209_Sum_정세린 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] table = new int[100][100];
		int t, max, sum, sumx1, sumx2;
		StringTokenizer st;
		
		for (int tc = 0; tc <10; tc++) {
			t = Integer.parseInt(br.readLine());
			max = 0;
			sumx1 = 0;
			sumx2 = 0;
			for (int i = 0; i < 100; i++) {
				st= new StringTokenizer(br.readLine(), " ");
				sum = 0;
				for (int j = 0; j < 100; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
					// 행 합
					sum += table[i][j];
				}
				if (sum > max) max = sum;
			}	
			for (int j = 0; j < 100; j++) {
				sum = 0;
				for (int i = 0; i < 100; i++) {
					// 열 합
					sum += table[i][j];
					// 대각선 합
					if (i == j) sumx1 += table[i][j];
					if (i == 99-j) sumx2 += table[i][j];
				}
				if (sum > max) max = sum;
			}
			System.out.printf("#%d %d\n", t, Math.max(max, Math.max(sumx1, sumx2)));
		}
	}
	
}
