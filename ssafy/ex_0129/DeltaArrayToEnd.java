package ssafy.ex_0129;

import java.util.Scanner;

public class DeltaArrayToEnd {
	
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

				print2HToEnd(i,j);
				//print2WToEnd(i,j);
				//print4ToEnd(i, j);
				//print8ToEnd(i, j);
				//print4xToEnd(i, j);
				//print8CircleToEnd(i, j);
			}
		}
	}
	

	static int dx2h[] = {  0, 0 };
	static int dy2h[] = { -1, 1 };
	
	static void print2HToEnd(int i, int j) {
		
		System.out.print(alphabet[i][j] + " has 2h way neighbors to end : ");
		
		for (int k = 0; k < 2; k++) {
			
			int nexty = i;
			int nextx = j;
			
			while (true) {
				nexty = nexty + dy2h[k];
				nextx = nextx + dx2h[k];
				
				if (nexty >= alphabet.length || nexty < 0 || nextx >= alphabet.length || nextx < 0) {
					break;
				}
				System.out.print( alphabet[nexty][nextx] + " ");
			}
			System.out.print("-");
		}
		
		System.out.println();
	}
	
	static int dx2w[] = { -1, 1 };
	static int dy2w[] = {  0, 0 };
	
	static void print2WToEnd(int i, int j) {
		
		System.out.print(alphabet[i][j] + " has 2w way neighbors to end  : ");
		
		for (int k = 0; k < 2; k++) {
			
			int nexty = i;
			int nextx = j;
			
			while (true) {
				nexty = nexty + dy2w[k];
				nextx = nextx + dx2w[k];
				
				if (nexty >= alphabet.length || nexty < 0 || nextx >= alphabet.length || nextx < 0) {
					break;
				}
				System.out.print( alphabet[nexty][nextx] + " ");
			}
			System.out.print("-");
		}
		
		System.out.println();
	}
	
	static int dx4[] = { 0, 1, 0, -1 };
	static int dy4[] = {-1, 0, 1,  0 };
	
	static void print4ToEnd(int i, int j) {
		
		System.out.print(alphabet[i][j] + " has 4 way neighbors to end  : ");
		
		for (int k = 0; k < 4; k++) {
			
			int nexty = i;
			int nextx = j;
			
			while (true) {
				nexty = nexty + dy4[k];
				nextx = nextx + dx4[k];
				
				if (nexty >= alphabet.length || nexty < 0 || nextx >= alphabet.length || nextx < 0) {
					break;
				}
				System.out.print( alphabet[nexty][nextx] + " ");
			}
			System.out.print("-");
		}
		
		System.out.println();
	}
	
	static int dx8[] = { 0, 1, 0, -1,  1, 1, -1, -1 };
	static int dy8[] = {-1, 0, 1,  0, -1, 1,  1, -1 };
	
	static void print8ToEnd(int i, int j) {
		
		System.out.print(alphabet[i][j] + " has 8 way neighbors to end  : ");
		
		for (int k = 0; k < 8; k++) {
			
			int nexty = i;
			int nextx = j;
			
			while (true) {
				nexty = nexty + dy8[k];
				nextx = nextx + dx8[k];
				
				if (nexty >= alphabet.length || nexty < 0 || nextx >= alphabet.length || nextx < 0) {
					break;
				}
				System.out.print( alphabet[nexty][nextx] + " ");
			}
			System.out.print("-");
		}
		
		System.out.println();
	}
	
	static int dx4x[] = {1, 1, -1, -1 };
	static int dy4x[] = {-1, 1,  1, -1 };
	
	static void print4xToEnd(int i, int j) {
		
		System.out.print(alphabet[i][j] + " has 4x way neighbors to end  : ");
		
		for (int k = 0; k < 4; k++) {
			
			int nexty = i;
			int nextx = j;
			
			while (true) {
				nexty = nexty + dy4x[k];
				nextx = nextx + dx4x[k];
				
				if (nexty >= alphabet.length || nexty < 0 || nextx >= alphabet.length || nextx < 0) {
					break;
				}
				System.out.print( alphabet[nexty][nextx] + " ");
			}
			System.out.print("-");
		}
		
		System.out.println();
	}
	
	static int dx8Circle[] = { 0,  1, 1, 1, 0, -1, -1, -1 };
	static int dy8Circle[] = {-1, -1, 0, 1, 1,  1,  0, -1 };
	
	static void print8CircleToEnd(int i, int j) {
		
		System.out.print(alphabet[i][j] + " has 8 circle way neighbors to end  : ");
		
		for (int k = 0; k < 8; k++) {
			int nexty = i;
			int nextx = j;
			
			while (true) {
				nexty = nexty + dy8Circle[k];
				nextx = nextx + dx8Circle[k];
				
				if (nexty >= alphabet.length || nexty < 0 || nextx >= alphabet.length || nextx < 0) {
					break;
				}
				System.out.print( alphabet[nexty][nextx] + " ");
			}
			System.out.print("-");
		}
		
		System.out.println();
	}
}
