package test;

import java.util.Arrays;

/*
 * 특정한 하나의 정점에서 다른 모든 정점으로 가는 최단 경로를 알려줌
 * 음의 간선은 포함할 수 없음
 * 하나의 최단거리를 구할 때 그 이전 까지 구했던 최단 거리 정보를 그대로 사용
 * DP로 볼 수 있음
 * 1. 출발 노드를 설정함
 * 2. 출발 노드를 기준으로 각 노드의 최소 비용을 저장
 * 3. 방문하지 않은 노드 중에서 가장 비용이 적은 노드를 선택함
 * 4. 해당 노드를 거쳐서 특정한 노드로 가는 경우를 고려하여 최소 비용을 갱신
 * 5. 위 과정에서 3~4번을 반복 
 */
public class Dijkstra {
	// 1. 출발지는 0번 노드로 함.
	static int size = 6;
	static final int INF = 100000;
	static int[][] map = {
			{0, 2, 5, 1, INF, INF},
			{2, 0, 3, 2, INF, INF},
			{5, 3, 0, 3, 1, 5},
			{1, 2, 3, 0, 1, INF},
			{INF, INF, 1, 1, 0, 2},
			{INF, INF, 5, INF, 2, 0}
	};
	static boolean[] visited = new boolean[size];	// 방문 관리
	static int[] dist = new int[size];	// 최단거리 조장
	
	public static void main(String[] args) {
		dijkstra(0);
		System.out.println(Arrays.toString(dist));
	}
	
	// 가장 최소 거리를 가지는 정점을 반환
	static int getSmallIndex() {
		int min = INF;
		int idx = 0;
		
		for (int i = 0; i < size; i++) {
			if (dist[i] < min && !visited[i]) {
				min = dist[i];
				idx = i;
			}
		}
		
		return idx;
	}
	
	// 다익스트라 수행 함수
	static void dijkstra (int start) {
		for (int i = 0; i < size; i++) {
			dist[i] = map[start][i];
		}
		visited[start] = true;
		
		for (int i = 0; i < size - 2; i++) {
			int cur = getSmallIndex();
			visited[cur] = true;
			
			for (int j = 0; j < 6; j++) {
				if (!visited[j]) {
					if (dist[cur] + map[cur][j] < dist[j]) {
						dist[j] = dist[cur] + map[cur][j];
					}
				}
			}
		}
	}
}
