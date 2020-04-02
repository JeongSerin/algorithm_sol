package swea;

/*
1. Straight Flush : 모두 동일한 슈트/랭크 연속적(로얄 플러쉬 포함,동일한 슈트 T, J, Q, K, A)
2. Four of a Kind : 4개의 랭크 동일
3. Full House : 3장의 동일한 랭크(값)와 다른 랭크(값)의 동일한 2장으로 구성된다.
4. Flush : 5장이 모두 동일한 슈트다.
5. Straight : 다른 슈트가 섞여있으며 랭크(값)가 모두 연속적이다.
6. Three of a kind : 동일한 랭크(값)가 3장이다(1,2,3,3,3).
7. Two pair : 동일한 랭크(값) 2장씩 두개의 랭크다(2,6,6,3,3).
8. One pair : 동일한 랭크가 2장이다(2,4,5,5,7).
9. High card : 1~8번에 해당하지 않는다. 
 */
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
			
			flush = flush();	// 플러쉬 확인
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
			if (sNum == 5) return true;
		}
		return false;
	}
	
	private static void pair() {
		for (int i = 0; i < rank.length; i++) {
			if(!straight && i <= rank.length - 5 && rank[i] == 1) if (straight(i)) return;	// 스트레이트 확인
			if(rank[i] == 2) pair++;	// 한쌍 있으면 페어 개수+1
			if(rank[i] == 3) triple = true;	// 트리플
			if(rank[i] == 4) {fourCard = true; return;}	// 포카드면 
		}
	}
	
	private static boolean straight(int idx) {
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