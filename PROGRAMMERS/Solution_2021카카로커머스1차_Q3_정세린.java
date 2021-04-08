package PROGRAMMERS;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_2021카카로커머스1차_Q3_정세린 {

	static class Solution {
		ArrayList<ArrayList<Integer>> abj = new ArrayList<>();
		boolean[] visited;
		int[] pass;
		int max = 0;
		int maxDest = 0;
		
		public int[] solution(int n, int[] passenger, int[][] train) {
			int[] answer = new int[2];
			visited = new boolean[n + 1];
			pass = new int[n];
	
			for (int i = 0; i <= n; i++) abj.add(new ArrayList<Integer>());
			
			for (int i = 0; i < train.length; i++) {
				abj.get(train[i][0]).add(train[i][1]);
				abj.get(train[i][1]).add(train[i][0]);
			}
			
			for (int to = 1; to <= n; to++) { // 도착지는 i
				pass = Arrays.copyOf(passenger, n);
				visited[1] = true;
				dfs(1, 0, to);
				Arrays.fill(visited, false);
				visited[maxDest] = true;
				dfs(maxDest, max, 1);
				Arrays.fill(visited, false);
			}
			answer[0] = maxDest;
			answer[1] = max;
			return answer;
		}
		
		void dfs(int from, int sum, int to) {
			if (from == to) {
				if (sum >= max) {
					max = sum;
					maxDest = to;
				}
			}
			for (int i: abj.get(from)) {
				if (visited[i]) continue;
				
				visited[i] = true;
				int tmp = pass[i - 1];
				pass[i - 1] = 0;
				dfs(i, sum + tmp, to);
				pass[i - 1] = tmp;
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int n = 6;
		int[] passenger = {1, 1, 1, 1, 1, 1};
		int[][] train = {{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}};
		int[] ans = solution.solution(n, passenger, train);
		System.out.println(Arrays.toString(ans));
	}

}
