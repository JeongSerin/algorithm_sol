package test;

import java.util.Arrays;
import java.util.Comparator;

// union find 참고
/*
 * 1. 간선을 크기순으로 정렬
 * 2. 작은 간선부터 union
 * 3. 사이클이 발생하는지 확인할 것 (union find) 
 */
public class Kruskal {
	static int[] parents;
	static int NODE = 7;	// 노드 수
	static int EDGE = 11;	// 간선 수
	static Edge[] graph;
	
	static class Edge{
		int a;
		int b;
		int weight;
		
		public Edge(int a, int b, int weight) {
			this.a = a;
			this.b = b;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [a=" + a + ", b=" + b + ", weight=" + weight + "]";
		}
		
	}
	
	public static void main(String[] args) {
		makeSet(NODE);
		
		// 간선 정보 입력
		graph = new Edge[EDGE];
		graph[0] = new Edge(1, 7, 12);
		graph[1] = new Edge(1, 4, 28);
		graph[2] = new Edge(1, 2, 67);
		graph[3] = new Edge(1, 5, 17);
		graph[4] = new Edge(2, 4, 24);
		graph[5] = new Edge(2, 5, 62);
		graph[6] = new Edge(3, 5, 20);
		graph[7] = new Edge(3, 6, 37);
		graph[8] = new Edge(4, 7, 13);
		graph[9] = new Edge(5, 6, 45);
		graph[10] = new Edge(5, 7, 73);
		
		// 1. 오름차순 정렬
		Arrays.sort(graph, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
		});
		
		int sum = 0;	// 최소비용 계산
		int selectedEdge = 0;
		// 2. union
		for (int i = 0; i < graph.length; i++) {
			boolean union = unionSet(graph[i].a, graph[i].b);
			// 합칠 수 있다 == 사이클 생성이 안된다.
			if (union) {
				sum += graph[i].weight;
				selectedEdge++;
			}
			if (selectedEdge >= NODE - 1) break;	// 간선을 모두 선택
		}
		
		System.out.println("최소비용: " + sum);
	}
	
	static void makeSet(int n) {
		parents = new int[n + 1];
		Arrays.fill(parents, -1);
	}
	
	static int findSet(int a) {
		if (parents[a] < 0) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if (aRoot == bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}

}
