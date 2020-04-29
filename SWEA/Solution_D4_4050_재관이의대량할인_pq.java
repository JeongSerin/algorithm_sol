package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_4050_재관이의대량할인_pq {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N;
		int[] items;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
			
		});

		
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			int max = 0;
			N = Integer.parseInt(br.readLine());
			items = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			while (q.size() >= 3) {
				max += q.poll();
				max += q.poll();
				q.poll();
				
			}
			
			while (!q.isEmpty()) {
				max += q.poll(); 
			}
			
			
			sb.append("#" + tc + " " + max + "\n");
		}
		System.out.println(sb.toString());
	}
	
}
