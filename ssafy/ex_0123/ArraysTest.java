package ssafy.ex_0123;

import java.util.Arrays;
import java.util.Collections;

public class ArraysTest {
	public static void main(String[] args) {
		int[] arr = {5, 4, 8, 3, 6};
		Arrays.sort(arr);
		
		Integer[] array1 = {5, 4, 8, 3, 6};
		Arrays.sort(array1, Collections.reverseOrder());
		
		for (Integer a : array1) {
			System.out.print(a + " ");
		}
	}
}