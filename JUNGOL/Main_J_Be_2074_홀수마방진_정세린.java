import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_J_Be_2074_홀수마방진_정세린 {
	static int i, j, N, num = 1;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		j = N / 2;

		map[i][j] = num++;

		for (int k = num; k <= N * N; k++) {
			position();
			map[i][j] = num++;
		}

		for (int[] mapi : map) {
			for (int mapij : mapi) {
				System.out.print(mapij + " ");
			}
			System.out.println();
		}
	}

	public static void position() {
		if ((num - 1) % N == 0) {
			i += 1;
			if (i >= N)
				i = N - 1;
		} else {
			i -= 1;
			j -= 1;
			if (i < 0)
				i = N - 1;
			if (j < 0)
				j = N - 1;
		}
	}
}
