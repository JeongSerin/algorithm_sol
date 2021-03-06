/*
테스트 6 〉	통과 (5.09ms, 62.3MB)
테스트 7 〉	통과 (2.91ms, 67.4MB)
테스트 8 〉	통과 (5.29ms, 63.4MB)
테스트 9 〉	통과 (21.68ms, 69.3MB)
테스트 10 〉	통과 (94.05ms, 92.5MB)
 * 2H 30M
 */
package PROGRAMMERS;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_P_L3_77486_칫솔다단계판매_정세린 {

	static class Solution {
		public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
			// (판매원이름[], 추천인이름[], 판매량이름[], 이익금)
			int[] answer = new int[enroll.length];
			HashMap<String, Integer> map = new HashMap<>(); // <이름, 인덱스값>

			int num = 0; // 사람 수
			for (String name : enroll) map.put(name, num++);
			map.put("-", -1); // 민호(center)

			for (int i = 0; i < amount.length; i++) answer[map.get(seller[i])] += amount[i] * 100;

			for (int i = 0; i < seller.length; i++) {
				int sellerIdx = map.get(seller[i]);
				int recommenderIdx = map.get(referral[sellerIdx]);
				int money = amount[i] * 100;

				while (true) {
					int profit = money / 10;
					answer[sellerIdx] -= profit;
					if (recommenderIdx < 0) break;

					answer[recommenderIdx] += profit;
					sellerIdx = recommenderIdx;
					recommenderIdx = map.get(referral[sellerIdx]);
					money = profit;
				}
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] enroll = { "john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young" };
		String[] referral = { "-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward" };
		String[] seller = { "young", "john", "tod", "emily", "mary" };
		int[] amount = { 12, 4, 2, 5, 10 };
		int[] answer = solution.solution(enroll, referral, seller, amount);
		System.out.println(Arrays.toString(answer));
	}

}
