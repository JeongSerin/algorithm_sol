import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1206_View_정세린 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N, tmp, cnt = 0;
		int[] buildings;

		for (int tc = 1; tc <= 10; tc++) {
			cnt = 0;
			N = Integer.parseInt(br.readLine());
			buildings = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 2; i < N - 2; i++) {
				int m1 = Math.max(buildings[i - 1], buildings[i - 2]);
				int m2 = Math.max(buildings[i + 1], buildings[i + 2]);
				tmp = buildings[i] - Math.max(m1, m2);
				if (tmp > 0)
					cnt += tmp;
			}
			System.out.printf("#%d %d\n", tc, cnt);
		}
	}

}
