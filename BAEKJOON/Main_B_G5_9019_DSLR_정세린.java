package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_G5_9019_DSLR_정세린 {
	static String minOp;
	static int min;
	static String A, B;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			A = st.nextToken();
			B = st.nextToken();
			// 초기화
			minOp = "";
//			min = Integer.MAX_VALUE;
			min = 0;
//			dfs(A, "");
			
			// bfs로 풀기
			
			
			System.out.println(minOp);
		} // end of test case
	}
	
	static void dfs(String strA, String op) {
		if (min != 0) {
			return; // 최소 연산수보다 더 크면 더이상 할 필요가 없음
		}
		if (Integer.parseInt(strA) == Integer.parseInt(B)) { // B와 같아지면
			minOp = op; // 최소 연산 길이
			min = op.length(); // 최소 연산 수
			return;
		} // 종료조건
		
		// 1. D: *2
		int resD = (Integer.parseInt(strA) * 2) % 10000;
		dfs(Integer.toString(resD), op + "D");
		
		// 2. S: -1
		int resS = Integer.parseInt(strA) - 1;
		if (resS <= 0) resS = 9999;
		dfs(Integer.toString(resS), op + "S");

		// 3. L: 2341
		dfs(strA.substring(1) + strA.subSequence(0, 1), op + "L");
		
		// 4. R: 4123
		dfs(strA.substring(strA.length() - 1) + strA.subSequence(0, strA.length() - 1), op + "R");
	}
	
}
