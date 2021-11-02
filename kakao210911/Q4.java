/*
테스트 1 〉	통과 (0.07ms, 71MB)
테스트 2 〉	통과 (0.82ms, 61.4MB)
테스트 3 〉	통과 (1.09ms, 72.8MB)
테스트 4 〉	통과 (0.48ms, 67.4MB)
테스트 5 〉	통과 (0.81ms, 72.8MB)
테스트 6 〉	통과 (0.85ms, 71.4MB)
테스트 7 〉	통과 (0.57ms, 60.5MB)
테스트 8 〉	통과 (0.19ms, 59MB)
테스트 9 〉	통과 (0.54ms, 70.9MB)
테스트 10 〉	통과 (0.30ms, 60.9MB)
테스트 11 〉	통과 (0.30ms, 70MB)
테스트 12 〉	통과 (0.32ms, 58.7MB)
테스트 13 〉	통과 (0.77ms, 61.6MB)
테스트 14 〉	통과 (0.86ms, 75.1MB)
테스트 15 〉	통과 (1.02ms, 60.5MB)
테스트 16 〉	통과 (0.65ms, 69.4MB)
테스트 17 〉	통과 (0.55ms, 69.3MB)
테스트 18 〉	통과 (0.07ms, 69.6MB)
테스트 19 〉	통과 (0.03ms, 69.4MB)
테스트 20 〉	통과 (0.73ms, 59MB)
테스트 21 〉	통과 (0.77ms, 73.4MB)
테스트 22 〉	통과 (0.85ms, 59.3MB)
테스트 23 〉	통과 (0.18ms, 61MB)
테스트 24 〉	통과 (0.97ms, 69.1MB)
테스트 25 〉	통과 (1.03ms, 59.2MB)

n	info	result
5	[2,1,1,1,0,0,0,0,0,0,0]	[0,2,2,0,1,0,0,0,0,0,0]
1	[1,0,0,0,0,0,0,0,0,0,0]	[-1]
9	[0,0,1,2,0,1,1,1,1,1,1]	[1,1,2,0,1,2,2,0,0,0,0]
10	[0,0,0,0,0,0,0,0,3,4,3]	[1,1,1,1,1,1,1,1,0,0,2]

 * 1H 30m
 */
package kakao210911;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Q4 {
	class Solution {
		int[] comb = new int[11];
		int[] combMax = new int[11];
		int[] combArr;
		int[] info;
		int n;
		int max = 0;

		// info[] 10~ 0점 어피치가 맞춘 횟수
		public int[] solution(int n, int[] info) {
			int[] answer = { -1 };
			this.info = Arrays.copyOf(info, info.length);
			this.n = n;
			// 10 ~ 0까지 n개 조합
			for (int i = n; i >= 1; i--) {
				combArr = new int[i];
				combination(0, 10, i);
			}

			for (int c : combMax) {
				if (c > 0) return combMax;
			}
			
			return answer;
		}

		void combination(int idx, int n, int r) {
			if (r == 0) {
				// 가능한 획득점수인지 확인
				int shoot = this.n;
				int score = 0; // 라이언의 점수
				for (int i : combArr) {
					score += 10 - i;
					shoot -= info[i] + 1;
					if (shoot < 0) return; // 발사수 부족
				}

				Arrays.fill(comb, 0);
				for (int i : combArr) comb[i] = info[i] + 1; // 라이언의 슈팅
				comb[10] += shoot;

				// 점수차확인
				int apeach = 0;
				for (int i = 0; i < 11; i++) {
					if (info[i] >= comb[i] && info[i] > 0) apeach = apeach + 10 - i; // 어피치의 점수
				}

				if (max < score - apeach) {
					max = score - apeach; // 최대점수차이
					this.combMax = Arrays.copyOf(comb, comb.length);
				}

				return;
			}
			
			for (int i = idx; i <= n; i++) {
				combArr[combArr.length - r] = i;
				combination(i + 1, n, r - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		StringBuilder sb  = new StringBuilder();
	}
}
