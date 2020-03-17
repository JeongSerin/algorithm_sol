import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_4408_자기방으로돌아가기_정세린 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N;
		StringTokenizer st;
		int cnt, from, to, tmp, max = 0;
		int[] way = new int[201];
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			Arrays.fill(way, 0);

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				from = Integer.parseInt(st.nextToken());
				if (from % 2 == 0)
					from = from / 2;
				else
					from = (from + 1) / 2;
				to = Integer.parseInt(st.nextToken());
				if (to % 2 == 0)
					to = to / 2;
				else
					to = (to + 1) / 2;

				if (to < from) {
					tmp = to;
					to = from;
					from = tmp;
				}

				for (int w = from; w <= to; w++) {
					way[w]++;
				}
				max = way[0];
				for (int j = 1; j <= 200; j++) {
					if (way[j] > max)
						max = way[j];
				}
			}

			sb.append('#').append(tc).append(' ').append(max).append('\n');
		}

		System.out.println(sb);
	}

}
