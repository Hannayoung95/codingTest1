package doll;

import java.util.Stack;

public class claw_machine_game_HNY {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		claw_machine_game_HNY sol = new claw_machine_game_HNY();

		// TEST CASE result 4
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } }; // 인형
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 }; // y좌표

		System.out.println("******* 결과 **************");
		System.out.println("RESULT : " + sol.solution(board, moves));
		// sol.print(board);
	}

	public void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public int solution(int[][] board, int[] moves) {
		int answer = 0;

		Stack<Integer> stack = new Stack<>();

		// 인형 가져오기
		for (int yLoc = 0; yLoc < moves.length; yLoc++) {
			int y = moves[yLoc];
			int doll = 0;

			for (int i = 0; i < board.length; i++) {
				if (board[i][y - 1] != 0) {
					doll = board[i][y - 1];
					board[i][y - 1] = 0;
					break;
				}
			}

			if (doll == 0) {
				System.out.println("인형 없습니다.");
				continue;
			}

			System.out.println("doll  : " + doll);
			System.out.println("");

			if (stack.isEmpty()) {
				stack.push(doll);
			} else {
				int curDoll = stack.pop();
				System.out.println("curDoll : " + curDoll);
				System.out.println("");

				if (doll == curDoll) {
					System.out.println("bomb!!!!!!!!!!!!");
					answer += 2;
				} else {
					stack.push(curDoll);
					stack.push(doll);
				}
			}

		}
		return answer;
	}
}
