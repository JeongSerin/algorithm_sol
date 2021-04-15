/*
테스트 10 〉	통과 (0.14ms, 53.6MB)
테스트 11 〉	통과 (0.12ms, 52.7MB)
테스트 12 〉	통과 (0.10ms, 52.7MB)
테스트 13 〉	통과 (0.14ms, 53.9MB)
테스트 14 〉	통과 (0.02ms, 53.3MB)
효율성 테스트
테스트 1 〉	통과 (0.11ms, 52.9MB)
테스트 2 〉	통과 (0.14ms, 53.8MB)
테스트 3 〉	통과 (0.17ms, 53.7MB)
테스트 4 〉	통과 (0.17ms, 53.6MB)
테스트 5 〉	통과 (0.27ms, 53.3MB)
테스트 6 〉	통과 (0.02ms, 52.1MB)
15m
 * 
 */
package PROGRAMMERS;

import java.util.Arrays;

public class Solution_P_L3_12938_최고의집합_정세린 {

	static class Solution {
		public int[] solution(int n, int s) {
			int[] answer = { -1 };
			int div = s / n;
			if (div < 1) return answer;

			answer = new int[n];
			int remain = s % n;
			Arrays.fill(answer, 0, n - remain, div);
			Arrays.fill(answer, n - remain, n, div + 1);

			return answer;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 2;
		int s = 9;
		int ans[] = solution.solution(n, s);
		System.out.println(Arrays.toString(ans));
	}

}
