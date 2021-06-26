package kNumber;

public class maxNumberBackup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxNumberBackup sol = new maxNumberBackup();
//		int[] array  = {3, 30, 34, 5, 9};
		int[] array  = {3, 30, 34};
		sol.solution(array);
		System.out.println("max : " + max);
	}

	public static int max = 0;
	public String solution(int[] numbers) {
		String answer = "";

		boolean[] visited = new boolean[numbers.length];
		int[] temp = new int[numbers.length];
		
		// 0 만 있는경우 0 리턴
		
		makePermut(numbers.length, temp, 0, visited, numbers);
		answer = Integer.toString(max);
		return answer;
	}

	public void makePermut(int r, int[] temp, int c, boolean[] visited, int[] numbers) {
		if (r == c) {
			StringBuffer sb = new StringBuffer();
			for(int next : temp){ // char로 변경
				sb.append(next);
			}
			int result = Integer.parseInt(sb.toString());
			if(max < result)
				max = result;
			return;
		} else { 
			for (int i = 0; i < numbers.length; i++) {
				if(!visited[i]){
					visited[i] = true;
					temp[c] = numbers[i];
					makePermut(r, temp, c +1, visited, numbers);
					visited[i] = false;
				}
			}

		}
	}


}
