/*
쿠폰을 사용하면 물건을 살 때 할인을 받을 수 있습니다. 쿠폰이 여러 장 주어졌을 때, 쿠폰을 적절히 사용해 할인을 최대한 많이 받으려고 합니다. 한 제품에는 쿠폰을 하나만 적용할 수 있으며, 사용한 쿠폰은 사라집니다.

주문할 제품의 가격 prices, 쿠폰별 할인율 discounts가 매개변수로 주어집니다. 할인을 최대한 많이 받도록 쿠폰을 적용했을 때 얼마를 내야 하는지 return 하도록 solution 함수를 완성해주세요.

제한 사항
prices 배열의 길이는 1 이상 1,000 이하입니다.
prices 배열의 원소는 5,000 이상 150,000 이하인 자연수이며, 항상 100으로 나누어 떨어집니다.
discounts 배열의 길이는 1 이상 1,000 이하입니다.
discounts 배열의 원소는 1 이상 100 이하인 자연수입니다.

입출력 예
prices	discounts	result
[13000, 88000, 10000]	[30, 20]	82000
[32000, 18000, 42500]	[50, 20, 65]	45275
 */
package test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q1 {

	class Solution {
		public int solution(int[] prices, int[] discounts) {
			int answer = 0;
			int len = discounts.length;
			PriorityQueue<Integer> price = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});

			PriorityQueue<Integer> discount = new PriorityQueue<>(new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});

			for (int p : prices) {
				price.offer(p);
				answer += p;
			}
			for (int d : discounts) discount.offer(d);

//			while (!price.isEmpty()) {
			while ((!price.isEmpty()) && (!discount.isEmpty())) {
				answer -= price.poll() / 100 * discount.poll();
//				if (discount.isEmpty()) {
//					answer += price.poll();
//				} else {
//					answer += price.poll() / 100 * (100 - discount.poll());
//				}
			}

			return answer;
		}
	}
}
