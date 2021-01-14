package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ING_Main_B_G3_11049_행렬곱셈순서_정세린 {
	
	public static class Matrix{
		int r;
		int c;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());	// 행렬의 크기
		Matrix[] M = new Matrix[N];		// 입력된 행렬의 크기
		
		StringTokenizer st = null;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			M[n].r = Integer.parseInt(st.nextToken());
			M[n].c = Integer.parseInt(st.nextToken());
		}	// end of input
		
		
		
		
	}
	
}
