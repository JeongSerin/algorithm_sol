package JUNGOL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_J_Be_1002_최대공약수최대공배수_정세린 {
	static int N;
	static int[] num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		StringTokenizer st = null;
		int great = 1, least = 1;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if (i == 1) {
				great = gcd(num[i - 1], num[i]);
				least = num[i - 1] * num[i] / great;
			} else if (i > 1) {
				great = gcd(num[i], great);
				least = least * num[i] / gcd(least, num[i]);
			}
		}
		System.out.print(great + " " + least);

	}

	public static int gcd(int a, int b) {
		int tmp;
		if (b > a) {
			tmp = a;
			a = b;
			b = tmp;
		}
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

}