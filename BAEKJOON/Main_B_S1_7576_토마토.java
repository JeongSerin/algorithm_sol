import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_S1_7576_토마토 {
	static class Point {
		int i;
		int j;

		Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	static int[][] dh = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] box;
	static int M, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		Queue<Point> queue = new LinkedList<Point>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1)
					queue.offer(new Point(i, j));
			}
		}
		Point current;
		int time = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				current = queue.poll();
				for (int dir = 0; dir < 4; dir++) {
					int itmp = current.i + dh[dir][0];
					int jtmp = current.j + dh[dir][1];
					if (itmp >= 0 && itmp < N && jtmp >= 0 && jtmp < M && box[itmp][jtmp] == 0) {
						box[itmp][jtmp] = 1;
						queue.offer(new Point(itmp, jtmp));
					}
				}
			}
			time++;
		}
		
		L: for (int[] b : box)
			for (int bb : b)
				if (bb == 0) {
					time = 0;
					break L;
				}
		
		System.out.println(time-1);
	}
}
