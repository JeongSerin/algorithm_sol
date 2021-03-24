/*
 * 69208KB
 * 428ms
 * 1H
 * 조합으로 궁수를 뽑은뒤
 * pq를 이용, 가까운거리의 적부터
 * (같은 거리는 왼쪽적부터, 궁수는 동시에 공격함)
 */
package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_B_G4_17135_캐슬디펜스_정세린 {
	static int N, M; // N * M
	static int D; // 거리
	static int max = 0; // 제거할수 있는 적, 최대
	static int[][] map;
	static int[][] mapCopy;
	static int[] archer = new int[3];
	static class Point {
		int i, j, dist;

		public Point(int i, int j, int dist) {
			this.i = i;
			this.j = j;
			this.dist = dist;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];
		mapCopy = new int[N + 1][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of input
		
		// 1. 궁수 3명 배치 (조합)
		combination(0, M, 3);
		
		System.out.println(max);
	} // end of main
	
	static void combination(int idx, int n, int r) {
		if (r == 0) {
			// 2. 공격
			attack();
			return;
		}
		
		for (int i = idx; i < n; i++) {
			archer[r - 1] = i;
			combination(i + 1, n, r - 1);
		}
	} // end of combination()
	
	static void attack() {
		// 배열 복사해두기
		for (int i = 0; i <= N; i++) 
			mapCopy[i] = Arrays.copyOf(map[i], map[i].length);
		
		int ipos = N; // 궁사의 초기 위치
		int cnt = 0; // 물리친 적의 수
		
		L:while (ipos > 0) {
			Point[] enemy = new Point[3];
			
			for (int a = 0; a < 3; a++) { // 궁수 3명
				int jpos = archer[a];
				mapCopy[ipos][jpos] = 2;
				PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
					@Override
					public int compare(Point o1, Point o2) {
						int tmp = o1.dist - o2.dist;
						if (tmp == 0) return o1.j - o2.j; // 거리가 같으면 왼쪽적부터
						return tmp;
					}
				});
				
				for (int i = 0; i < ipos; i++) { // 적들 거리를 알기 위함
					for (int j = 0; j < M; j++) {
						if (mapCopy[i][j] == 0) continue; // 빈칸이면 pass
						int dist = Math.abs(ipos - i) + Math.abs(jpos - j);
						pq.offer(new Point(i, j, dist));
					}
				}
				
				// 적이 없음
				if (pq.isEmpty()) break L;
				
				enemy[a] = pq.poll(); // 가장 가까운 적
			}
			
			// 적을 물리침
			for (int a = 0; a < 3; a++) {
				if (mapCopy[enemy[a].i][enemy[a].j] == 1 && enemy[a].dist <= D) { // 적이 남아있고, 거리가 닿으면
					mapCopy[enemy[a].i][enemy[a].j] = 0;
					cnt++;
				}
			}
 			
			ipos--; // 궁사가 한칸 올라감
		} // end of while
		
		max = Math.max(max, cnt);
	} // end of attack()
	
}
