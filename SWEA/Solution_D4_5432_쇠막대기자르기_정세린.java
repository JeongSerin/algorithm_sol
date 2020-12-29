package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_D4_5432_쇠막대기자르기_정세린 {

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String str;
		StringBuilder sb = new StringBuilder();
		Stack<Character> st = new Stack<Character>();
		int ans = 0;

		for (int tc = 0; tc < T; tc++) {
			ans = 0;
			str = br.readLine();
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(')
					st.push('(');
				else {
					st.pop();
					if (str.charAt(i - 1) == '(')
						ans += st.size();
					else
						ans++;
				}
			}
			sb.append('#').append(tc + 1).append(' ').append(ans).append('\n');
		}
		System.out.println(sb.toString());
	}

}
