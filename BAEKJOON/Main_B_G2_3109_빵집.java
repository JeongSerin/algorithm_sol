import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_G2_3109_빵집 {
	private static int answer, R, C;
    // 탐색 방향도 아주 중요한 문제이다.
    private static int[] dir = {-1, 0, 1};
    private static char[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokens = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());

        map = new char[R][C];

        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
        }
		
        // 각 row 별로 dfs 해보자.
        for (int r = 0; r < R; r++) {
            if (dfs(r, 0)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean dfs(int r, int c) {
        // 방문한 곳이 C-1 지점이면 끝이다.!!
        if (c == C - 1) {
            return true;
        }

        for (int d = 0; d < dir.length; d++) {
            int nr = r + dir[d];
            int nc = c + 1;
            if (isIn(nr, nc) && map[nr][nc] == '.') {
                map[nr][nc] = 'x';
                boolean result = dfs(nr, nc);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isIn(int r, int c) {
        return 0 <= r && 0 <= c && r < R && c < C;
    }

}
