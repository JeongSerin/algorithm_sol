import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_J_Be_1161_하노이1_정세린 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 원판 개수

		hanoi(N, 0, 1, 2);
	}

	private static void hanoi(int n, int i, int t, int j) {
		if (n == 1) {
			System.out.printf("%d : %d -> %d\n", n, i + 1, j + 1);
		} else {
			hanoi(n - 1, i, j, t);
			System.out.printf("%d : %d -> %d\n", n, i + 1, j + 1);
			hanoi(n - 1, t, i, j);
		}

	}
}
