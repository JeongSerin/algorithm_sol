package ssafy.ex_0129;

import java.util.Scanner;

public class DeltaArrayNearby {
	
	static char[][] alphabet;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		alphabet = new char[5][5];
		
		char ch = 'A';
		
		for(int i=0; i<alphabet.length; i++) {
			for(int j=0; j<alphabet.length; j++) {
				alphabet[i][j] = ch++;
			}
		}
		
		// 출력으로 확인
		for(int i=0; i<alphabet.length; i++) {
			for(int j=0; j<alphabet.length; j++) {
				System.out.print(alphabet[i][j]);				
			}
			System.out.println();
		}

		for(int i=0; i<alphabet.length; i++) {
			for(int j=0; j<alphabet.length; j++) {
				print4NoDelta(i, j);
				//print2H(i,j);
				//print2W(i,j);
				//print4(i, j);
				//print8(i, j);
				//print4x(i, j);
				//print8Circle(i, j);
			}
		}
	}
	
	
	static void print4NoDelta(int i, int j) {
		
		System.out.print(alphabet[i][j] + " has 4 way neighbors : ");
		
		//상
		int nexty = i - 1;
		int nextx = j;
		if (nexty < alphabet.length && nexty >= 0 && nextx < alphabet.length && nextx >= 0) {
			System.out.print( alphabet[nexty][nextx] + " ");;
		}
		
		//하
		nexty = i + 1;
		nextx = j;
		if (nexty < alphabet.length && nexty >= 0 && nextx < alphabet.length && nextx >= 0) {
			System.out.print( alphabet[nexty][nextx] + " ");;
		}
		
		//좌
		nexty = i;
		nextx = j - 1;
		if (nexty < alphabet.length && nexty >= 0 && nextx < alphabet.length && nextx >= 0) {
			System.out.print( alphabet[nexty][nextx] + " ");;
		}
		
		//우
		nexty = i;
		nextx = j + 1;
		if (nexty < alphabet.length && nexty >= 0 && nextx < alphabet.length && nextx >= 0) {
			System.out.print( alphabet[nexty][nextx] + " ");;
		}

		System.out.println();
	}

	static int dx2h[] = {  0, 0 };
	static int dy2h[] = { -1, 1 };
	
	static void print2H(int i, int j) {
		
		System.out.print(alphabet[i][j] + " has 2h way neighbors : ");
		
		for (int k = 0; k < 2; k++) {
			int nexty = i + dy2h[k];
			int nextx = j + dx2h[k];
			if (nexty >= alphabet.length || nexty < 0 || nextx >= alphabet.length || nextx < 0) {
				continue;
			}
			System.out.print( alphabet[nexty][nextx] + " ");
		}
		
		System.out.println();
	}
	
	static int dx2w[] = {  -1, 1 };
	static int dy2w[] = { 0, 0 };
	
	static void print2W(int i, int j) {
		
		System.out.print(alphabet[i][j] + " has 2w way neighbors : ");
		
		for (int k = 0; k < 2; k++) {
			int nexty = i + dy2w[k];
			int nextx = j + dx2w[k];
			if (nexty >= alphabet.length || nexty < 0 || nextx >= alphabet.length || nextx < 0) {
				continue;
			}
			System.out.print( alphabet[nexty][nextx] + " ");
		}
		
		System.out.println();
	}
	
	static int dx4[] = { 0, 1, 0, -1 };
	static int dy4[] = {-1, 0, 1,  0 };
	
	static void print4(int i, int j) {
		
		System.out.print(alphabet[i][j] + " has 4 way neighbors : ");
		
		for (int k = 0; k < 4; k++) {
			int nexty = i + dy4[k];
			int nextx = j + dx4[k];
			if (nexty >= alphabet.length || nexty < 0 || nextx >= alphabet.length || nextx < 0) {
				continue;
			}
			System.out.print( alphabet[nexty][nextx] + " ");
		}
		
		System.out.println();
	}
	
	static int dx8[] = { 0, 1, 0, -1,  1, 1, -1, -1 };
	static int dy8[] = {-1, 0, 1,  0, -1, 1,  1, -1 };
	
	static void print8(int i, int j) {
		
		System.out.print(alphabet[i][j] + " has 8 way neighbors : ");
		
		for (int k = 0; k < 8; k++) {
			int nexty = i + dy8[k];
			int nextx = j + dx8[k];
			if (nexty >= alphabet.length || nexty < 0 || nextx >= alphabet.length || nextx < 0) {
				continue;
			}
			System.out.print( alphabet[nexty][nextx] + " ");
		}
		
		System.out.println();
	}
	
	static int dx4x[] = {1, 1, -1, -1 };
	static int dy4x[] = {-1, 1,  1, -1 };
	
	static void print4x(int i, int j) {
		
		System.out.print(alphabet[i][j] + " has 4x way neighbors : ");
		
		for (int k = 0; k < 4; k++) {
			int nexty = i + dy4x[k];
			int nextx = j + dx4x[k];
			if (nexty >= alphabet.length || nexty < 0 || nextx >= alphabet.length || nextx < 0) {
				continue;
			}
			System.out.print( alphabet[nexty][nextx] + " ");
		}
		
		System.out.println();
	}
	
	static int dx8Circle[] = { 0,  1, 1, 1, 0, -1, -1, -1 };
	static int dy8Circle[] = {-1, -1, 0, 1, 1,  1,  0, -1 };
	
	static void print8Circle(int i, int j) {
		
		System.out.print(alphabet[i][j] + " has 8 circle way neighbors : ");
		
		for (int k = 0; k < 8; k++) {
			int nexty = i + dy8Circle[k];
			int nextx = j + dx8Circle[k];
			if (nexty >= alphabet.length || nexty < 0 || nextx >= alphabet.length || nextx < 0) {
				continue;
			}
			System.out.print( alphabet[nexty][nextx] + " ");
		}
		
		System.out.println();
	}
}
