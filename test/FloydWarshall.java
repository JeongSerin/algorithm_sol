package test;

import java.util.Arrays;

/*
 * 다익스트라는 일차원 배열, 시작점 설정
 * 플로이드와샬은 이차원 배열, 각 정점에서 출발, 경유지(1~n)를 통해 가는비용 비교
 * 1. 모든 정점에서 각 정점으로 가는 비용을 저장
 * 2. 각 정점을 경유지로 설정시 경유지를 통해 가는게 더 빠른지 기본게 더 빠른지 비교 갱신
 */
public class FloydWarshall {
	
	static final int INF = 10000000;
	static int number = 4;
	static int[][] map = {
							{0, 5, INF, 8},
							{7, 0, 9, INF},
							{2, INF, 0, 4},
							{INF, INF, 3, 0}
						};
	
	public static void main(String[] args) {
		floydWarshall();
	}
	
	static void floydWarshall() {
		int[][] d = new int[number][number];
		
		// 거리 배열 초기화
		for (int i = 0; i < d.length; i++) {
			d[i] = Arrays.copyOf(map[i], map[i].length);
		}
		
		// k 는 경유 노드
		for (int k = 0; k < number; k++) {
			// i는 출발 노드
			for (int i = 0; i < number; i++) {
				// j는 도착 노드
				for (int j = 0; j < number; j++) {
					// 경유지를 거치는 경유와 안거치는 경우 비교 후 비용 적은것으로 갱신
					if (d[i][k] + d[k][j] < d[i][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}
		
		for (int i = 0; i < number;i++) {
			for (int j = 0; j < number; j++) {
				System.out.print(d[i][j] + "\t");
			}
			System.out.println();
		}
		
	} // end of floydWarshall

}
