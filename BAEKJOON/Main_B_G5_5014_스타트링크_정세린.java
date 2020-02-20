import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_G5_5014_스타트링크_정세린 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int height, start, destination, up, down, cnt = 0, pos = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		height = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		destination = Integer.parseInt(st.nextToken());
		up = Integer.parseInt(st.nextToken());
		down = Integer.parseInt(st.nextToken());
		int[] dh = { up, (-1 * down) };

		if ((start > destination && down == 0) || (start < destination && up == 0)) {
			System.out.println("use the stairs");
			return;
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[height + 1];
		q.offer(start);
		int current;
		visited[start] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				current = q.poll();
				for (int i = 0; i < 2; i++) {
					pos = current + dh[i];
					if (pos > 0 && pos <=height && !visited[pos]) {
						visited[pos] = true;
						q.offer(pos);
					}
				}
			}
			cnt++;
			if (pos != destination) {
				System.out.println("use the stairs");
				return;
			}
		}
		
		System.out.println(cnt - 1);

	}
}
