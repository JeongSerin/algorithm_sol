import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_1208_Flatten_정세린 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] box = new int[100];
		int dump;
		for (int tc = 1; tc <= 10; tc++) {
			dump = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}
			while (dump > 0) {
				Arrays.sort(box);
				box[0]++;
				box[99]--;
				dump--;
			}
			Arrays.sort(box);
			System.out.printf("#%d %d\n", tc, box[99] - box[0]);
		}
	}

}
