package ssafy.ex_0130;

import java.util.Scanner;

public class S02_RecursiveTest {
	static int N;
	static boolean[] selected;
	static int[] numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		numbers = new int[N];
		selected = new boolean[N];
		
		for (int i = 0; i< N; i++) {
			numbers[i] = sc.nextInt();
		}
		subset(0);
	}

	private static void subset(int index) {
		if (index == N) {
			for (int s = 0; s < selected.length; s++) {
				System.out.print((selected[s] ? numbers[s] +" ": "") + "");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i>= 0; i--) {
			selected[index] = (i == 1);
			subset(index+1);
		}
	}

}
