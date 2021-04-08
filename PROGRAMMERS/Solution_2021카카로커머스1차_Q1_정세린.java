package PROGRAMMERS;

import java.util.HashMap;

public class Solution_2021카카로커머스1차_Q1_정세린 {
	static class Solution {
		public int solution(int[] gift_cards, int[] wants) {
			int answer = 0;
			int len = gift_cards.length;
			HashMap<Integer, Integer> map = new HashMap<>();

			for (int i = 0; i < len; i++) {
				if (map.get(wants[i]) == null) map.put(wants[i], 1);
				else map.put(wants[i], map.get(wants[i]) + 1);
			}

			for (int i = 0; i < len; i++) {
				if (map.get(gift_cards[i]) != null) map.put(gift_cards[i], map.get(gift_cards[i]) - 1);
			}
			
			Integer[] cnt = map.values().toArray(new Integer[map.values().size()]);
			
			for (int val : cnt) {
				if (val > 0) answer += val;
			}
			
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] gift_cards = {4, 5, 3, 2, 1};
		int[] gift_cards = {5, 4, 5, 4, 5};
//		int[] wants = {2, 4, 4, 5, 1};
		int[] wants = {1, 2, 3, 5, 4};
		int ans = solution.solution(gift_cards, wants);
		System.out.println(ans);
	}

}
