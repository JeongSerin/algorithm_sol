import java.util.HashSet;
import java.util.Scanner;
/**
 * 메모리 41,448 kb
 * 실행시간 180 ms
 * 코드길이 1,167
 */
public class Solution_D3_1244_최대상금_김태희 {
	private static int max,num[];
	private static HashSet<String> s = new HashSet<String>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			String s = sc.next();
			num = new int[s.length()];
			for (int i = 0; i < s.length(); i++) {
				num[i] = s.charAt(i) - '0';
			}
			int N = sc.nextInt(); 
			max = 0;
			find(N);
			
			System.out.println("#"+testCase+" "+max);
		} // end of for testCase
	} // end of main
	public static void find(int N) {
		int val = 0;
		for (int i = 0; i < num.length; i++) {
			val = val*10 + num[i];
		}
		if (s.contains(""+val+N)) return; // 같은 배열형태의 교환횟수가 같은 경우가 있었다면 가지치기
			
		s.add(""+val+N);
		if (N == 0) {
			if (max < val) max = val;
			return;
		} 
		for (int i = 0; i < num.length-1; i++) {
			for (int j = i+1; j < num.length; j++) {
				int temp = num[i];
				num[i] = num[j];
				num[j] = temp;
				find(N-1);
				temp = num[i];
				num[i] = num[j];
				num[j] = temp;
			}
		}
	}
} // end of class
