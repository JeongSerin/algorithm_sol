import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_J_Im_2752_개미_정세린2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		int min, x, y;

//		min = (W - p < H - q) ? W - p : H - q;
//		t = t + min;
		x = (t / W % 2 == 1) ? (t - p) % W : W - (t - p) % W;
		y = (t / H % 2 == 1) ? (t - q) % H : H - (t - q) % H;

		System.out.println(x + " " + y);
	}

}