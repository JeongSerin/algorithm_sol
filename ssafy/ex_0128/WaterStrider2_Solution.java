package ssafy.ex_0128;

import java.io.FileInputStream;
import java.util.Scanner;

public class WaterStrider2_Solution {
	
	static long Answer;
	static int N, S;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("Solution21.txt"));
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();//테스트 케이스 수  
		
		for(int test_case=1; test_case<=T; test_case++){
			N = sc.nextInt(); //배열의 크기 NxN
			int[][] lake=new int[N][N];
			
			S=sc.nextInt();//소금쟁이(Strider)수
			int[][] strider=new int[S][3];
			for(int k=0; k<S; k++){
				strider[k][0]=sc.nextInt();//행위치
				strider[k][1]=sc.nextInt();//열위치
				strider[k][2]=sc.nextInt();//방향(1:하,2:우)
			}
			//////////////////////////////
			//( 이 부분에 알고리즘 구현을 한다. )//
			//////////////////////////////
			Answer=0;
			int k=0;
			for(k=0; k<S; k++){
				int pi=strider[k][0];  //시작 위치 i
				int pj=strider[k][1];  //시작 위치 j
				int dir=strider[k][2]; //방향
				
				if(pi>=0 && pi<N && pj>=0 && pj<N){
					if(lake[pi][pj]==1) break;  //이미 누군가 뛴 자리라면
					lake[pi][pj]=1;  // 뛴 흔적 저장
					if(dir==1){//1.하
						pi=pi+3; // 처음 뛰는 행 위치
						if(pi<N){//3칸
							if(lake[pi][pj]==1) break;//이미 누군가 뛴 자리라면
							lake[pi][pj]=1;							
						}
						pi=pi+2;  // 두번째 뛰는 위치
						if(pi<N){//2칸
							if(lake[pi][pj]==1) break;//이미 누군가 뛴 자리라면
							lake[pi][pj]=1;	
						}
						pi=pi+1;
						if(pi<N){//1칸
							if(lake[pi][pj]==1) break;//이미 누군가 뛴 자리라면
							lake[pi][pj]=1;	
						}
					}else{//2.우
						
						pj=pj+3; // 처음 뛰는 행 위치
						if(pj<N){//3칸
							if(lake[pi][pj]==1) break;//이미 누군가 뛴 자리라면
							lake[pi][pj]=1;							
						}
						pj=pj+2;  // 두번째 뛰는 위치
						if(pj<N){//2칸
							if(lake[pi][pj]==1) break;//이미 누군가 뛴 자리라면
							lake[pi][pj]=1;	
						}
						pj=pj+1;
						if(pj<N){//1칸
							if(lake[pi][pj]==1) break;//이미 누군가 뛴 자리라면
							lake[pi][pj]=1;	
						}
					}
				}
			}
			if(k<S) Answer=k+1;
			System.out.println("#"+test_case+" "+Answer);
		}
	}
}
