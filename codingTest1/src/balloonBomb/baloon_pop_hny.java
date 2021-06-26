package balloonBomb;

public class baloon_pop_hny {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		baloon_pop_hny sol = new baloon_pop_hny();

		// [9,-1,-5] 3
		// [-16,27,65,-2,58,-92,-71,-68,-61,-33] 6

		 int[] a = {9,-1,-5};
//		int[] a = { -16, 27, 65, -2, 58, -92, -71, -68, -61, -33 };

		System.out.println(sol.solution(a));
	}

	public boolean survive(int leftEndIdx, int middleIdx, int rightStartIdx, int[] a) {
		int leftTemp = Integer.MAX_VALUE;
		for (int i = 0; i <= leftEndIdx; i++) {
			if (leftTemp > a[i]) {
				leftTemp = a[i];
			}
		}

		int rightTemp = Integer.MAX_VALUE;
		for (int i = rightStartIdx; i < a.length; i++) {
			if (rightTemp > a[i]) {
				rightTemp = a[i];
			}
		}

		if (leftTemp < a[middleIdx] && rightTemp < a[middleIdx]) {
			return false;

		} else {
			return true;
		}
	}

	public int solution(int[] a) {
		int answer = 0;

		int left = -1;
		int right = -1;
		int middle = -1;

		for (int i = 0; i < a.length; i++) {
			middle = i;
			left = middle - 1;
			right = middle + 1;
			
			if(a[middle] ==  -1000000000){
				answer++;
				continue;
			}
			
			if (left < 0) {
				answer++;
				continue;
			} else if (right > a.length - 1) {
				answer++;
				continue;
			} else {
				if (survive(left, middle, right, a)) {
					answer++;
				}
			}
		}
		return answer;
	}
}
