package PROGRAMMERS;

import java.util.Arrays;

public class Solution_2021카카오커머스1차_Q2_정세린2 {
	
	static class Solution {
		
		public int solution(int[][] needs, int r) {
			int answer = 0;
			boolean[] parts = new boolean[needs[0].length];
			boolean[] none = new boolean[needs.length];
			int max = 0;
			
			for (int i = 0; i < needs.length; i++) {
				if (none[i]) continue; // 확인할 필요가 없는 패턴
				Arrays.fill(parts, false);
				int partsCnt = 0; // 해당 완제품에서 필요한 부품 수
				for (int j = 0; j < needs[0].length; j++) {
					if (needs[i][j] == 1) {
						parts[j] = true;
						partsCnt++;
					}
				}
				if (partsCnt > r) { // 만들려면 r보다 많은 부품이 필요할 때
					none[i] = true; // 확인할 필요가 없는 패턴
					continue; // 만들 수 없음
				}
				
				int cnt = 0;
				L:for (int p = 0; p < needs.length; p++) { 
					for (int j = 0; j < needs[0].length; j++) {
						if (needs[p][j] == 1 && !parts[j]) continue L; // 만들 수 없음
					}
					cnt++; // 해당 패턴으로 만들수 있는 제품
					
					none[p] = true; // 이미 확인한 패턴 (같거나 누군가에 포함되는 패턴이므로 확인할 필요가 없음)
				}
				max = Integer.max(max, cnt);
			}
			
			answer = max;
			return answer;
		}
		
	} // end of solution
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] needs = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
//		int[][] needs = {{1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 0, 1}, {1, 0, 1}, {1, 0, 0}};
		int r = 2;
		int ans = solution.solution(needs, r);
		System.out.println(ans);
	}

}
