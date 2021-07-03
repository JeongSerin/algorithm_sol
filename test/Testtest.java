package test;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Testtest {
	static int[] parents;
	
	public static void main(String[] args) {
		PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.x - o2.x;
			}
		});
		Point[] arr = {new Point(1, 3), new Point(5, 3), new Point(2, 3)};
		Arrays.sort(arr, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.x - o2.x;
			}
		});
		
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
