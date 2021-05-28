package ssafy.ex_0129;

import java.util.Arrays;
import java.util.Scanner;

public class P04_NextPermutationTest {
	static int N;
	static int[] input;
	static int totalCnt;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		input = new int[N];
		for(int i = 0; i < N; ++i)
			input[i] = sc.nextInt();
		Arrays.sort(input);
		
		do {
			System.out.println(Arrays.toString(input));
		}while(nextPermutation());
		System.out.println("총 경우의 수 : "+totalCnt);
	}
	
	static boolean nextPermutation() {
		totalCnt++;
		
		int i = N-1;
		while(i>0 && input[i-1]>=input[i]) --i;
		if(i==0) return false;
		
		int j = N-1;
		while(input[i-1] >= input[j]) --j;
		
		int ti = input[j];
		input[j]=input[i-1];
		input[i-1]=ti;
		
		int k = N-1;
		while(i<k) {
			ti=input[i];
			input[i]=input[k];
			input[k]=ti;
			
			++i;	--k;
		}
		
		return true;
	}
}
