package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B_G5_5569_출근경로_정세린 {
	
	static class Point{
		int x;
		int y;
		
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int mod = 100000;
		int[][][][] memo = new int[W + 1][H + 1][2][2];	// x, y, dh(북동), flag=같은 방향으로 움직인 횟수

		for (int i = 2; i <= W; i++) memo[i][1][0][0] = 1;
		for (int i = 2; i <= H; i++) memo[1][i][1][0] = 1;
		
		for (int x = 2; x <= W; x++) {
			for (int y = 2; y <= H; y++) {
				// 북쪽으로 가고 있는데 이번 단계에서 바향을 바꾸지 않았다. 
				// 이전 단계에서 가능한 경우 1) 이전 단계에서도 북쪽으로 가고 있으며 방향을 바꾸지 않았다.
				// 		       2) 이전단계에서 방향을 북쪽으로 바꿨다.
				memo[x][y][0][0] = (memo[x-1][y][0][0] + memo[x-1][y][0][1]) % mod;
				
				// 북쪽으로 가고 있는데 이번 단계에서 방향을 바꿨다.
				// 이전 단계에서 가능한 경우 1) 이전 단계에서 방향을 바꾸지 않았으며, 동쪽으로 가고있었다.
				memo[x][y][0][1] = memo[x-1][y][1][0] % mod;
				
				// 동쪽으로 가고 있는데 이번 단계에서 방향을 바꾸지 않았다.
				// 이번 단계에서 가능한 경우 1) 이전 단계에서도 동쪽으로 가고있고 방향을 바꾸지 않았다.
				// 		       2) 이전 단계에서 동쪽으로 방향을 바꿨다.
				memo[x][y][1][0] = (memo[x][y-1][1][0] + memo[x][y-1][1][1]) % mod;
				
				// 동쪽으로 가고 있는데 이번 단계에서 방향을 바꾸지 않았다.
				// 이전 단계에서 가능한 경우 1) 이전 단계에서 방향을 바꾸지 않았으며, 북쪽으로 가고있었다.
				memo[x][y][1][1] = memo[x][y-1][0][0] % mod;}
		}
		
		int res = memo[W][H][0][0] + memo[W][H][0][1] + memo[W][H][1][0] + memo[W][H][1][1];
		
		System.out.println(res % mod);
	}
	
}
