import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1493_수의새로운연산_정세린 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int i = 1, j = 1, jpos = 1;
		int num = 1, num1, num2, res;
		int[] pos1, pos2, pos;
		pos1 = new int[2];
		pos2 = new int[2];
		pos = new int[2];
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			num1 = Integer.parseInt(st.nextToken());
			num2 = Integer.parseInt(st.nextToken());
			num = 1;
			i = 1;
			j = 1;
			jpos = 1;
			Arrays.fill(pos, 0);

			if (num2 < num1) {
				int tmp = num1;
				num1 = num2;
				num2 = tmp;
			}

			while (true) {

				if (num == num1) {
					pos1[0] = i;
					pos1[1] = j;
				}
				if (num == num2) {
					pos2[0] = i;
					pos2[1] = j;

					pos[0] = pos1[0] + pos2[0];
					pos[1] = pos1[1] + pos2[1];
				}
				if (i == pos[0] && j == pos[1]) {
					res = num;
					break;
				}
				num++;

				if (j - 1 > 0) {
					i = i + 1;
					j = j - 1;
				} else {
					jpos++;
					j = jpos;
					i = 1;
				}
			}
			sb.append('#').append(tc).append(' ').append(res).append('\n');
		}
		System.out.print(sb);
	}
}
