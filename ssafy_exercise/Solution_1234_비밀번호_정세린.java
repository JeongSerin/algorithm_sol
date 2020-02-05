import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1234_비밀번호_정세린 {
	static String str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t;
		String str1, str2;
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			t = Integer.parseInt(st.nextToken());
			str = st.nextToken();
			L: while (true) {
				for (int i = 1; i < str.length(); i++) {
					if (str.charAt(i - 1) == str.charAt(i)) {
						str1 = str.substring(0, i - 1);
						str2 = str.substring(i + 1, str.length());
						str = str1.concat(str2);
						continue L;
					}
				}
				break;

			}
			sb.append('#').append(tc).append(' ').append(str.toString()).append('\n');
		}
		System.out.println(sb.toString());
	}
}
