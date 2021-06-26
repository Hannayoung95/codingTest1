package codingTest1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author NAYOUNG
 * 2020. 8. 19.
 * PB_5656_removeBricks.java
 * {@code 완전탐색으로 최대한 많은 벽돌을 제거 -> 남은 벽돌의 개수 구하기}
 */
public class PB_5656_removeBricks {

	public static int x;
	public static int y;
	public static LinkedList<String> lstRoute;

	public static int[][] map;
	// 상하좌우 이동할 때 사용하는 좌표
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// 테스트케이스
		int test_case = sc.nextInt();

		for (int t = 0; t < test_case; t++) {
			// 1케이스당 쏠수 있는 구슬 횟수
			int N = sc.nextInt();
			System.out.println("shootingCnt: " + N);
			y = sc.nextInt();
			x = sc.nextInt();
			map = new int[x][y];
			lstRoute = new LinkedList<>();
			System.out.println("x : " + x);
			System.out.println("y : " + y);

			for (int i = 0; i < x; i++) {
				for (int j = 0; j < y; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 맨위에 벽돌만 깰 수 있음 -> x좌표랑 상관없고, y좌표만 고려
			// y좌표는 최대 12, N(구슬 쏘는 횟수)는 최대 4 -> 12^4 = 3만
			// 완전탐색이용, 단 N의 숫자에따라서 반복하는 횟수를 줄이기위해서 함수로 구분
			switch(N){
			case 1:
				bruFOne();
				break;
			case 2:
				bruFTwo();
				break;
			case 3:
				bruFThree();
				break;
			case 4:
				bruFFour();
				break;
			}
			// DEAD CODE
			// print(map);
		}

		sc.close();
	}
	
	/** 
	 * @param
	 * 
	 * 
	 * */
	public static void bruFOne(){
		
		// y는 w
		for(int i = 0; i<y; i++){
			testCase()
		}
		
	}
	
	// 벽돌이 있으면
//	if (map[j][i] != 0) {
//		lstRoute.add(i + "," + i + "," + map[i][j]);
//		bfs();
//	}
	public static void testCase(){
		for(int i = 0; i< x; i++){
			for(int j = 0; j< y; j++){
				if(map[i][j] != 0){
					lstRoute.add(i + "," + i + "," + map[i][j]);
					bfs();
				}
			}
			
		}
	}
	
	/** 
	 * @param
	 * 
	 * 
	 * */
	public static void bruFTwo(){
		
		// try
		// y는 w
		// y좌표들..
		for(int i = 0; i<y; i++){
			for(int j  =  0; j<y ; j++){
				// x, i, j
				// 0, 0, 0
				// 0, 0, 1
				
				
			}
		}
	}
	
	/** 
	 * @param
	 * 
	 * 
	 * */
	public static void bruFThree(){
		
		// y는 w
		for(int i = 0; i<y; i++){
			for(int j  =  0; j<y ; j++){
				
			}
			
		}
	}
	
	/** 
	 * @param
	 * 
	 * 
	 * */
	public static void bruFFour(){
		
		// y는 w
		for(int i = 0; i<y; i++){
			for(int j  =  0; j<y ; j++){
				
			}
			
		}
	}
	
	public static void bfs() {
		while(lstRoute.isEmpty()){
			String[] infos = lstRoute.poll().split(",");
			int x1 = Integer.parseInt(infos[0]);
			int y1 = Integer.parseInt(infos[1]);
			// number: 부술 수 있는 벽돌의 개수 (number-1 만큼)
			int number = Integer.parseInt(infos[2]);
			
			for(int i = 0; i<dx.length; i++){
				int x2 = dx[i] + x1;
				int y2 = dy[i] + y1;
				
				// 범위 안이면, 
				if(0<=x2 && 0<= y2 && x2< x && y2 <y){
					if(map[x2][y2] != 0){
						
						
					}
				}
			}
		}
		
	}

	public static void print(int[][] print) {
		for (int i = 0; i < print.length; i++) {
			for (int j = 0; j < print[0].length; j++) {
				System.out.println("i : " + i + ", j: " + j + "print[i][j] : " + print[i][j]);
			}
		}
	}

}
