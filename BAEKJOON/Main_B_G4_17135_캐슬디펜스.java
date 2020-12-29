package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_B_G4_17135_캐슬디펜스 {

	static int R, C, D, MAX;
    static int[][] map;

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringTokenizer tokens = new StringTokenizer(br.readLine());
        // 행
        R = Integer.parseInt(tokens.nextToken());
        // 열
        C = Integer.parseInt(tokens.nextToken());
        // 사정거리
        D = Integer.parseInt(tokens.nextToken());
        // 적군 정보
        map = new int[R][C];
        for (int r = 0; r < R; r++) {
            tokens = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(tokens.nextToken());
            }
        }
        // 만약 enemy의 r이 R이 된다면 방어 실패
        // 0<=x && x<C인 x에서 3개를 고르는 조합
        ncr(0, 0, new int[3]);
        System.out.println(MAX);
    }

    private static void check(int[] positions) {
        // 각각의 상황에 맞춰 적군을 복사해서 써야한다.
        List<Enemy> enemies = new ArrayList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] == 1) {
                    enemies.add(new Enemy(r, c));
                }
            }
        }
        // System.out.println("시작 적군 정보: " + enemies);

        // 적군의 r이 R이 되면 종료하고 카운트
        int deadMan = 0;
        while (true) {// 반복문 내가 한 턴
            // 궁수 발사
            for (int i = 0; i < positions.length; i++) {
                // pq에는 각 궁수가 쏠 수 있는 녀석이 등록됨 - 이중 한 놈만 제거 대상
                PriorityQueue<Enemy> targetedEnemies = new PriorityQueue<>();
                int archer = positions[i];
                for (int e = 0; e < enemies.size(); e++) {
                    Enemy enemy = enemies.get(e);
                    // 턴 마다 새롭게 d 계산
                    enemy.d = Math.abs(archer - enemy.c) + Math.abs(R - enemy.r);
                    // 아직 죽지 않았고 거리 내에 있다면 사망 가능 - 하지만 다른 녀석도 쏠 수 있으니까 대기
                    if (enemy.d <= D) {
                        targetedEnemies.offer(enemy);
                    }
                }
                // pq가 비어있지 않다면 맨 처음 녀석은 사망 표시
                if (!targetedEnemies.isEmpty()) {
                    targetedEnemies.poll().isTargeted = true;
                }
            }

            // 사망자 정리 및 이동, 종료 체크
            for (int e = 0; e < enemies.size(); e++) {
                Enemy enemy = enemies.get(e);
                if (enemy.isTargeted) {
                    enemies.remove(e--);// 하나 지웠다면 인덱스 조절 필요
                    deadMan++;
                } else if (enemy.r == R - 1) {//
                    enemies.remove(e--);// 끝까지 도달하면 지우고 인덱스 조절
                } else {
                    enemy.r++;
                }
            }
            // 모든 병사가 다 사망했다면.
            if (enemies.size() == 0) {
                break;
            }
        }
        MAX = Math.max(MAX, deadMan);

        // System.out.println("종료 적군 정보: " + enemies);
        // System.out.println(Arrays.toString(positions) + " : " + deadMan + " : " + MAX);
    }

    public static void ncr(int i, int s, int[] temp) {
        if (s == 3) {
//        	for(int k=0; k<3; k++) {
//        		System.out.print(temp[k]);
//        	}
//        	System.out.println();
            check(temp);
            return;
        }
        if (i == C) {
            return;
        }
        temp[s] = i;
        // ncr( 수, 자리, 배열 ) - 조합 - 중복 허용
        // 수 : 0-4, 자리 : 0-2
        ncr(i + 1, s + 1, temp);// 선택(O) - 선택했으니 다음 자리로 (s + 1) 다음 숫자
        ncr(i + 1, s, temp); // 선택(X) - 선택안했으니 같은 자리 (s)로 다음 숫자
    }

    static class Enemy implements Comparable<Enemy> {
        Integer r, c, d;// d: 궁수와의 거리
        boolean isTargeted;// 사망 여부

        public Enemy(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public String toString() {
            return "[r=" + r + ", c=" + c + ", isDead=" + isTargeted + "]";
        }

        @Override
        public int compareTo(Enemy o) {
            // 거리가 같다면 왼쪽에 있는 녀석이 화살 맞는다.
            if (d.equals(o.d)) {
                return this.c.compareTo(o.c);
            } else {
                return this.d.compareTo(o.d);
            }
        }

    }

    private static String src = "5 5 3\r\n" +
                                "1 1 1 0 1\r\n" +
                                "0 1 1 0 0\r\n" +
                                "1 1 1 0 0\r\n" +
                                "0 1 1 0 0\r\n" +
                                "1 1 1 0 0";
}
