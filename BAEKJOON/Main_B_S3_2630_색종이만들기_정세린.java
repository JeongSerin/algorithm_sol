import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_S3_2630_색종이만들기_정세린 {
	static int[][] paper;
	static int blue = 0, white = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		paperDivide(0, 0, N);
		System.out.println(white + "\n" + blue);
	}
	
	private static void paperDivide(int starti, int startj, int n) {
		boolean flag = false;
		int tmp = paper[starti][startj];
		if (n == 1) {
			if (tmp == 1) blue++;
			else white++;
			return;
		}
		L: for (int i = starti; i < starti + n; i++) {
			for (int j = startj; j < startj + n; j++) {
				if (paper[i][j] != tmp) {
					flag = true;
					break L;
				}
			}
		}
		if (flag) {
			paperDivide(starti, startj, n/2);
			paperDivide(starti, startj + n/2, n/2);
			paperDivide(starti + n/2, startj, n/2);
			paperDivide(starti + n/2, startj + n/2, n/2);
		}
		if (!flag) {
			if (tmp == 1) blue++;
			else white++;
			return;
		}	
	}
	
}
