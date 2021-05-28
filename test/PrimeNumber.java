package test;

public class PrimeNumber {

	
	public static void main(String[] args) {
		boolean isPrimeNumber = isPrimeNumber(1);
		System.out.println(isPrimeNumber);
	}
	
	static boolean isPrimeNumber(int n) {
		if (n <= 1) return false;
		for (int i = 2; i < (int)Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}
		return true;
	}

}
