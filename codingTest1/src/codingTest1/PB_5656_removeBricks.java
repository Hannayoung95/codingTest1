package codingTest1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author NAYOUNG
 * 2020. 8. 19.
 * PB_5656_removeBricks.java
 * {@code ����Ž������ �ִ��� ���� ������ ���� -> ���� ������ ���� ���ϱ�}
 */
public class PB_5656_removeBricks {

	public static int x;
	public static int y;
	public static LinkedList<String> lstRoute;

	public static int[][] map;
	// �����¿� �̵��� �� ����ϴ� ��ǥ
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		// �׽�Ʈ���̽�
		int test_case = sc.nextInt();

		for (int t = 0; t < test_case; t++) {
			// 1���̽��� ��� �ִ� ���� Ƚ��
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

			// ������ ������ �� �� ���� -> x��ǥ�� �������, y��ǥ�� ���
			// y��ǥ�� �ִ� 12, N(���� ��� Ƚ��)�� �ִ� 4 -> 12^4 = 3��
			// ����Ž���̿�, �� N�� ���ڿ����� �ݺ��ϴ� Ƚ���� ���̱����ؼ� �Լ��� ����
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
		
		// y�� w
		for(int i = 0; i<y; i++){
			testCase()
		}
		
	}
	
	// ������ ������
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
		// y�� w
		// y��ǥ��..
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
		
		// y�� w
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
		
		// y�� w
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
			// number: �μ� �� �ִ� ������ ���� (number-1 ��ŭ)
			int number = Integer.parseInt(infos[2]);
			
			for(int i = 0; i<dx.length; i++){
				int x2 = dx[i] + x1;
				int y2 = dy[i] + y1;
				
				// ���� ���̸�, 
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
