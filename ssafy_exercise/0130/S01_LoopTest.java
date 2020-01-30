package com.ssafy.subset;

public class S01_LoopTest {

	// {1, 2, 3} 으로 만들 수 있는 부분 집합
	public static void main(String[] args) {
		boolean[] selected = new boolean[4];
		for (int i = 1; i >= 0; i--) { // 1: 선택, 2: 비선택
			selected[i] = i == 1; // 1: true, 0: false
			for (int j = 1; j >= 0; j--) {
				selected[2] = (j == 1);
				for (int k = 1; k >= 0; k--) {
					selected[3] = (k == 1);
					for (int s = 1; s < selected.length; s++) {
						System.out.print((selected[s] ? s : "X") + "\t");
					}
					System.out.println();
				}
			}
		}
	}

}
