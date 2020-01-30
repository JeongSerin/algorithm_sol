import java.util.Random;

public class Baby_gin_정세린 {
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

//		while (!flag) {
		for (int i = 0; i < N; i++) {
			numbers[i] = r.nextInt(10);
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		checkBabgin(0);
		if (flag) {
			System.out.println("baby-gin");
		} else
			System.out.println("not baby-gin");

//		}

	}

	private static void checkBabgin(int index) {
		if (index == N) {
//			System.out.println(Arrays.toString(permutation));
			if ((checkRun(0) && checkTriplet(N / 2)) || checkRun(N / 2) && checkTriplet(0)) {
//				System.out.println(Arrays.toString(permutation));
				flag = true;
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			if (selected[i])
				continue;
			permutation[index] = numbers[i];
			selected[i] = true;
			checkBabgin(index + 1);
			selected[i] = false;
		}

	}

	private static boolean checkRun(int idx) {
		for (int i = idx; i < idx + N / 2 - 1; i++) {
			if (permutation[i] != permutation[i + 1] - 1)
				return false;
		}
		return true;
	}

	private static boolean checkTriplet(int idx) {
		for (int i = idx; i < idx + N / 2 - 1; i++) {
			if (permutation[i] != permutation[i + 1])
				return false;
		}
		return true;
	}
}
