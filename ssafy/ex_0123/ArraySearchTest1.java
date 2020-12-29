package ssafy.ex_0123;

public class ArraySearchTest1 {

	static int[][] arr2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

	// 배열 지그재그 순회
	public static void main(String[] args) {
		printzigzag1();
		printzigzag2();
	}

	private static void printzigzag1() {
		for (int i = 0; i < arr2.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < arr2[0].length; j++) {
					System.out.print(arr2[i][j] + " "); // arr[i][j] 문자열로 묵시적형변환
				}
				System.out.println();
			} else {
				for (int j = arr2[0].length - 1; j >= 0; j--) {
					System.out.print(arr2[i][j] + " ");
				}
				System.out.println();
			}

		}
	}

	private static void printzigzag2() {
		final int ROW = arr2.length;
		for (int i = 0; i < ROW; i++) {
			final int COL = arr2[0].length;
			for (int j = 0; j < COL; j++) {
				System.out.print(arr2[i][j + ((COL - 1) - 2 * j) * (i % 2)] + " ");
			}
			System.out.println();
		}
	}

}