package ssafy.ex_0129;

import java.util.Scanner;

public class R04_CombinationCountTest {
	static int cnt;

// N개의 원소중 R개의 원소를 고르는 방법의 가지수 nCr구하기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int R = sc.nextInt();
		combination(N, R);

		System.out.println(combination(N, R));
	}

	private static int combination(int n, int r) {
		if (n == r || r == 0)
			return 1;
		return combination(n - 1, r - 1) + combination(n - 1, r); // 현재원소 선택 할경우 + 안할경우
	}

}
