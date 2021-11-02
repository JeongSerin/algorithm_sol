/*
테스트 1 〉	통과 (0.16ms, 61.6MB)
테스트 2 〉	통과 (0.26ms, 70MB)
테스트 3 〉	통과 (128.85ms, 138MB)
테스트 4 〉	통과 (0.22ms, 75.4MB)
테스트 5 〉	통과 (0.22ms, 59.6MB)
테스트 6 〉	통과 (2.82ms, 61.4MB)
테스트 7 〉	통과 (5.70ms, 67.2MB)
테스트 8 〉	통과 (9.24ms, 73.6MB)
테스트 9 〉	통과 (68.23ms, 131MB)
테스트 10 〉	통과 (61.97ms, 107MB)
테스트 11 〉	통과 (123.51ms, 137MB)
테스트 12 〉	통과 (0.90ms, 72.5MB)
테스트 13 〉	통과 (1.21ms, 59.1MB)
테스트 14 〉	통과 (63.61ms, 112MB)
테스트 15 〉	통과 (96.52ms, 121MB)
테스트 16 〉	통과 (0.72ms, 60.4MB)
테스트 17 〉	통과 (0.97ms, 73.2MB)
테스트 18 〉	통과 (1.40ms, 60.6MB)
테스트 19 〉	통과 (2.05ms, 70.8MB)
테스트 20 〉	통과 (71.52ms, 112MB)
테스트 21 〉	통과 (113.86ms, 139MB)
테스트 22 〉	통과 (0.10ms, 73MB)
테스트 23 〉	통과 (0.10ms, 70MB)
테스트 24 〉	통과 (0.10ms, 72.1MB)
30m

id_list	report	k	result
["muzi", "frodo", "apeach", "neo"]	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	2	[2,1,1,0]
["con", "ryan"]	["ryan con", "ryan con", "ryan con", "ryan con"]	3	[0,0]
 */
package kakao210911;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Q1 {

	class Solution {
		public int[] solution(String[] id_list, String[] report, int k) {
			int[] answer = new int[id_list.length];
			HashMap<String, Integer> map = new HashMap<>(); // 신고당한 횟수
			HashMap<String, Integer> mapIdx = new HashMap<>(); // 인덱스
			for (int i = 0; i < id_list.length; i++) {
				mapIdx.put(id_list[i], i);
				map.put(id_list[i], 0);
			}
			ArrayList<HashSet<String>> set = new ArrayList<>(); // 신고한 사람 셋
			for (int i = 0; i < id_list.length; i++) set.add(new HashSet<>());
			StringTokenizer st = null;
			for (int i = 0; i < report.length; i++) {
				st = new StringTokenizer(report[i]);
				String str1 = st.nextToken();
				String str2 = st.nextToken();
				if (set.get(mapIdx.get(str1)).add(str2)) // 신고한 사람 set에 추가
					map.put(str2, map.get(str2) + 1); // 신고당한 횟수 + 1
			}

			for (int i = 0; i < id_list.length; i++) {
				System.out.println(set.get(i));
				Iterator<String> iter = set.get(i).iterator();
				while (iter.hasNext()) {
					if (map.get(iter.next()) >= k) answer[i]++;
				}
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
