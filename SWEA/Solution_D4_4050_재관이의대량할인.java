/*
 * 107,612kb
 * 634ms
 */
package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_4050_재관이의대량할인 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N;
		int[] items;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			int max = 0;
			N = Integer.parseInt(br.readLine());
			items = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < N; i++) {
				items[i] = Integer.parseInt(st.nextToken());
				max += items[i];
			}
			Arrays.sort(items);
			
			for (int i = N-3; i >= 0;  i -= 3) {
				max -= items[i];
			}
			
			sb.append("#" + tc + " " + max + "\n");
		}
		System.out.println(sb.toString());
	}
	
}
