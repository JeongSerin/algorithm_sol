package PROGRAMMERS;

import java.util.Arrays;

public class Solution_2021카카오커머스1차_Q2_정세린 {
	
	static class Solution {
		int[] selected;
		int[][] Needs;
		int max = 0;
		
		public int solution(int[][] needs, int r) {
			int answer = 0;
			int parts = needs[0].length;
			selected = new int[r];
			Needs = new int[needs.length][parts];
			for (int i = 0; i < needs.length; i++) 
				Needs[i] = Arrays.copyOf(needs[i], parts);
			
			combination(0, parts, r);
			answer = max;
			return answer;
		}
		
		void combination(int idx, int n, int r) {
			if (r == 0) {
//				System.out.println(Arrays.toString(selected));
				makeProduct();
				return;
			}
			
			for (int i = idx; i < n; i++) {
				selected[r - 1] = i;
				combination(i + 1, n, r - 1);
			}
			
		} // end of combination
		
		void makeProduct() {
			int[][] needsCopy = new int[Needs.length][Needs[0].length];
			for (int i = 0; i < Needs.length; i++) 
				needsCopy[i] = Arrays.copyOf(Needs[i], Needs[0].length);
			
			for(int part: selected) {
				for (int i = 0; i < needsCopy.length; i++) {
					needsCopy[i][part] = 0;
				}
			}
			
			int cnt = 0;
			L:for (int i = 0; i < needsCopy.length; i++) {
				for (int j = 0; j < needsCopy[0].length; j++) {
					if (needsCopy[i][j] != 0) continue L;
				}
				cnt++;
			}
			
			max = Integer.max(max, cnt);
		} // end of makeProducts
		
	} // end of solution
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] needs = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
		int r = 2;
		int ans = solution.solution(needs, r);
		System.out.println(ans);
	}

}
