package workoutClothes;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		// n : 전체학생의 수
		// lost : 도난당한 학생들의 번호
		// reserve : 여벌을 가져온 학생들의 번호
		// 수업을 들을수 있는 학생의 수
		// n lost reserve return
		// 5 [2, 4] [1, 3, 5] 5
		// 5 [2, 4] [3] 4
		// 3 [3] [1] 2

		// int n = 5;
		// int[] lost = { 2, 4 };
		// int[] reserve = { 1, 3, 5 };
//		int[] lost = { 2, 4 };
//		int[] reserve = { 3 };
		int n = 3;
		int[] lost = { 3 };
		int[] reserve = { 1 };
		int result = sol.solution(n, lost, reserve);
		System.out.println("result : " + result);
	}

	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		answer = n - lost.length;
		boolean[] lostB = new boolean[lost.length];
		boolean[] reserB = new boolean[reserve.length];

		int cnt = 0;
		
		
		for (int i = 0; i < lost.length; i++) { // 잃어버린애들
			for (int j = 0; j < reserve.length; j++) { // 갖고있는거
				if(lost[i] == reserve[j]){
					lostB[i] = true;
					reserB[j] = true;
					cnt++;
					break;
				}
			}
		}
		for (int i = 0; i < lost.length; i++) { // 잃어버린애들
			for (int j = 0; j < reserve.length; j++) { // 갖고있는거
				if ((lost[i] - 1) == reserve[j]) {
					if (!reserB[j] && !lostB[i]) {
						lostB[i] = true;
						reserB[j] = true;
						cnt++;
						break;
					}
				}
				if (lost[i] == reserve[j]) {
					if (!reserB[j] && !lostB[i]) {
						lostB[i] = true;
						reserB[j] = true;
						cnt++;
						break;
					}
				}

				if ((lost[i] + 1) == reserve[j]) {
					if (!reserB[j] && !lostB[i]) {
						lostB[i] = true;
						reserB[j] = true;
						cnt++;
						break;
					}
				}
			}
		}
//		System.out.println("cnt : " + cnt);
		answer += cnt;
		return answer;
	}

}
