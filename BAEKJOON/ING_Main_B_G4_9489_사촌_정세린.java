package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ING_Main_B_G4_9489_사촌_정세린 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 노드의 수
			int K = Integer.parseInt(st.nextToken()); // 사촌의 수를 구해야하는 노드의 번호
			if (N == 0 && K == 0) break; // 종료조건
			
			ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
			int siblingNum = -1;
			
			st = new StringTokenizer(br.readLine(), " ");
			int before = 0;
			int groupCnt = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				int cur = Integer.parseInt(st.nextToken());
				if (i == 0) {
					tree.add(new ArrayList<Integer>());
					tree.get(cnt).add(cur);
				} else if (cur == before + 1) { // 형제를 입력 받으면
					tree.get(cnt).add(cur);
				} else if (cur > before + 1) {
					groupCnt++;
					if (cnt == 0) {
						tree.add(new ArrayList<Integer>());
						cnt++;
						tree.get(cnt).add(cur);
					} else if (groupCnt >= tree.get(cnt - 1).size()) {
						tree.add(new ArrayList<Integer>());
						cnt++;
						tree.get(cnt).add(cur);
						groupCnt = 0;
					} else if (groupCnt < tree.get(cnt - 1).size()){
						tree.get(cnt).add(cur);
					}
	 			}
				if (cur == K) siblingNum = cnt;
				
				before = cur;
			} //  end of input
			
//			System.out.println(tree.toString());
			if (siblingNum <= 1) {
				sb.append(0 + "\n");
				continue;
			}
			
			boolean flag = false;
			int brotherCnt = 1;
			L:for(int i = 0; i < tree.get(siblingNum).size() - 1; i++) {
				int curNode = tree.get(siblingNum).get(i);
				int nextNode = tree.get(siblingNum).get(i + 1);
				if (curNode == K) flag = true;
				
				if (curNode + 1 == nextNode) {
					brotherCnt++;
				} else if (curNode + 1 < nextNode) {
					if (flag) break L;
					else brotherCnt = 1;
				}
			}
			
			sb.append(tree.get(siblingNum).size() - brotherCnt + "\n");
		}
		System.out.println(sb.toString());
	} // end of main

}
