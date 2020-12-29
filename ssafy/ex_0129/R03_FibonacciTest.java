package ssafy.ex_0129;

import java.util.Scanner;

public class R03_FibonacciTest {
	// 가지치기 그려보기 -> 중복 호출 확인
	// 메모이제이션: 중복되는 호출을 계속 수행할 경우 계산했던 값을 저장해둠.
	static int[] fibo;

	// 정수 N을 입력 받아 피보나치 수열의 N항 출력
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		fibo = new int[N + 1];

		System.out.println(N + "번째 항은 " + fibonacciDown(N));
		fibonacciUp(1, N, 0, 1);
	}

	// 하향식, 중복호출  하향식은 중복호출이 될 가능성이 높음
	private static int fibonacciDown(int n) {
		if (n <= 2)
			return 1;
		return fibonacciDown(n - 1) + fibonacciDown(n - 2);
	}

	// 상향식, 중복호출 x
	private static void fibonacciUp(int count, int n, int before, int current) {
		System.out.print(current + " ");
		if (count == n) {
			System.out.println();
			return;
		}
		fibonacciUp(count + 1, n, current, before + current);
	}

	// 메모이제이션
	private static int fibonacci(int n) {
		// 메모이제이션
		if (fibo[n] != 0)
			return fibo[n];
		if (n <= 2) {
			fibo[n] = 1;
			return fibo[n];
		}
		fibo[n] = fibonacci(n - 1) + fibonacci(n - 2);
		return fibo[n];
	}
}
