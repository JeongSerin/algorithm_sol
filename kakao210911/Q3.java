/*
테스트 1 〉	통과 (0.53ms, 57.4MB)
테스트 2 〉	통과 (0.38ms, 59MB)
테스트 3 〉	통과 (0.68ms, 70.6MB)
테스트 4 〉	통과 (0.80ms, 71.9MB)
테스트 5 〉	통과 (1.65ms, 74.4MB)
테스트 6 〉	통과 (1.50ms, 67.8MB)
테스트 7 〉	통과 (5.63ms, 74.1MB)
테스트 8 〉	통과 (3.46ms, 71.1MB)
테스트 9 〉	통과 (1.45ms, 61.3MB)
테스트 10 〉	통과 (6.85ms, 71.5MB)
테스트 11 〉	통과 (5.53ms, 70.9MB)
테스트 12 〉	통과 (6.21ms, 76MB)
테스트 13 〉	통과 (0.76ms, 68.7MB)
테스트 14 〉	통과 (0.54ms, 73.9MB)
테스트 15 〉	통과 (0.38ms, 71.3MB)
테스트 16 〉	통과 (0.22ms, 58.2MB)

40m
 */
package kakao210911;

import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q3 {
	class Solution {
		// fees[] 기본 시간(분) 기본 요금(원) 단위 시간(분) 단위 요금(원)
		public int[] solution(int[] fees, String[] records) {
			HashMap<String, Integer> mapIn = new HashMap<>(); // 입차 시간
			HashMap<String, Integer> mapTime = new HashMap<>(); // 주차한 시간

			StringTokenizer st = null;
			for (int i = 0; i < records.length; i++) {
				st = new StringTokenizer(records[i]);
				StringTokenizer time = new StringTokenizer(st.nextToken(), ":");
				String num = st.nextToken();
				String op = st.nextToken();
				int timeToMin = Integer.parseInt(time.nextToken()) * 60 + Integer.parseInt(time.nextToken());

				if (op.equals("IN")) {
					mapIn.put(num, timeToMin);
					if (mapTime.get(num) == null) mapTime.put(num, 0);
				} else if (op.equals("OUT")) {
					int t = timeToMin - mapIn.get(num);
					mapIn.put(num, -1); // 출차됨 -1표시
					mapTime.put(num, mapTime.get(num) + t);
				}
			}
			int lastTime = 23 * 60 + 59;
			String[] carNum = new String[mapIn.size()];
			int idx = 0;
			for (String str : mapIn.keySet()) {
				carNum[idx++] = str;
				if (mapIn.get(str) >= 0) {
					int t = lastTime - mapIn.get(str);
					mapTime.put(str, mapTime.get(str) + t);
				}
			}

			Arrays.sort(carNum);
			int[] answer = new int[mapIn.size()];
			for (int i = 0; i < carNum.length; i++) {
				int time = mapTime.get(carNum[i]);
				answer[i] += fees[1];
				time -= fees[0];
				if (time > 0) {
					answer[i] += (int) Math.ceil(time / 1.0 / fees[2]) * fees[3];
				}
			}

			return answer;
		}
	}

	public static void main(String[] args) {

	}
}
