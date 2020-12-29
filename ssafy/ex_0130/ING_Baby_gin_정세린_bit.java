package ssafy.ex_0130;

import java.util.Random;

public class ING_Baby_gin_정세린_bit {
	static int[] numbers;
	static boolean[] selected;
	static int N = 6;
	static int[] permutation;
	static boolean flag;

	public static void main(String[] args) {
		Random r = new Random();
		numbers = new int[N];
		selected = new boolean[N];
		permutation = new int[N];

		while (!flag) {
			for (int i = 0; i < N; i++) {
				numbers[i] = r.nextInt(10);
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			
			if (checkBabgin(0, 1)) {
				System.out.println("baby-gin");
			} else
				System.out.println("not baby-gin");

		}

	}

	private static boolean checkBabgin(int index, int selected) {
		if (index == N) {
			return isOK();
		}

		for (int i = 0; i < N; i++) {
			if ((selected & 1 << i) != 0) {
				permutation[index] = numbers[i];
				if (checkBabgin(index + 1, selected | 1 << i))
					return true;
			}
		}
		return false;
	}

// 수정
	private static boolean isOK() {
		for (int i = 0; i < 0 + N / 2 - 1; i++) {
			if (permutation[i] != permutation[i + 1] - 1)
				return false;
		}
		for (int i = N / 2; i < N; i++) {
			if (permutation[i] != permutation[i + 1])
				return false;
		}
		return true;
	}
}
