package ssafy.ex_0129;

public class P01_LoopTest {

	// 1, 2, 3 으로 만들 수 있는 세자리수 순열
	public static void main(String[] args) {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				if (i == j) continue;
				for (int k = 1; k <=3; k++) {
					if (i == k || j == k) continue;
					System.out.println(i + " " + j + " " + k + " ");
				}
			}
		}
	}
}
