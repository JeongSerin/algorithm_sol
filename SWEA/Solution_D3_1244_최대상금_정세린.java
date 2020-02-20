/*
 * 87,616 kb
 * 613 ms
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_1244_최대상금_정세린 {
	static int max;
	static char[] card;
	static int change;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			max = 0;
			st = new StringTokenizer(br.readLine());
			card = st.nextToken().toCharArray();
			change = Integer.parseInt(st.nextToken());
			
			permutation(0, 0);
			permutation(1, 0);
				
			sb.append("#" + tc + " " + max + "\n");
		}
		System.out.println(sb);
	}
	
	private static void permutation(int index, int num) {
		if (num == change) {
			max = Math.max(max, Integer.parseInt(String.valueOf(card)));
			return;
		}
		if (index >= card.length) {
			if ((change - num) % 2 == 1) index = 0;
			else return;
		}
		
		for (int i = 0; i < card.length; i++) {
			if (i == index) continue;
			char tmp = card[index];
			card[index] = card[i];
			card[i] = tmp;
			permutation(index + 1, num + 1);
			tmp = card[index];
			card[index] = card[i];
			card[i] = tmp;
		}
	}
	
}