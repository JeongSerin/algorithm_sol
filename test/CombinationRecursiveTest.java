/*
 * == input ==
 * N R 
 * == output ==
 * 1~n중 r개 선택
 */
package test;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationRecursiveTest {
	static int[] combArr;
	static int N, R;
	static int cnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		combArr = new int[3];
		
		combination(0, N, R);
		System.out.println("cnt = " + cnt);
		System.out.println("=== end ===");
	}
	
	static void combination(int idx, int n, int r) {
		if (r == 0) {
			System.out.println(Arrays.toString(combArr));
			cnt++;
			return;
		}
		for (int i = idx; i < n; i++) {
			combArr[R - r] = i + 1;
			combination(i + 1, n, r - 1);
		}
	}
}
