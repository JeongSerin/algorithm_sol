/*
 * 42868 KB
 * 436 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_S2_1931_회의실배정_정세린 {

	static class Point implements Comparable<Point> {
		int start;
		int end;

		Point(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Point o) {
			int tmp = this.end - o.end;
			if (tmp == 0)
				return this.start - o.start;
			return tmp;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		Queue<Point> timetable = new PriorityQueue<Point>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			timetable.offer(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Point current = timetable.poll();
		int cnt = 1;
		while (!timetable.isEmpty()) {
			if (current.end <= timetable.peek().start) {
				cnt++;
				current = timetable.peek();
			} 
			timetable.poll();
		}
		System.out.println(cnt);
	}
	
}
