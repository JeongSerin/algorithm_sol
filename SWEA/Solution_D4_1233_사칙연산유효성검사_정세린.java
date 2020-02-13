import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_D4_1233_사칙연산유효성검사_정세린 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int res, N;
		char data;
		String str;
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			res = 1;

			if (N % 2 == 0) res = 0;
			for (int i = 1; i <= N; i++) {

				str = br.readLine();
				data = str.substring(str.indexOf(' ')+1).charAt(0);
				if (N % 2 != 0 && i <= N / 2)  // 리프가 아닐때 숫자이면 연산불가
					if (Character.isDigit(data)) res = 0;
				
				if (N % 2 != 0 && i > N)  // 리프일때 연산자이면 연산 불가
					if (!Character.isDigit(data)) res = 0;
			}
			sb.append("#"+tc+" "+res+"\n");
		}
		System.out.println(sb);
	}
	
}