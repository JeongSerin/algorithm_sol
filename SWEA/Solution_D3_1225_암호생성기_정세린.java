package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D3_1225_암호생성기_정세린 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc;
		StringTokenizer st;
		Queue<Integer> passwd = new LinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		StringBuilder pw = new StringBuilder();

		for (int t = 0; t < 10; t++) {
			pw = new StringBuilder();
			tc = Integer.parseInt(br.readLine());
			// 암호입력
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				passwd.offer(Integer.parseInt(st.nextToken()));
			}

			L: while (true) {
				for (int i = 1; i <= 5; i++) {
					int q = passwd.poll();
					if (q - i <= 0) {
						passwd.offer(0);
						break L;
					}
					passwd.offer(q - i);
				}
			}
			
			while (!passwd.isEmpty())
				pw.append(passwd.poll()).append(' ');

			sb.append('#').append(tc).append(' ').append(pw).append('\n');
		}
		System.out.println(sb.toString());
	}

}
