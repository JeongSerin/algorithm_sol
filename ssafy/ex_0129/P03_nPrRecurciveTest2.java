package ssafy.ex_0129;

import java.util.Arrays;
import java.util.Scanner;

public class P03_nPrRecurciveTest2 {
	static int[] numbers;
	static boolean[] selected;
	static int N, R, cnt;

	// 1, 2, 3 으로 만들 수 있는 세자리수 순열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		numbers = new int[R];
		selected = new boolean[N + 1];

		permutation(0);
		System.out.println("총 경우의 수: " + cnt);
	}

	private static void permutation(int index) {
		if (index == R) {
			cnt++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (selected[i])
				continue;
			numbers[index] = i;
			selected[i] = true;
			permutation(index + 1);
			selected[i] = false;
		}
	}

}
