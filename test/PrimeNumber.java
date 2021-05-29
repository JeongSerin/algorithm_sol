package test;

import java.util.Arrays;

public class PrimeNumber {
	static int MAX = 100000;
	static boolean[] isPrime = new boolean[MAX + 1];
	
	public static void main(String[] args) {
		boolean isPrimeNumber = isPrimeNumber(1);
		System.out.println(isPrimeNumber);
		
		primeNumberSieve();
	}
	
	static boolean isPrimeNumber(int n) {
		if (n <= 1) return false;
		for (int i = 2; i < (int)Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
	static void primeNumberSieve() {
		Arrays.fill(isPrime, true);
		
		for (int i = 2; i <= MAX; i++) {
			if (!isPrime[i]) continue;
			for (int j = i + i; j <= MAX; j += i) {
				isPrime[j] = false;
			}
		}
		
		for (int i = 2; i <= MAX; i++) {
			if (isPrime[i]) System.out.println(i);
		}
	}

}
