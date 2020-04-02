/*
 * 30,708 kb 
 * 135 ms
 */

package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_6719_성수의프로그래밍강좌시청_정세린 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		int N;			// 전체 강좌 수
		int K;			// 들을 강좌 수
		float A = 0;	// 성수의 실력
		
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		for (int tc = 1; tc <= T; tc++) {
			// 입력
			A = 0;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				q.offer(Integer.parseInt(st.nextToken())); 
			}
			// 안듣는 강좌 빼기(레벨이 가장 낮은 강좌 N-K개)
			for (int i = 0; i < (N-K); i++) {
				q.poll();
			}
			// 레벨이 높은 K개의 강좌 낮은것 부터 듣기
			while(!q.isEmpty()) {
				A = (A + q.poll()) / 2;
			}
			sb.append("#" + tc + " " + A + "\n");
		}
		System.out.println(sb);
	}

}
