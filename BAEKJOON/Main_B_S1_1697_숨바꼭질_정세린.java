/*
 * 16688KB
 * 128ms
 * 20m
 * dp
 */
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_S1_1697_숨바꼭질_정세린 {
	static final int INF = 100000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
		int K = Integer.parseInt(st.nextToken()); // 동생의 위치
		int[] time = new int[INF + 1];
		Arrays.fill(time, Integer.MAX_VALUE);
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(N);
		time[N] = 0;
		
		while (!q.isEmpty()) {
			int cur = q.poll(); // 수빈이의 현재 위치
			
			// 앞으로 한칸
			int go = cur + 1;
			if (go <= INF) {
				if (time[cur] + 1 < time[go]) {
					time[go] = time[cur] + 1;
					q.offer(go);
				}
			}
			
			// 뒤로 한칸
			int back = cur - 1;
			if (back >= 0) {
				if (time[cur] + 1 < time[back]) {
					time[back] = time[cur] + 1;
					q.offer(back);
				}
			}
			
			// 순간이동
			int warp = cur * 2;
			if (warp <= INF) {
				if (time[cur] + 1 < time[warp]) {
					time[warp] = time[cur] + 1;
					q.offer(warp);
				}
			}
		} // end of while
		
		System.out.println(time[K]);
	}// end of main

}
