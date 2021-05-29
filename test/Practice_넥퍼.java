package test;

import java.util.Arrays;

public class Practice_넥퍼 {
	static int arr[] = { 1, 2, 3, 4, 5 }, cnt = 0, pick[] = { 0, 0, 1, 1, 1 };

	public static void main(String[] args) {
		// 조합
		do {
			for (int i = 0; i < 5; i++) {
				if (pick[i] == 1) {
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println();
		} while (nextPermutation(pick));
		System.out.println("조합의 수 : " + cnt);

		// 순열
		cnt = 0;
		do {
			System.out.println(Arrays.toString(arr));
		} while (nextPermutation(arr));
		System.out.println("순열의 수 : " + cnt);
	}

	public static boolean nextPermutation(int p[]) {
		cnt++;
		int n = p.length;
		int i = n - 1;
		while (i > 0 && p[i - 1] >= p[i]) {
			--i;
		}
		if (i == 0) {
			return false;
		}

		int j = n - 1;
		while (p[i - 1] >= p[j]) {
			--j;
		}
		int tmp = p[i - 1];
		p[i - 1] = p[j];
		p[j] = tmp;

		int k = n - 1;
		while (k > i) {
			tmp = p[k];
			p[k] = p[i];
			p[i] = tmp;
			k--;
			i++;
		}

		return true;

	}

	// 스왑을 넥퍼부분에서 작성하는것이 순열, 조합 범용성을 높임

	public static void swap(int a, int b) {
		int tmp = pick[a];
		pick[a] = pick[b];
		pick[b] = tmp;
	}

}