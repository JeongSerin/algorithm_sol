import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_J_Im_1828_냉장고_정세린 {
	static int N, cnt = 1;
	static int min = 100;

	static class Point implements Comparable<Point> {
		int x;
		int y;

		Point() {
		}

		@Override
		public int compareTo(Point p1) {
			Integer x1 = p1.x;
			Integer x2 = this.x;
			return x2.compareTo(x1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int start, end;
		Queue<Point> queue = new PriorityQueue<Point>();

		Point p;
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			p = new Point();
			st = new StringTokenizer(br.readLine(), " ");
			p.x = Integer.parseInt(st.nextToken());
			p.y = Integer.parseInt(st.nextToken());
			queue.offer(p);
		}

		start = queue.peek().x;
		end = queue.poll().y;
		while (!queue.isEmpty()) {
			if (queue.peek().x >= start && queue.peek().x <= end) {
				end = Math.min(end, queue.poll().y);
			} else {
				cnt++;
				start = queue.peek().x;
				end = queue.poll().y;
			}
		}
		System.out.println(cnt);
	}

}
