package sumTwo;

import java.util.ArrayList;
import java.util.List;

public class add_and_pop_hny {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		add_and_pop_hny sol = new add_and_pop_hny();

		// [2,1,3,4,1] [2,3,4,5,6,7]
		// [5,0,2,7] [2,5,7,9,12]

		// int[] numbers = {2,1,3,4,1};
		int[] numbers = { 5, 0, 2, 7 };

		int[] result = sol.solution(numbers);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}

	}

	// 0 ~ 100
	public static boolean[] num = new boolean[201];

	public int[] solution(int[] numbers) {
		int[] answer = {};
		int temp = -1;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				temp = numbers[i] + numbers[j];
				if (i != j && num[temp] == false) {
					num[temp] = true;
				}
			}
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			if (num[i] == true) {
				list.add(i);
			}
		}

		answer = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}

}
