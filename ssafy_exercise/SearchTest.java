package com.ssafy.gragh;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SearchTest {
	private static int[][] adjmatrix;
	private static boolean[] visited;
	private static int N;

	public static void main(String[] args) {
		N = 7;
		adjmatrix = new int[N][N];
		visited = new boolean[N];

		// 초기화가 선언을 동반하지 않으면 배열 차원 같이줘야함
		adjmatrix = new int[][] { { 0, 1, 1, 0, 0, 0, 0 }, // A의 인접 행혛
				{ 1, 0, 0, 1, 1, 0, 0 }, { 1, 0, 0, 0, 1, 0, 0 }, { 0, 1, 0, 0, 0, 1, 0 }, { 0, 1, 1, 0, 0, 1, 0 },
				{ 0, 0, 0, 1, 1, 0, 1 }, { 0, 0, 0, 0, 0, 1, 0 } };
		dfs(0);
		System.out.println();
		bfs(0);
		System.out.println();
		bfs2(0);
		System.out.println();
		dfs2(0);
	}

	private static void dfs(int current) {
		visited[current] = true;
		System.out.printf("%c", current + 65);

		for (int i = 0; i < N; i++) {
			if (adjmatrix[current][i] > 0 && !visited[i]) {
				dfs(i);
			}
		}
		visited[current] = false;
	}

	private static void bfs(int start) {
		boolean[] visited = new boolean[N];
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.offer(start);
		int current;

		while (!queue.isEmpty()) {
			current = queue.poll();
			System.out.printf("%c", current + 65);

			for (int i = 0; i < N; i++) {
				if (adjmatrix[current][i] > 0 && !visited[i]) {
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}

	private static void bfs2(int start) {
		boolean[] visited = new boolean[N];
		Queue<Integer> queue = new LinkedList<Integer>();
		visited[start] = true;
		queue.offer(start);
		int current, size;

		// 같은 깊이끼리 출력
		while (!queue.isEmpty()) {
			size = queue.size();

			while (size-- > 0) {
				current = queue.poll();
				System.out.printf("%c", current + 65);

				for (int i = 0; i < N; i++) {
					if (adjmatrix[current][i] > 0 && !visited[i]) {
						visited[i] = true;
						queue.offer(i);
					}
				}
			}
			System.out.print("//");
		}
	}

	private static void dfs2(int start) {
		boolean[] visited = new boolean[N];
		Stack<Integer> stack = new Stack<Integer>();
		visited[start] = true;
		stack.push(start);
		int current;

		// 같은 깊이끼리 출력
		while (!stack.isEmpty()) {

			current = stack.pop();
			System.out.printf("%c", current + 65);

			for (int i = 0; i < N; i++) {
				if (adjmatrix[current][i] > 0 && !visited[i]) {
					visited[i] = true;
					stack.push(i);

				}
			}
		}
	}

}
