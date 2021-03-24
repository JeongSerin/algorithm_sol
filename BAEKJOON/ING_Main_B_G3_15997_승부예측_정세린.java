package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ING_Main_B_G3_15997_승부예측_정세린 {
	static Country[] counties = new Country[4];
	static HashMap<String, Double> map = new HashMap<>(); // 나라, 점수
	static class Country {
		int idx;
		String country;
		double score;
		double prob;
		
		public Country(int idx, String country, Double score, double prob) {
			this.idx = idx;
			this.country = country;
			this.score = score;
			this.prob = prob;
		}

		@Override
		public String toString() {
			return "Country [idx=" + idx + ", country=" + country + ", score=" + score + ", prob=" + prob + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			counties[i] = new Country(i, st.nextToken(), 0.0, 0.0);
			map.put(counties[i].country, 0.0);
		}
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String A = st.nextToken(); // 나라A
			String B = st.nextToken(); // 나라B
			double W = Double.parseDouble(st.nextToken()); // A가 이길 확률
			double D = Double.parseDouble(st.nextToken()); // 비길확률
			double L = Double.parseDouble(st.nextToken()); // 질 확률
			
			double scoreA = map.get(A) + (W * 3) + (D * 1);
			double scoreB = map.get(B) + (D * 1) + (L * 3);
			map.put(A, scoreA);
			map.put(B, scoreB);
		}
		
		for (int i = 0; i < 4; i++) {
			String country = counties[i].country;
			counties[i] = new Country(i, country, map.get(country), 0.0);
		}
		
		Arrays.sort(counties, new Comparator<Country>() {
			@Override
			public int compare(Country o1, Country o2) {
				double tmp = o1.score - o2.score;
				if (tmp > 0) return -1;
				else return 1;
			}
		});
		
		double s1 = counties[0].score;
		double s2 = counties[1].score;
		double s3 = counties[2].score;
		double s4 = counties[3].score;
		
		double max = 1.0;
		if (s2 > s3) {
			counties[0].prob = max;
			counties[1].prob = max;
			counties[2].prob = max*0;
			counties[3].prob = max*0;
		} else if (s2 == s3 && s3 > s4){
			counties[0].prob = max;
			counties[1].prob = max/2;
			counties[2].prob = max/2;
			counties[3].prob = max*0;
		} else if (s1 == s2 && s2 == s3 && s3 > s4) {
			counties[0].prob = max/3;
			counties[1].prob = max/3;
			counties[2].prob = max/3;
			counties[3].prob = max*0;
		} else if (s1 > s2 && s2 == s3 && s3 == s4) {
			counties[0].prob = max;
			counties[1].prob = max/3;
			counties[2].prob = max/3;
			counties[3].prob = max/3;
		} else if (s1 == s2 && s2 == s3 && s3 == s4) {
			counties[0].prob = max/4;
			counties[1].prob = max/4;
			counties[2].prob = max/4;
			counties[3].prob = max/4;
		}
		
		Arrays.sort(counties, new Comparator<Country>() {
			@Override
			public int compare(Country o1, Country o2) {
				return o1.idx - o2.idx;
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			sb.append(counties[i].prob + "\n");
		}
		
		System.out.println(sb.toString());
	} // end of main

}
