package swea;

/*
 * 20,792 kb
 * 103 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_9760_PokerGame_정세린 {	
	static int[] suit = new int[4]; 	// S, D, H, C
	static int[] rank = new int[13]; 	// 2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A 
	static int pair = 0;
	static boolean triple = false;
	static boolean fourCard = false;	
	static boolean straight = false;
	static boolean straightFlag = false;
	static boolean flush = false;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 초기화
			Arrays.fill(suit, 0);
			Arrays.fill(rank, 0);
			pair = 0;
			triple = false;
			fourCard = false;	
			straight = false;
			straightFlag = false;
			flush = false;
			
			for (int i = 0; i < 5; i++) {
				String pick = st.nextToken();
				char s = pick.charAt(0);	// suit
				char r = pick.charAt(1);	// rank
				
				switch(s) {	// suit
				case 'S': suit[0]++; break;
				case 'D': suit[1]++; break;
				case 'H': suit[2]++; break;
				case 'C': suit[3]++; break;
				}
				
				if (Character.isDigit(r)) rank[r - '2']++;	// rank
				else {
					switch(r) {
					case 'T': rank[8]++; break;
					case 'J': rank[9]++; break;
					case 'Q': rank[10]++; break;
					case 'K': rank[11]++; break;
					case 'A': rank[12]++; break;
					}
				}
			}
			
			flush();	// 플러쉬 확인
			pair();				// 페어 & 스트레이트 확인 
			
			sb.append("#" + tc + " ");
			
			if (flush && straight) sb.append("Straight Flush\n");
			else if (flush) sb.append("Flush\n");
			else if (straight) sb.append("Straight\n");
			else if (fourCard) sb.append("Four of a Kind\n");
			else if (pair == 1 && triple) sb.append("Full House\n");
			else if (triple) sb.append("Three of a kind\n");
			else if (pair == 2) sb.append("Two pair\n");
			else if (pair == 1) sb.append("One pair\n");
			else sb.append("High card\n");		
		}
		System.out.println(sb);
	}
	
	private static boolean flush() {	// 모두 동일 슈트
		for (int sNum: suit) {
			if (sNum == 5) return flush = true;
		}
		return flush = false;
	}
	
	private static void pair() {
		for (int i = 0; i < rank.length; i++) {
			if(!straightFlag && i <= rank.length - 5 && rank[i] == 1) if (straight(i)) return;	// 스트레이트 확인
			if(rank[i] == 2) pair++;	// 한쌍 있으면 페어 개수+1
			if(rank[i] == 3) triple = true;	// 트리플
			if(rank[i] == 4) {fourCard = true; return;}	// 포카드면 
		}
	}
	
	private static boolean straight(int idx) {
		straightFlag = true;
		if (idx == 0 && rank[rank.length-1] == 1) {	// 2, 3, 4, 5, A
			for (int i = idx; i < idx + 4; i++) {
				if (rank[i] != 1) return false;
			}
		}else {
			for (int i = idx; i < idx + 5; i++) {
				if (rank[i] != 1) return false;
			}	
		}
		return straight = true;
	}
	
}