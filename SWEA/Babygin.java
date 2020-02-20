import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Babygin {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 6;
		int baby = 0;
		int[] cnt = new int[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cnt[Integer.parseInt(st.nextToken())]++;
		}
		for (int i = 0; i < N; i++) {
			if (cnt[i] >= 3) {
				cnt[i] -= 3;
				baby++;
			}
			if (i >= 2 && cnt[i] >= 1 && cnt[i - 1] >= 1 && cnt[i - 2] >= 1) {
				cnt[i] -= 1;
				cnt[i - 1] -= 1;
				cnt[i - 2] -= 1;
				baby++;
			}
		}
		if (baby == 2) System.out.println("baby-gin");
		else System.out.println("not baby-gin");	
	}
	
}
