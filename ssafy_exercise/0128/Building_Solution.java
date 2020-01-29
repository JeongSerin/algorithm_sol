import java.util.Scanner;

//빌딩
// 8방 탐색
public class Building_Solution {

	public static void main(String[] args) {
		
		int dx[] = { 0, 1, 0, -1 , 1, 1, -1, -1};
		int dy[] = { -1, 0, 1, 0 , 1, -1, 1, -1};
		//			상, 우, 하, 좌, 우하, 좌하, 우상, 좌상
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int test = 1; test <= t; test++) {
			
			int res = 2;
			int n = sc.nextInt();
			char arr[][] = new char[n + 1][n + 1];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.next().charAt(0);
				}
			}
			boolean flag = false;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					
					flag = false;
					if (arr[i][j] == 'G')	// 'G' 는 제외
						continue;
					
					for (int k = 0; k < 8; k++) {
						
						int nexty = i + dy[k];
						int nextx = j + dx[k];
						
						if (nexty >= n || nexty < 0 || nextx >= n || nextx < 0) {
							continue;
						}
						if (arr[nexty][nextx] == 'G') {	// 주변에 'G' 있으면 8방 탐색 중지
							flag = true;
							break;
						}
					}
					
					if (flag) {	// 주변에 'G' 가 있는 경우
						continue;
					}
					
					// 이 부분은 주변에 모두 'B' 인 경우
					int nexty = i;
					int nextx = j;
					int count = 0;
					
					//4방 탐색으로 층수 계산
					for (int k = 0; k < 4; k++) {
						
						nexty = i;
						nextx = j;
						
						while (true) {
							nexty = nexty + dy[k];
							nextx = nextx + dx[k];

							if (nexty >= n || nexty < 0 || nextx >= n || nextx < 0) {
								break;
							}
							
							if (arr[nexty][nextx] == 'G')
								continue;
							
							if(nexty == i && nextx == j)
								continue;
	
							count++;
						}
					}
					if(res < count) {
						res = count;
					}

				}
			}
			System.out.printf("#%d %d\n",test, res+1);		
			}

	}

}