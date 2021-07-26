package programmers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int result = sol.solution(5, 12); // 4
		System.out.println("result : " + result);
	}

	/**
	 * 
	 * @param N
	 * @param number
	 * @return
	 * 
	 *         1<= N <= 9, 1<= number <= 32000
	 * 
	 */
	public int solution(int N, int number) {
		int answer = 0;

		if (N == number) {
			answer = 1;
			return answer;
		}

		Set<Integer>[] minList = new HashSet[9]; // 최소 사용 횟수 i로 만들 수 있는 값들
		for (int i = 1; i <= 8; i++) {
			minList[i] = new HashSet<Integer>(); //
		}
		minList[1].add(N); // N 1, 5

		for (int i = 2; i <= 8; i++) {
			String tempS = "";
			int temp = 0;
			for (int j = 0; j < i; j++) { // 1, 2
				tempS += N;
			}

			temp = Integer.parseInt(tempS);
			if (temp == number) {
				return i;
			}
			minList[i].add(temp);

			for (int j = 1; j < i; j++) {
				// i가 2면, (1, 2)
				// i가 5 면, (j, i)라 할때, (1, 4), (2, 3), (3, 2), (4, 1)
				Iterator<Integer> a = minList[j].iterator(); // 1
				Iterator<Integer> b = minList[i - j].iterator(); //
				while (a.hasNext()) {
					int aNext = a.next();
					HashSet<Integer> tempList = new HashSet<Integer>();
					while (b.hasNext()) {
						int bNext = b.next();
						tempList.add(aNext + bNext);
						tempList.add(aNext - bNext);
						tempList.add(aNext * bNext);
						if (bNext != 0) {
							tempList.add(aNext / bNext);
						}
					}

					if (tempList.contains(number)) {
						return i;
					}

					minList[i].addAll(tempList);
					b = minList[i - j].iterator();
				}
			}
		}

		answer = -1;
		return answer;
	}
}
