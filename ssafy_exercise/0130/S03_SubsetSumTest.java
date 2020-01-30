package com.ssafy.subset;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;

// 정수 N개를 입력받아 합이 M인 경우
public class S03_SubsetSumTest {
	static int N, M;
	static boolean[] selected;
	static int[] numbers;

	public static void main(String[] args) throws IOException {
		// 표준 입력을 바꿈, 현재 디렉토리는 프로젝트 아래
		System.setIn(new FileInputStream("Input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		토큰 " "스페이스가 디폴트, 구분자 지정해주는게 더 빠름.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt(); // 정수 개수
//		M = sc.nextInt(); // 합

		numbers = new int[N];
		selected = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
//			numbers[i] = sc.nextInt();
		}
		subset(0, 0);
	}

	private static void subset(int index, int sum) {
		// 입력 받은 수가 음수면 아래행 쓰면 안
//		if (sum > M) return;
		if (index == N) {
			if (sum == M) {
				for (int i = 0; i < N; i++) {
					if (selected[i])
						System.out.print(numbers[i] + "\t");
				}
				System.out.println();
			}
			return;
		}
		selected[index] = true; // 아래 두줄과 자리를 바꾸면
		subset(index + 1, sum + numbers[index]); // 방문

		selected[index] = false; //
		subset(index + 1, sum); // 비방문
	}

}
